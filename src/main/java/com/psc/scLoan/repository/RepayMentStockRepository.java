package com.psc.scLoan.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fori.jdbc.ClassRowMapperFactory;
import com.fori.jdbc.SimpleJdbc;
import com.psc.scLoan.model.RepayMentStock;

@Repository
public class RepayMentStockRepository {

	@Autowired
	private SimpleJdbc simpleJdbc;

	private final String REPAY_MENT_STOCK = "repayMentStock";

	public List<RepayMentStock> qryRepayMentStock(String userId) throws Exception {

		Object[] args = { userId };

		StringBuffer sb = new StringBuffer();

		sb.append("select * from ");

		sb.append(REPAY_MENT_STOCK);

		sb.append(" where userId = ? ");

		return simpleJdbc.query(sb.toString(), args, ClassRowMapperFactory.get(RepayMentStock.class));
	}

}
