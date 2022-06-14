package com.psc.scLoan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psc.scLoan.api.ui.RepayMentUI;
import com.psc.scLoan.model.RepayMentCash;
import com.psc.scLoan.model.RepayMentStock;
import com.psc.scLoan.repository.RepayMentCashRepository;
import com.psc.scLoan.repository.RepayMentStockRepository;

@Service
public class RepayMentService {

	@Autowired
	private RepayMentCashRepository repayMentCashRepository;

	@Autowired
	private RepayMentStockRepository repayMentStockRepository;

	public RepayMentUI repayMentCashQry(String userId, String year, String month) throws Exception {
		
		RepayMentUI repayMentUI = new RepayMentUI();
		
		RepayMentCash repayMentCash = repayMentCashRepository.qryRepayMentCash(userId, year, month);
		
		repayMentUI.setRepayMentCash(repayMentCash);
		
		return repayMentUI;
	}

	public RepayMentUI repayMentCashQryAll(String userId) throws Exception {
		
		RepayMentUI repayMentUI = new RepayMentUI();
		
		RepayMentCash repayMentCash = repayMentCashRepository.qryRepayMentCashAll(userId);
		
		repayMentUI.setRepayMentCash(repayMentCash);
		
		return repayMentUI;
	}

	public RepayMentUI rayMentStockQry(String userId) throws Exception {

		RepayMentUI repayMentUI = new RepayMentUI();

		List<RepayMentStock> repayMentStock = repayMentStockRepository.qryRepayMentStock(userId);

		repayMentUI.setRepayMentStockList(repayMentStock);

		return repayMentUI;
	}

}
