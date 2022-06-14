package com.psc.scLoan.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fori.util.LogUtil;
import com.psc.scLoan.api.ui.RoleUI;
import com.psc.scLoan.api.ui.UserProfUI;
import com.psc.scLoan.api.ui.UserRoleUI;
import com.psc.scLoan.constants.Constants;
import com.psc.scLoan.model.Role;
import com.psc.scLoan.repository.RoleRepository;

/**
 *
 *
 * @author wunhow
 *
 */
@Service
public class RoleService {
	@Autowired
	private RoleRepository repository;
	@Autowired
	private UserProfService userProfService;
	@Autowired
	private OptionsService optionsService;


	public LinkedList<RoleUI> queryList(UserProfUI userProf, String keyword, String status) throws Exception {
		List<Role> objList = repository.findList(keyword, status);
		LinkedList<RoleUI> result = new LinkedList<RoleUI>();
//		HashMap<String, String> statusOption = optionsService.getStatusOptions(userProf.getLanguage());
//		Map<String, String> userMap = userProfService.getMap(userProf.getLanguage());

		RoleUI ui = null;
		for (Role obj : objList) {
			ui = new RoleUI();
			BeanUtils.copyProperties(obj, ui);

//			ui.setStatusName(statusOption.get(ui.getStatus()));
//			ui.setUpdatedUser(userMap.get(obj.getUpdated_user()));
			result.add(ui);
		}
		return result;
	}

	public Role queryById(String id, String status) throws Exception {
		return repository.findById(id, status);
	}

	public RoleUI queryUIById(UserProfUI userProf, String id) throws Exception {
		RoleUI result = new RoleUI();
		List<String> roleList = new ArrayList<String>();
		Role roleObj = repository.findById(id, Constants.STATUS_ON);
		BeanUtils.copyProperties(roleObj, result);
		roleList.add(id);


//		result.setUpdatedUser(userProfService.getUserName(roleObj.getUpdated_user(), userProf.getLanguage()));

		LogUtil.logObjectToString(result);
		return result;
	}




	@Transactional(rollbackFor = Exception.class)
	public void updateStatus(String id, String status, String modifier) throws Exception {
		repository.updateStatus(id, status, modifier);
	}

	public Map<String, String> getMap() throws Exception {
		List<Role> objList = repository.findList(null, Constants.STATUS_ON);
		Map<String, String> result = new LinkedHashMap<String, String>();
		for (Role obj : objList) {
			if (!obj.getId().equals(Constants.ROLE_ADMIN)) {
				result.put(obj.getId(), obj.getName());
			}
		}
		return result;
	}



}
