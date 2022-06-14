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
import com.psc.scLoan.model.Role;
import com.psc.scLoan.util.ObjectUtil;

/**
 *
 *
 * @author wunhow
 * 角色管理
 */

@Repository
public class RoleRepository {
	@Autowired
	private SimpleJdbc simpleJdbc;
	private final String ROLE = "role";
	private SimpleJdbcInsert simpleJdbcInsert;

	@Autowired
	public void init(DataSource dataSource) throws Exception {
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName(ROLE);
	}
	/**
	 * 取得單一物件
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Role findById(String id, String status) throws Exception {
		StringBuffer sb = new StringBuffer();
		List<Object> args = new ArrayList<Object>();

		sb.append("select tc.* from  " + ROLE + " tc where 1=1 ");

		if (ObjectUtil.containsNonSpace(id)) {
			sb.append(" and id = ?");
			args.add(id);
		}
		if (ObjectUtil.containsNonSpace(status)) {
			sb.append(" and status = ?");
			args.add(status);
		}
		return simpleJdbc.getFirst(simpleJdbc.query(sb.toString(), args.toArray(), ClassRowMapperFactory.get(Role.class)));

	}

	/**
	 * 取得角色清單
	 * @param keyword 關鍵字
	 * @param status 狀態
	 * @return
	 * @throws Exception
	 */
	public List<Role> findList(String keyword, String status) throws Exception {
		StringBuffer sb = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sb.append(" select tc.* from  " + ROLE + " tc where 1=1 ");

		if (ObjectUtil.containsNonSpace(keyword)) {
			sb.append(" and (name like ? or en_name like ? )");
			args.add("%" + keyword + "%");
			args.add("%" + keyword + "%");
		}

		if (ObjectUtil.containsNonSpace(status)) {
			sb.append(" and status = ?");
			args.add(status);
		}

		sb.append(" Order by updated_date desc");

		return simpleJdbc.query(sb.toString(), args.toArray(), ClassRowMapperFactory.get(Role.class));
	}


	public void updateStatus(String id, String status, String modifier) throws Exception {
		Object[] args = {  modifier, status, id };
		StringBuffer sb = new StringBuffer("update ");
		sb.append(ROLE);
		sb.append(" set updated_date=now(), updated_user=?, status=? where id=?");
		simpleJdbc.update(sb.toString(), args);
	}

	/**
	 * 儲存
	 *
	 * @param obj
	 */
	public void insert(Role obj) {
		simpleJdbcInsert.execute(new BeanPropertySqlParameterSource(obj));
	}


	/**
	 * 更新
	 *
	 * @param id
	 * @param status
	 * @param modifier
	 * @throws Exception
	 */
	public void update(Role entity) throws Exception {
		String sql = "update " + ROLE + " set  name=? ,"
				+ "  updated_date=now(),updated_user=?  where id=?";
		  Object[] args = {
				  	entity.getName(),
		    		entity.getModify_time(),
		            entity.getId()
		        };
		simpleJdbc.update(sql, args);
	}
}

