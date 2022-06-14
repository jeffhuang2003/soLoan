package com.psc.scLoan.service;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fori.util.Id;
import com.fori.util.LogUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.psc.scLoan.api.ui.UserProfUI;
import com.psc.scLoan.api.ui.UserRoleUI;
import com.psc.scLoan.config.PropConfig;
import com.psc.scLoan.constants.Constants;
import com.psc.scLoan.constants.MessageConstants;
import com.psc.scLoan.model.UserProf;
import com.psc.scLoan.repository.UserProfRepository;
import com.psc.scLoan.util.JWTUtil;
import com.psc.scLoan.util.ObjectUtil;

/**
 *
 *
 * @author wunhow
 *
 */
@Service
public class UserProfService {
	@Autowired
	private PropConfig propConfig;
	@Autowired
	private UserProfRepository repository;


	@Autowired
	private OptionsService optionsService;

	public UserProf findById(String id) throws Exception {
		return repository.findById(id);
	}

	public UserProf findByEmail(String email) throws Exception {
		UserProf obj = repository.findByEmail(email, Constants.STATUS_ON);
		return obj;
	}

	public UserProf findByAccount(String account) throws Exception {
		UserProf obj = repository.findByAccount(account);
		return obj;
	}

	public UserProfUI queryByJsonWebToken(String jsonWebToken) throws Exception {
		UserProfUI uiObj = null;
		HashMap<String,String> roleMap=new HashMap<String,String>();
		UserProf obj = JWTUtil.parseJWT(jsonWebToken,propConfig.getProjectName());
		if (ObjectUtil.containsNonSpace(obj)) {
			uiObj = repository.queryByAccountAndId(obj.getAccount(), obj.getId(), Constants.STATUS_ON);
//			if (ObjectUtil.containsNonSpace(uiObj)) {
//				LinkedList<UserRoleUI> roleList = userRoleService.queryUIByUserId(obj.getId(),Constants.STATUS_ON);
//				for(UserRoleUI roleUi:roleList) {
//					roleMap.put(roleUi.getSystemRoleId(), roleUi.getSystemRoleId());
//				}
//				uiObj.setRoleList(roleList);
//			} else {
//				throw new Exception(MessageConstants.MESSAGE_AUTH_FAIL);
//			}
			LogUtil.setInfoLog(uiObj.getAccount()+"["+roleMap.toString()+"]");
		} else {
			throw new Exception(MessageConstants.MESSAGE_AUTH_EXPIRE);
		}



		return uiObj;
	}



	public List<UserProf> findList(String keyword, String status) throws Exception {
		return repository.findList(keyword, status);
	}



	@Transactional(rollbackFor = Exception.class)
	public void updateAD(String id) throws Exception {
		repository.updateAD(id);
	}

	/**
	 * 儲存
	 *
	 * @param entity
	 * @param modifier
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public void save(UserProf entity, String modifier) throws Exception {
//		Timestamp now = new Timestamp(new GregorianCalendar().getTimeInMillis());
//		if (!ObjectUtil.containsNonSpace(entity.getId())) {
//			entity.setId(Id.dateId20());
//			entity.setCreateUser(modifier);
//			entity.setCreatedDate(now);
//			entity.setUpdatedUser(modifier);
//			entity.setUpdated_date(now);
//			repository.insert(entity);
//		} else {
//			entity.setUpdated_user(modifier);
//			entity.setUpdated_date(now);
//			repository.update(entity);
//		}
	}



	public List<UserProf> findByRole(String roleId, String status) throws Exception {
		return repository.findByRole(roleId, status);
	}

	public List<String> getAdminList() throws Exception {
		List<UserProf> list = this.findByRole(Constants.ROLE_ADMIN, Constants.STATUS_ON);
		List<String> result = new ArrayList<String>();
		for (UserProf userObj : list) {
			result.add(userObj.getEmail());
		}
		return result;
	}

	public List<HashMap<String, String>> getUserOption(String language) throws Exception {
		List<UserProf> objList = this.findList(null, Constants.STATUS_ON);
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> result = new HashMap<String, String>();
		for (UserProf obj : objList) {
//			if (!obj.getId().equals(Constants.ROLE_ADMIN)) {
				result = new HashMap<String, String>();
				result.put(Constants.MAP_VAL, obj.getId());
				if(Constants.LANGUAGE_ZH.equals(language)) {
					result.put(Constants.MAP_LABEL, obj.getName());
				}else if(Constants.LANGUAGE_EN.equals(language)){
					result.put(Constants.MAP_LABEL, obj.getName());
				}
				list.add(result);
//			}
		}
		return list;
	}

	/**
	 * 取得角色對應清單
	 *
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public LinkedList<HashMap<String, String>> getMapByRole(String roleId) throws Exception {
		LinkedList<HashMap<String, String>> list = new LinkedList<HashMap<String, String>>();
		List<UserProf> objList = this.findByRole(roleId, Constants.STATUS_ON);
		HashMap<String, String> result = new HashMap<String, String>();
		for (UserProf obj : objList) {
			result = new HashMap<String, String>();
			result.put(Constants.MAP_VAL, obj.getId());
			result.put(Constants.MAP_LABEL, obj.getName());
			list.add(result);
		}
		return list;
	}

}
