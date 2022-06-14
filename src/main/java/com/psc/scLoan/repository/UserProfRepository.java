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
import com.psc.scLoan.api.ui.UserProfUI;
import com.psc.scLoan.constants.Constants;
import com.psc.scLoan.model.UserProf;
import com.psc.scLoan.util.ObjectUtil;

/**
 *
 *
 * @author wunhow
 * 人員管理
 */
@Repository
public class UserProfRepository {
	@Autowired
	private SimpleJdbc simpleJdbc;
	private final String USER_PROF = "user_prof";
	private final String USER_ROLE = "user_role";


	private SimpleJdbcInsert simpleJdbcInsert;

	@Autowired
	public void init(DataSource dataSource) throws Exception {
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName(USER_PROF);
	}

	/**
	 * 儲存
	 *
	 * @param obj
	 */
	public void insert(UserProf obj) {
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
	public void updateAllStatus( String status, String modifier) throws Exception {
		Object[] args = {  modifier, status,Constants.ROLE_ADMIN };
		StringBuffer sb = new StringBuffer("update ");
		sb.append(USER_PROF);
		sb.append(" set updated_date=now(), updated_user=?, status=? ");
		sb.append(" where id not in (select user_id from "+USER_ROLE+" where role_id =?) ");
		simpleJdbc.update(sb.toString(), args);
	}


	/**
	 * @param email
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public UserProf findByEmail(String email,String status) throws Exception {
		List<Object> args = new ArrayList<Object>();

		StringBuffer sb = new StringBuffer("select * from ");
		sb.append(USER_PROF);
		sb.append(" where email = ?");
		args.add(email);
		if(ObjectUtil.containsNonSpace(status)) {
			sb.append(" and status = ?");
			args.add(status);
		}
		LogUtil.setInfoLog(sb.toString());
		LogUtil.setInfoLog(new Gson().toJson(args));
		return simpleJdbc.getFirst(simpleJdbc.query(sb.toString(), args.toArray(), ClassRowMapperFactory.get(UserProf.class)));
	}


	/**
	 * @param account
	 * @return
	 * @throws Exception
	 */
	public UserProf findByAccount(String account) throws Exception {
		List<Object> args = new ArrayList<Object>();

		StringBuffer sb = new StringBuffer("select * from ");
		sb.append(USER_PROF);
		sb.append(" where account = ?");
		args.add(account);
		return simpleJdbc.getFirst(simpleJdbc.query(sb.toString(), args.toArray(), ClassRowMapperFactory.get(UserProf.class)));
	}

	/**
	 * 取得單一物件
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UserProfUI queryByAccountAndId(String account, String userid,String status) throws Exception {
		StringBuffer sb = new StringBuffer("select * from ");
		sb.append(USER_PROF);
		sb.append(" where account = ?");
		sb.append(" and id = ?");
		sb.append(" and status = ?");
		Object[] args = { account, userid,status };
		return simpleJdbc.getFirst(simpleJdbc.query(sb.toString(), args, ClassRowMapperFactory.get(UserProfUI.class)));
	}

	public List<UserProf> findList(String keyword, String status) throws Exception {
		StringBuffer sb = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sb.append(" select tc.* from  " + USER_PROF + " tc where 1=1 ");

		if (ObjectUtil.containsNonSpace(keyword)) {
			sb.append(" and (account like ?");
			args.add("%" + keyword + "%");

			sb.append(" or name like ?");
			args.add("%" + keyword + "%");

			sb.append(" or en_name like ? )");
			args.add("%" + keyword + "%");
		}

		if (ObjectUtil.containsNonSpace(status)) {
			sb.append(" and status = ?");
			args.add(status);
		}

		sb.append(" Order by updated_date ");
		return simpleJdbc.query(sb.toString(), args.toArray(), ClassRowMapperFactory.get(UserProf.class));
	}

	public UserProf findById(String id) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select u.* from  " + USER_PROF + " u where id = ?");
		Object[] args = { id };
		return simpleJdbc.getFirst(simpleJdbc.query(sb.toString(), args, ClassRowMapperFactory.get(UserProf.class)));

	}


	public List<UserProf> findByRole(String roleId, String status) throws Exception {
		StringBuffer sb = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sb.append(" select t.* from  " + USER_PROF + " t  ");
		sb.append(" INNER JOIN "+USER_ROLE+" r  on t.id = r.user_id  ");
		sb.append(" where 1=1 ");

		if (ObjectUtil.containsNonSpace(roleId)) {
			sb.append(" and r.role_id = ?");
			args.add( roleId );
		}
		if (ObjectUtil.containsNonSpace(status)) {
			sb.append(" and status = ?");
			args.add(status);
		}

		sb.append(" Order by updated_date ");

		return simpleJdbc.query(sb.toString(), args.toArray(), ClassRowMapperFactory.get(UserProf.class));
	}


	public void updateAD(String id) throws Exception {
		Object[] args = { "Y", id };
		StringBuffer sb = new StringBuffer("update ");
		sb.append(USER_PROF);
		sb.append(" set is_check=? where id=?");
		simpleJdbc.update(sb.toString(), args);
	}


	/**
	 * 更新
	 *
	 * @param id
	 * @param status
	 * @param modifier
	 * @throws Exception
	 */
	public void update(UserProf entity) throws Exception {
		String sql = "update " + USER_PROF + " set  en_name=?,name=? , "
				+ " email = ?,dept=?,status=?, modify_time=now(),updated_user=?  where id=?";
		  Object[] args = {
				  	entity.getEnName(),
		        	entity.getName(),
		        	entity.getEmail(),
		    		entity.getDept(),
		    		entity.getStatus(),
		    		entity.getModify_time(),
		            entity.getId()
		        };
		simpleJdbc.update(sql, args);
	}

}
