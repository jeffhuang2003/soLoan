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
import com.psc.scLoan.api.ui.CustomerInfoUI;
import com.psc.scLoan.config.PropConfig;
import com.psc.scLoan.constants.Constants;
import com.psc.scLoan.constants.MessageConstants;

import com.psc.scLoan.model.CustomerInfo;
import com.psc.scLoan.repository.CustomerInfoRepository;
import com.psc.scLoan.util.JWTUtil;
import com.psc.scLoan.util.ObjectUtil;

/**
 * 
 * 
 * @author william
 * 
 */
@Service
public class CustomerInfoService {
	@Autowired
	private PropConfig propConfig;
	@Autowired
	private CustomerInfoRepository repository;


//	public CustomerInfo findById(String id) throws Exception {
//		return repository.findById(id);
//	}

	public CustomerInfo findById(String id) throws Exception {
		CustomerInfo obj = repository.findById(id, Constants.STATUS_ON);
		return obj;
	}
	
//	public CustomerInfo findByAccount(String account) throws Exception {
//		CustomerInfo obj = repository.findByAccount(account);
//		return obj;
//	}

//	public CustomerInfoUI queryByJsonWebToken(String jsonWebToken) throws Exception {
//		CustomerInfoUI uiObj = null;	
//		HashMap<String,String> roleMap=new HashMap<String,String>();
//		CustomerInfo obj = JWTUtil.parseJWT1(jsonWebToken,propConfig.getProjectName());
//		if (ObjectUtil.containsNonSpace(obj)) {
//			uiObj = repository.queryByAccountAndId(obj.getAccount(), obj.getId(), Constants.STATUS_ON);
//			if (ObjectUtil.containsNonSpace(uiObj)) {
//				LinkedList<UserRoleUI> roleList = userRoleService.queryUIByUserId(obj.getId(),Constants.STATUS_ON);
//				for(UserRoleUI roleUi:roleList) {
//					roleMap.put(roleUi.getSystemRoleId(), roleUi.getSystemRoleId());
//				}
//				uiObj.setRoleList(roleList);
//			} else {
//				throw new Exception(MessageConstants.MESSAGE_AUTH_FAIL);
//			}
//			uiObj.setLanguage(obj.getLanguage());
//			uiObj.setRoleMap(roleMap);
//			LogUtil.setInfoLog(uiObj.getAccount()+"["+roleMap.toString()+"]");
//		} else {
//			throw new Exception(MessageConstants.MESSAGE_AUTH_EXPIRE);
//		}
//		
//		
//		
//		return uiObj;
//	}
	


//	public List<CustomerInfo> findList(String keyword, String status) throws Exception {
//		return repository.findList(keyword, status);
//	}

//	public LinkedList<CustomerInfoUI> findUIList(CustomerInfoUI customerInfo,String keyword, String status) throws Exception {
//		LinkedList<CustomerInfoUI> result = new LinkedList<CustomerInfoUI>();
//		HashMap<String, String> accountOption = optionsService.getAccountOptions(customerInfo.getLanguage());
//		List<CustomerInfo> objList = this.findList(keyword, status);
//		Map<String, String> userMap = this.getMap(customerInfo.getLanguage());
//		CustomerInfoUI ui = null;
//		for (CustomerInfo obj : objList) {
//			ui = new CustomerInfoUI();
//			BeanUtils.copyProperties(obj, ui);
//			ui.setStatusName(accountOption.get(ui.getStatus()));
//			ui.setEnName(obj.getEn_name());
//			ui.setUpdatedUser(userMap.get(obj.getUpdated_user()));
//			result.add(ui);
//		}
//		return result;
//
//	}

//	public Map<String, String> getMap(String language) throws Exception {
//		List<CustomerInfo> objList = this.findList(null, Constants.STATUS_ON);
//		Map<String, String> result = new LinkedHashMap<String, String>();
//		for (CustomerInfo obj : objList) {
//			if(Constants.LANGUAGE_ZH.equals(language)) {
//				result.put(obj.getId(), obj.getName());
//			}else if(Constants.LANGUAGE_EN.equals(language)) {
//				result.put(obj.getId(), obj.getEn_name());
//			}
//			
//		}
//		return result;
//	}
//
//	public String getUserName(String userId,String language) throws Exception {
//		return ObjectUtil.containsNonSpace(this.getMap(language).get(userId))?this.getMap(language).get(userId):userId;
//	}
//
//	@Transactional(rollbackFor = Exception.class)
//	public void updateAD(String id) throws Exception {
//		repository.updateAD(id);
//	}
//
//	/**
//	 * 儲存
//	 * 
//	 * @param entity
//	 * @param modifier
//	 * @throws Exception
//	 */
//	@Transactional(rollbackFor = Exception.class)
//	public void save(CustomerInfo entity, String modifier) throws Exception {
//		Timestamp now = new Timestamp(new GregorianCalendar().getTimeInMillis());
//		//if (!ObjectUtil.containsNonSpace(entity.getUsrId())) {
//			entity.setId(Id.dateId20());
//			LogUtil.setInfoLog(Id.dateId20());
//			entity.setCreateuser(modifier);
//			entity.setCreateddate(now);
//			entity.setUpduser(modifier);
//			entity.setUpddate(now);
//			repository.insert(entity);
//		} else {
//			entity.setUpduser(modifier);
//			entity.setUpddate(now);
//			repository.update(entity);
//		}
//	}
//
//	
//
//	public List<CustomerInfo> findByRole(String roleId, String status) throws Exception {
//		return repository.findByRole(roleId, status);
//	}
//
//	public List<String> getAdminList() throws Exception {
//		List<CustomerInfo> list = this.findByRole(Constants.ROLE_ADMIN, Constants.STATUS_ON);
//		List<String> result = new ArrayList<String>();
//		for (CustomerInfo userObj : list) {
//			result.add(userObj.getEmail());
//		}
//		return result;
//	}
//
//	public List<HashMap<String, String>> getUserOption(String language) throws Exception {
//		List<CustomerInfo> objList = this.findList(null, Constants.STATUS_ON);
//		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
//		HashMap<String, String> result = new HashMap<String, String>();
//		for (CustomerInfo obj : objList) {
////			if (!obj.getId().equals(Constants.ROLE_ADMIN)) {
//				result = new HashMap<String, String>();
//				result.put(Constants.MAP_VAL, obj.getId());
//				if(Constants.LANGUAGE_ZH.equals(language)) {
//					result.put(Constants.MAP_LABEL, obj.getName());	
//				}else if(Constants.LANGUAGE_EN.equals(language)){
//					result.put(Constants.MAP_LABEL, obj.getName());
//				}				
//				list.add(result);
////			}
//		}
//		return list;
//	}
//
//	/**
//	 * 取得角色對應清單
//	 * 
//	 * @param roleId
//	 * @return
//	 * @throws Exception
//	 */
//	public LinkedList<HashMap<String, String>> getMapByRole(String roleId) throws Exception {
//		LinkedList<HashMap<String, String>> list = new LinkedList<HashMap<String, String>>();
//		List<CustomerInfo> objList = this.findByRole(roleId, Constants.STATUS_ON);
//		HashMap<String, String> result = new HashMap<String, String>();
//		for (CustomerInfo obj : objList) {
//			result = new HashMap<String, String>();
//			result.put(Constants.MAP_VAL, obj.getId());
//			result.put(Constants.MAP_LABEL, obj.getName());
//			list.add(result);
//		}
//		return list;
//	}

}
