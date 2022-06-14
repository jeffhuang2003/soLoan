package com.psc.scLoan.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fori.jdbc.ClassRowMapperFactory;
import com.fori.jdbc.SimpleJdbc;
import com.psc.scLoan.model.RepayMentCash;

@Repository
public class RepayMentCashRepository {

	@Autowired
	private SimpleJdbc simpleJdbc;

	private final String REPAY_MENT_CASH = "repayMentCash";

	public RepayMentCash qryRepayMentCash(String userId, String year, String month) throws Exception {
		Object[] args = { userId, year, month };

		StringBuffer sb = new StringBuffer();

		sb.append("select * from ");
		
		sb.append(REPAY_MENT_CASH);
		
		sb.append(" where userId = ? and repayMentYear = ? and repayMentMonth = ? ");

		return simpleJdbc.getFirst(simpleJdbc.query(sb.toString(), args, ClassRowMapperFactory.get(RepayMentCash.class)));
	}

	public RepayMentCash qryRepayMentCashAll(String userId) throws Exception {
		Object[] args = { userId };

		StringBuffer sb = new StringBuffer();

		sb.append("select * from ");
		
		sb.append(REPAY_MENT_CASH);
		
		sb.append(" where userId = ? ");

		return simpleJdbc.getFirst(simpleJdbc.query(sb.toString(), args, ClassRowMapperFactory.get(RepayMentCash.class)));
	}

}
