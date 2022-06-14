package com.psc.scLoan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fori.util.LogUtil;
import com.psc.scLoan.api.form.LoginForm;
import com.psc.scLoan.api.result.BasicResult;
import com.psc.scLoan.config.PropConfig;
import com.psc.scLoan.constants.ApiCodeConstants;
import com.psc.scLoan.constants.MessageConstants;
import com.psc.scLoan.service.UserProfService;

import io.swagger.annotations.Api;
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
@RequestMapping("/SCLOAN040")
@Api(tags = "SCLOAN040-帳務查詢")
public class SCLOAN040Controller {
	@Autowired
	private PropConfig fileConfig;
	private UserProfService service;

	@GetMapping("/health")
	@ApiOperation(value = "/health", notes = "")
	@ApiResponses({ @ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 404, message = "系統異常") })
	public BasicResult<String> health() {
		BasicResult<String> resultObj = new BasicResult<String>();
		try {
			
			resultObj.setItem(MessageConstants.MESSAGE_SYSTEM_HEALTH_NORMALY);
		} catch (Exception e) {
			LogUtil.setErrorLog("/health", e);
			resultObj.setSystemError();
		}
		return resultObj;
	}

}
