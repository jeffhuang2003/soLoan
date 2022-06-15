package com.psc.scLoan.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.fori.jdbc.SimpleJdbc;
import com.psc.scLoan.model.RepayMentDetail;

@Repository
public class RepayMentDetailRepository {

	private SimpleJdbcInsert simpleJdbcInsert;

	@Autowired
	private SimpleJdbc simpleJdbc;

	private final String REPAY_MENT_DETAIL = "repayMentDetail";

	@Autowired
	public void init(DataSource dataSource) throws Exception {
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName(REPAY_MENT_DETAIL);
	}

	public void insert(RepayMentDetail repayMentDetail) {
		simpleJdbcInsert.execute(new BeanPropertySqlParameterSource(repayMentDetail));
	}

	public void updateStatus(String id, String status) throws Exception {
		Object[] args = { status, id };

		StringBuffer sb = new StringBuffer();

		sb.append("update ");

		sb.append(REPAY_MENT_DETAIL);

		sb.append(" set status = ?");

		sb.append(" where id = ? ");

		simpleJdbc.update(status, args);
	}
}
