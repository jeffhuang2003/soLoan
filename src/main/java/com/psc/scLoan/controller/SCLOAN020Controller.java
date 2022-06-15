package com.psc.scLoan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fori.util.LogUtil;
import com.psc.scLoan.api.form.RepayMentForm;
import com.psc.scLoan.api.result.BasicResult;
import com.psc.scLoan.api.ui.RepayMentUI;
import com.psc.scLoan.config.PropConfig;
import com.psc.scLoan.constants.MessageConstants;
import com.psc.scLoan.model.RepayMentStock;
import com.psc.scLoan.service.RepayMentService;
import com.psc.scLoan.service.UserProfService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * 
 * @author wunhow
 * 
 */
@RestController
@RequestMapping("/SCLOAN020")
@Api(tags = "SCLOAN020-還款申請")
public class SCLOAN020Controller {

	@Autowired
	private PropConfig fileConfig;

	@Autowired
	private UserProfService userProfService;

	@Autowired
	private RepayMentService repayMentService;

	@GetMapping("/health")
	@ApiOperation(value = "/health", notes = "")
	@ApiResponses({ @ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 404, message = "系統異常") })
	public BasicResult<String> health() {
		BasicResult<String> resultObj = new BasicResult<String>();
		try {
			resultObj.setItem(MessageConstants.MESSAGE_SYSTEM_HEALTH_NORMALY);
		} catch (Exception e) {
			LogUtil.setErrorLog("/health", e);
			resultObj.setSystemError();
		}
		return resultObj;
	}

	@GetMapping("/repayMentCashQry")
	@ApiOperation(value = "/repayMentCashQry", notes = "")
	@ApiResponses({ @ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 404, message = "系統異常") })
	public BasicResult<RepayMentUI> repayMentCashQry(@RequestBody RepayMentForm repayMentForm) {
		BasicResult<RepayMentUI> resultObj = new BasicResult<RepayMentUI>();
		try {

			RepayMentUI repayMentUI;

			if (repayMentForm.getRepayAll()) {

				
				repayMentUI = repayMentService.repayMentCashQryAll(repayMentForm.getUserId());

			} else {

				repayMentUI = repayMentService.repayMentCashQry(repayMentForm.getUserId(), repayMentForm.getYear(), repayMentForm.getMonth());

			}

			resultObj.setItem(repayMentUI);

		} catch (Exception e) {
			LogUtil.setErrorLog("/health", e);
			resultObj.setSystemError();
		}
		return resultObj;
	}

	@GetMapping("/rayMentStockQry")
	@ApiOperation(value = "/rayMentStockQry", notes = "")
	@ApiResponses({ @ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 404, message = "系統異常") })
	public BasicResult<RepayMentUI> rayMentStockQry(@RequestBody RepayMentForm repayMentForm) {
		BasicResult<RepayMentUI> resultObj = new BasicResult<RepayMentUI>();
		try {

			RepayMentUI repayMentUI = repayMentService.rayMentStockQry(repayMentForm.getUserId());

			resultObj.setItem(repayMentUI);

		} catch (Exception e) {
			LogUtil.setErrorLog("/health", e);
			resultObj.setSystemError();
		}
		return resultObj;
	}

	@GetMapping("/addRayMentDetail")
	@ApiOperation(value = "/addRayMentDetail", notes = "")
	@ApiResponses({ @ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 404, message = "系統異常") })
	public BasicResult<String> addRayMentDetail(@RequestBody RepayMentForm repayMentForm) {
		BasicResult<String> resultObj = new BasicResult<String>();
		try {
			
			String userId = repayMentForm.getUserId();
			
			String repayType = repayMentForm.getRepayType().toLowerCase();
			
			String year = repayMentForm.getYear();
			
			String month = repayMentForm.getMonth();
			
			//判斷還款方式為 現金/賣股
			if (repayType.equals("cash")) {
				
				String accountType = repayMentForm.getAccountType().toLowerCase();
				
				Boolean repayAll = repayMentForm.getRepayAll();
				
				//現金還款 判斷帳戶類別(一般帳戶/分戶帳) 寫入還款明細
				if(accountType.equals("general")) {
					
					//一般帳戶
					repayMentService.addRayMentDetailCashGeneralAccount(userId, year, month, repayAll);
					
				} else if (accountType.equals("branch")) {
					
					//分戶帳
					/**
					 *  1.分戶帳 狀態押未核准
					 *  2.CALL 電文 判斷是否補單成功
					 *  3.補單成功 
					 *  4.call 電文 對帳戶進行扣款
					 *  5.成功 顯示 還款成功 狀態押成功
					 *  6.失敗 顯示 還款失敗  && call 電文 刪單
					 */
					
					repayMentService.addRayMentDetailCashBranchAccount(userId, year, month, repayAll);
					
				}
			} else if (repayType.equals("stock")) {
				//賣股還款 分戶帳 寫入還款明細
					//分戶帳
						/**
						 *  1.分戶帳 狀態押未核准
						 *  2.CALL 電文 判斷是否補單成功
						 *  3.補單成功 執行K10指令(用子方法代替) 顯示退還擔保品成功、還款成功
						 *  4.補單失敗  顯示退還擔保品失敗、還款失敗 && call 電文 刪單
						 */
				List<RepayMentStock> repayMentStockList = repayMentForm.getRepayMentStockList();
				repayMentService.addRayMentDetailStockBranchAccount(userId, repayMentStockList);
			}
		} catch (Exception e) {
			LogUtil.setErrorLog("/health", e);
			resultObj.setSystemError();
		}
		return resultObj;
	}
	
	@GetMapping("/qryCustomerInfo")
	@ApiOperation(value = "/qryCustomerInfo", notes = "")
	@ApiResponses({ @ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 404, message = "系統異常") })
	public BasicResult<RepayMentUI> qryCustomerInfo(@RequestBody RepayMentForm repayMentForm) {
		BasicResult<RepayMentUI> resultObj = new BasicResult<RepayMentUI>();
		try {
             //查詢帳戶還款資訊
			
			String userId = repayMentForm.getUserId();
			
			RepayMentUI repayMentUI = repayMentService.qryCustomerInfo(userId);
			
			resultObj.setItem(repayMentUI);
			
		} catch (Exception e) {
			LogUtil.setErrorLog("/health", e);
			resultObj.setSystemError();
		}
		return resultObj;
	}
}
