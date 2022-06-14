package com.psc.scLoan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.fori.util.LogUtil;
import com.psc.scLoan.api.result.BasicResult;
import com.psc.scLoan.api.ui.UserProfUI;
import com.psc.scLoan.api.ui.UserRoleUI;
import com.psc.scLoan.constants.Constants;
import com.psc.scLoan.constants.MessageConstants;

import com.psc.scLoan.service.RoleService;
import com.psc.scLoan.service.UserProfService;
import com.psc.scLoan.util.ObjectUtil;

@RestController
public class BaseController {


	@Autowired
	private RoleService roleService;

	public <T> UserProfUI checkErrorMessageAndAuth(UserProfService userProfService, BasicResult<T> resultObj,
			String message, String token) {
		UserProfUI userProf = null;
		if (message != null && message.length() > 0) {
			resultObj.setValidateFailWithMessage(message);
			return null;
		}
//		try {
//			userProf = userProfService.queryByJsonWebToken(token);
//			if (ObjectUtil.containsNonSpace(userProf)) {
//				return userProf;
//			}
//			resultObj.setAuthFailed();
//		} catch (Exception e) {
//			LogUtil.setErrorLog("save", e);
//			resultObj.setValidateFailWithMessage(MessageConstants.MESSAGE_AUTH_EXPIRE);
//		}
		return null;
	}

	/*public <T> Boolean isFunctionAuth(UserProfUI uiObj, BasicResult<T> resultObj, String functionId) throws Exception {
		List<String> roleList = new ArrayList<String>();
		Boolean isCheck = false;
		try {
			// 不同角色定義，為同一個角色
			for (UserRoleUI ui : uiObj.getRoleList()) {
				Role roleObj = roleService.queryById(ui.getRoleId(),Constants.STATUS_ON);
				roleList.add(roleObj.getSys_role());
			}

			List<RoleFunction> roleFunctionList = roleFunctionService.queryByRole(roleList);
			for (RoleFunction roleFunctionObj : roleFunctionList) {
				if (functionId.equals(roleFunctionObj.getFunction_id())) {
					isCheck = true;
					break;
				}
			}
//			LogUtil.setInfoLog(uiObj.getAccount() + "-" + functionId + "-" + isCheck);
			if (!isCheck) {
				resultObj.setAuthFailed();
			}
		} catch (Exception e) {
			LogUtil.setErrorLog("isFunctionAuth", e);
			resultObj.setSystemError();
		}
		return isCheck;
	}*/
}