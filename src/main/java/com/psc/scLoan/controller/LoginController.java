package com.psc.scLoan.controller;

import java.util.HashMap;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fori.util.LogUtil;
import com.psc.scLoan.api.form.LoginForm;
import com.psc.scLoan.api.result.BasicResult;
import com.psc.scLoan.api.ui.UserProfUI;
import com.psc.scLoan.config.PropConfig;
import com.psc.scLoan.constants.ApiCodeConstants;
import com.psc.scLoan.constants.Constants;
import com.psc.scLoan.constants.MessageConstants;
import com.psc.scLoan.model.UserProf;
import com.psc.scLoan.service.LoginService;
import com.psc.scLoan.service.UserProfService;
import com.psc.scLoan.util.JWTUtil;
import com.psc.scLoan.util.ObjectUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 *
 *
 * @author wunhow
 *
 */
@RestController
@RequestMapping("/")
@Api(tags = "PSCNET_LOAN 登入")
public class LoginController {
	@Autowired
	private PropConfig fileConfig;
	private UserProfService service;
	private LoginService loginService;

	@Autowired
	public LoginController(UserProfService service, LoginService loginService, PropConfig fileConfig) {
		this.fileConfig = fileConfig;
		this.loginService = loginService;
		this.service = service;
	}

	@PostMapping("/login")
	@ApiOperation(value = "帳號登入", notes = "")
	@ApiResponses({ @ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 404, message = "系統異常") })
	public BasicResult<UserProfUI> login(@RequestBody LoginForm form) {
		BasicResult<UserProfUI> resultObj = new BasicResult<UserProfUI>();
		try {
			String loginEmail = form.getAccount();
			if (loginEmail.indexOf("@") < 0) {
				resultObj.setAuthFailed();
				return resultObj;
			}

//			String account = loginEmail.substring(0,loginEmail.indexOf("@"));
			//LogUtil.logObjectToString(form);
			UserProf userProf = service.findByEmail(loginEmail);
			UserProfUI ui = new UserProfUI();
//			String name = "";
			LogUtil.logObjectToString(userProf);
			if (!ObjectUtil.containsNonSpace(userProf)) {
				resultObj.setAuthFailed();
				return resultObj;
			}

			String subject = JWTUtil.generalSubject(userProf, fileConfig.getProjectName(),Constants.LANGUAGE_ZH);

			ui.setJsonWebToken(JWTUtil.createJWT(subject,fileConfig.getProjectName()));
			resultObj.setItem(ui);

		} catch (Exception e) {
			LogUtil.setErrorLog("login", e);
			resultObj.setSystemError();
		}
		return resultObj;
	}

}
