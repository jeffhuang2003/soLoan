package com.psc.scLoan.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fori.jdbc.ClassRowMapperFactory;
import com.fori.jdbc.SimpleJdbc;
import com.psc.scLoan.model.Options;
import com.psc.scLoan.util.ObjectUtil;

/**
 * 後台管理者
 * @author wunhow
 *
 */
@Repository
public class OptionsRepository {
	
	@Autowired
	private SimpleJdbc simpleJdbc;
	public final static String OPTIONS = "options";
	
	public void testDB() throws Exception {
		StringBuffer sb = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sb.append(" Select @@version");

		System.out.println(simpleJdbc.queryForString(sb.toString(), args.toArray()));
	}
	
	public List<Options> findList(String category, String status,String language) throws Exception {
		StringBuffer sb = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sb.append(" select t.* from  " + OPTIONS + " t where 1=1 ");

		if (ObjectUtil.containsNonSpace(category)) {
			sb.append(" and category = ? ");
			args.add(category);
		}

		if (ObjectUtil.containsNonSpace(status)) {
			sb.append(" and status = ?");
			args.add(status);
		}
		if (ObjectUtil.containsNonSpace(language)) {
			sb.append(" and language = ?");
			args.add(language);
		}
		sb.append(" Order by category,sort ");
		return simpleJdbc.query(sb.toString(), args.toArray(), ClassRowMapperFactory.get(Options.class));
	}
}
