package com.psc.scLoan.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psc.scLoan.api.ui.RepayMentUI;
import com.psc.scLoan.model.RepayMentCash;
import com.psc.scLoan.model.RepayMentDetail;
import com.psc.scLoan.model.RepayMentStock;
import com.psc.scLoan.repository.RepayMentCashRepository;
import com.psc.scLoan.repository.RepayMentDetailRepository;
import com.psc.scLoan.repository.RepayMentStockRepository;

@Service
public class RepayMentService {

	@Autowired
	private RepayMentCashRepository repayMentCashRepository;

	@Autowired
	private RepayMentStockRepository repayMentStockRepository;

	@Autowired
	private RepayMentDetailRepository repayMentDetailRepository;

	@Autowired
	private TelegramService telegramService;

	/**
	 * 查詢現金還款畫面
	 * 
	 * @param userId
	 * @param year
	 * @param month
	 * @return
	 * @throws Exception
	 */
	public RepayMentUI repayMentCashQry(String userId, String year, String month) throws Exception {

		RepayMentUI repayMentUI = new RepayMentUI();

		RepayMentCash repayMentCash = repayMentCashRepository.qryRepayMentCash(userId, year, month);

		repayMentUI.setRepayMentCash(repayMentCash);

		return repayMentUI;
	}

	/**
	 * 查詢現金還款畫面 (全部還款)
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public RepayMentUI repayMentCashQryAll(String userId) throws Exception {

		RepayMentUI repayMentUI = new RepayMentUI();

		RepayMentCash repayMentCash = repayMentCashRepository.qryRepayMentCashAll(userId);

		repayMentUI.setRepayMentCash(repayMentCash);

		return repayMentUI;
	}

	/**
	 * 查詢賣股還款
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public RepayMentUI rayMentStockQry(String userId) throws Exception {

		RepayMentUI repayMentUI = new RepayMentUI();

		List<RepayMentStock> repayMentStock = repayMentStockRepository.qryRepayMentStock(userId);

		repayMentUI.setRepayMentStockList(repayMentStock);

		return repayMentUI;
	}

	/**
	 * 現金還款 一般帳戶 寫入還款明細
	 * 
	 * <pre>
	 * 	一般帳戶寫入還款明細 狀態押未核准(由財行確認押入成功狀態)
	 * </pre>
	 * 
	 * @param userId
	 * @param repayAll
	 * @param month
	 * @param year
	 * @throws Exception
	 */
	public void addRayMentDetailCashGeneralAccount(String userId, String year, String month, Boolean repayAll) throws Exception {
		RepayMentCash repayMentCash;

		if (repayAll) {
			repayMentCash = repayMentCashRepository.qryRepayMentCash(userId, year, month);
		} else {
			repayMentCash = repayMentCashRepository.qryRepayMentCashAll(userId);
		}

		RepayMentDetail repayMentDetail = new RepayMentDetail();

		repayMentDetail.setUserId(userId);
		repayMentDetail.setRepayMentYear(year);
		repayMentDetail.setRepayMentMonth(month);
		repayMentDetail.setRepayMentAmount(repayMentCash.getRepayMentTotalAmt());
		repayMentDetail.setRepayMentInterest(repayMentCash.getRepayMentInterest());

		repayMentDetail.setStatus("0");

		Timestamp now = new Timestamp(new Date().getTime());
		repayMentDetail.setRestDate(now);
		repayMentDetail.setRepayMentDate(now);
		repayMentDetail.setUpdateDate(now);

		repayMentDetailRepository.insert(repayMentDetail);
	}

	/**
	 * 現金還款 分戶帳 寫入還款明細
	 * 
	 * <pre>
	 * 1.分戶帳 狀態押未核准                    
	 * 2.CALL 電文 判斷是否補單成功              
	 * 3.補單成功                          
	 * 4.call 電文 對帳戶進行扣款               
	 * 5.成功 顯示 還款成功 狀態押成功              
	 * 6.失敗 顯示 還款失敗  && call 電文 刪單
	 * </pre>
	 * 
	 * @param userId
	 * @param repayAll
	 * @param month
	 * @param year
	 * @throws Exception
	 * 
	 */
	@Transactional
	public String addRayMentDetailCashBranchAccount(String userId, String year, String month, Boolean repayAll) throws Exception {

		// 1.分戶帳 狀態押未核准
		RepayMentCash repayMentCash;

		if (repayAll) {
			repayMentCash = repayMentCashRepository.qryRepayMentCash(userId, year, month);
		} else {
			repayMentCash = repayMentCashRepository.qryRepayMentCashAll(userId);
		}

		RepayMentDetail repayMentDetail = new RepayMentDetail();

		String uuid = UUID.randomUUID().toString();

		repayMentDetail.setId(uuid);
		repayMentDetail.setUserId(userId);
		repayMentDetail.setRepayMentYear(year);
		repayMentDetail.setRepayMentMonth(month);
		repayMentDetail.setRepayMentAmount(repayMentCash.getRepayMentTotalAmt());
		repayMentDetail.setRepayMentInterest(repayMentCash.getRepayMentInterest());

		repayMentDetail.setStatus("0");

		Timestamp now = new Timestamp(new Date().getTime());
		repayMentDetail.setRestDate(now);
		repayMentDetail.setRepayMentDate(now);
		repayMentDetail.setUpdateDate(now);

		repayMentDetailRepository.insert(repayMentDetail);

		// 2.CALL 電文 判斷是否補單成功
		if (telegramService.reissueDocuments()) {
			// 3.補單成功

			// 4.call 電文 對帳戶進行扣款
			telegramService.doDebit();

			// 5.成功 顯示 還款成功 狀態押成功
			repayMentDetailRepository.updateStatus(uuid, "1");

			return "還款成功";
		} else {
			// 6.失敗 顯示 還款失敗 && call 電文 刪單
			telegramService.removeDocuments();
			return "還款失敗";
		}

	}

	/**
	 * 賣股還款 分戶帳 寫入還款明細
	 * 
	 * <pre>
	 *  1.分戶帳 狀態押未核准                            
	 *  2.CALL 電文 判斷是否補單成功                      
	 *  3.補單成功 執行K10指令(用子方法代替) 顯示退還擔保品成功、還款成功   
	 *  4.補單失敗  顯示退還擔保品失敗、還款失敗 && call 電文 刪單
	 * </pre>
	 * 
	 * @param userId
	 * @param repayMentStockList
	 */
	public String addRayMentDetailStockBranchAccount(String userId, List<RepayMentStock> repayMentStockList) {

		if (telegramService.reissueDocuments()) {

			// 3.補單成功 執行K10指令(用子方法代替) 顯示退還擔保品成功、還款成功

			return "";
		} else {
			return "還款失敗";
		}

	}

	public RepayMentUI qryCustomerInfo(String userId) throws Exception {
		RepayMentUI repayMentUI = new RepayMentUI();

		RepayMentCash repayMentCash = repayMentCashRepository.qryRepayMentCashAll(userId);

		List<RepayMentStock> repayMentStock = repayMentStockRepository.qryRepayMentStock(userId);

		repayMentUI.setRepayMentCash(repayMentCash);
		
		repayMentUI.setRepayMentStockList(repayMentStock);
		
		return repayMentUI;
	}

}
