package com.psc.scLoan.config;

import javax.sql.DataSource;

import org.hibernate.boot.model.naming.ImplicitNamingStrategy;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import com.fori.jdbc.MssqlPagingQuery;
import com.fori.jdbc.PagingQuery;
import com.fori.jdbc.SimpleJdbc;

@Configuration
public class DataSourceConfig {
	@Autowired
	DataSource dataSource;

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	@Autowired
	public TransactionTemplate transactionTemplate() {
		return new TransactionTemplate(transactionManager());
	}

	@Bean
	public PagingQuery pagingQuery() {
		return new MssqlPagingQuery();
	}

	@Bean
	@Autowired
	public SimpleJdbc simpleJdbc() {
		return new SimpleJdbc(jdbcTemplate(),  pagingQuery());
	}
	@Bean
	public PhysicalNamingStrategy physical() {
	    return new PhysicalNamingStrategyStandardImpl();
	}

	@Bean
	public ImplicitNamingStrategy implicit() {
	    return new ImplicitNamingStrategyLegacyJpaImpl();
	}
}
