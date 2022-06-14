package com.psc.scLoan.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.fori.jdbc.ClassRowMapperFactory;
import com.fori.jdbc.SimpleJdbc;
import com.fori.util.LogUtil;
import com.google.gson.Gson;
import com.psc.scLoan.api.ui.CustomerInfoUI;
import com.psc.scLoan.constants.Constants;
import com.psc.scLoan.model.CustomerInfo;
import com.psc.scLoan.util.ObjectUtil;

/**
 * 
 * 
 * @author william
 * 
 */
@Repository
public class CustomerInfoRepository {
	@Autowired
	private SimpleJdbc simpleJdbc;
	private final String CUSTOMER_INFO = "PSC_CUSTOMER_INFO";

	

	private SimpleJdbcInsert simpleJdbcInsert;

	@Autowired
	public void init(DataSource dataSource) throws Exception {
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName(CUSTOMER_INFO);
	}

	/**
	 * 儲存
	 * 
	 * @param obj
	 */
	public void insert(CustomerInfo obj) {
		simpleJdbcInsert.execute(new BeanPropertySqlParameterSource(obj));
	}
	
	/**
	 * 更新狀態
	 * 
	 * @param id
	 * @param status
	 * @param modifier
	 * @throws Exception
	 */
//	public void updateAllStatus( String status, String modifier) throws Exception {
//		Object[] args = {  modifier, status,Constants.ROLE_ADMIN };
//		StringBuffer sb = new StringBuffer("update ");
//		sb.append(USER_FRONT);
//		sb.append(" set updated_date=now(), updated_user=?, status=? ");
//		sb.append(" where id not in (select user_id from "+USER_ROLE+" where role_id =?) ");
//		simpleJdbc.update(sb.toString(), args);
//	}
	

	/** 
	 * @param email
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public CustomerInfo findById(String id,String status) throws Exception {
		List<Object> args = new ArrayList<Object>();

		StringBuffer sb = new StringBuffer("select * from ");
		sb.append(CUSTOMER_INFO);
		sb.append(" where id = ?");
		args.add(id);

		LogUtil.setInfoLog(sb.toString());
		LogUtil.setInfoLog(new Gson().toJson(args));
		return simpleJdbc.getFirst(simpleJdbc.query(sb.toString(), args.toArray(), ClassRowMapperFactory.get(CustomerInfo.class)));
	}
	
	
//	/** 
//	 * @param account
//	 * @return
//	 * @throws Exception
//	 */
//	public CustomerInfo findByAccount(String account) throws Exception {
//		List<Object> args = new ArrayList<Object>();
//
//		StringBuffer sb = new StringBuffer("select * from ");
//		sb.append(USER_FRONT);
//		sb.append(" where account = ?");
//		args.add(account);
//		return simpleJdbc.getFirst(simpleJdbc.query(sb.toString(), args.toArray(), ClassRowMapperFactory.get(CustomerInfo.class)));
//	}
//
//	/**
//	 * 取得單一物件
//	 * 
//	 * @param id
//	 * @return
//	 * @throws Exception
//	 */
//	public CustomerInfoUI queryByAccountAndId(String account, String userid,String status) throws Exception {
//		StringBuffer sb = new StringBuffer("select * from ");
//		sb.append(USER_FRONT);
//		sb.append(" where account = ?");
//		sb.append(" and id = ?");
//		sb.append(" and status = ?");
//		Object[] args = { account, userid,status };
//		return simpleJdbc.getFirst(simpleJdbc.query(sb.toString(), args, ClassRowMapperFactory.get(CustomerInfoUI.class)));
//	}
//
//	public List<CustomerInfo> findList(String keyword, String status) throws Exception {
//		StringBuffer sb = new StringBuffer();
//		List<Object> args = new ArrayList<Object>();
//		sb.append(" select tc.* from  " + USER_FRONT + " tc where 1=1 ");
//
//		if (ObjectUtil.containsNonSpace(keyword)) {
//			sb.append(" and (account like ?");
//			args.add("%" + keyword + "%");
//
//			sb.append(" or name like ?");
//			args.add("%" + keyword + "%");
//
//			sb.append(" or en_name like ? )");
//			args.add("%" + keyword + "%");
//		}
//
//		if (ObjectUtil.containsNonSpace(status)) {
//			sb.append(" and status = ?");
//			args.add(status);
//		}
//
//		sb.append(" Order by updated_date ");
//		return simpleJdbc.query(sb.toString(), args.toArray(), ClassRowMapperFactory.get(CustomerInfo.class));
//	}
//
//	public CustomerInfo findById(String id) throws Exception {
//		StringBuffer sb = new StringBuffer();
//		sb.append("select u.* from  " + CUSTOMER_INFO + " u where id = ?");
//		Object[] args = { id };
//		return simpleJdbc.getFirst(simpleJdbc.query(sb.toString(), args, ClassRowMapperFactory.get(CustomerInfo.class)));
//
//	}
//	
//	
//	public List<CustomerInfo> findByRole(String roleId, String status) throws Exception {
//		StringBuffer sb = new StringBuffer();
//		List<Object> args = new ArrayList<Object>();
//		sb.append(" select t.* from  " + USER_FRONT + " t  ");
//		sb.append(" INNER JOIN "+USER_ROLE+" r  on t.id = r.user_id  ");
//		sb.append(" where 1=1 ");
//		
//		if (ObjectUtil.containsNonSpace(roleId)) {
//			sb.append(" and r.role_id = ?");
//			args.add( roleId );
//		}
//		if (ObjectUtil.containsNonSpace(status)) {
//			sb.append(" and status = ?");
//			args.add(status);
//		}
//
//		sb.append(" Order by updated_date ");
//
//		return simpleJdbc.query(sb.toString(), args.toArray(), ClassRowMapperFactory.get(CustomerInfo.class));
//	}
//	
	
//	public void updateAD(String id) throws Exception {
//		Object[] args = { "Y", id };
//		StringBuffer sb = new StringBuffer("update ");
//		sb.append(USER_FRONT);
//		sb.append(" set is_check=? where id=?");
//		simpleJdbc.update(sb.toString(), args);
//	}
	
	
//	/**
//	 * 更新
//	 * 
//	 * @param id
//	 * @param status
//	 * @param modifier
//	 * @throws Exception
//	 */
//	public void update(CustomerInfo entity) throws Exception {
//		String sql = "update " + CUSTOMER_INFO + " set  usrname=? , "
//				+ " limit = ?, credit=?, mtrate=?, loantotal=?, updateddate=now(),updateduser=?  where id=?";
//		  Object[] args = {
//		        	entity.getUsrname(),
//		        	entity.getLimit(),
//		    		entity.getCredit(),
//		    		entity.getLoantotal(),
//		    		entity.getUpduser(),
//		            entity.getUsrid()
//		        };
//		simpleJdbc.update(sql, args);
//	}

}
