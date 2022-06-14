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
 * 建立日期：2022/6/13 上午 01:26
 * 程式摘要：com.psc.scLoan.controller
 * 類別名稱：SCLOAN030Controller.java
 * 程式內容說明：退還擔保品模組
 * @author kunlung
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/SCLOAN030")
@Api(tags = "SCLOAN030-退還擔保品")
public class SCLOAN030Controller {
	@Autowired
	private PropConfig fileConfig;
	private UserProfService service;
	
	@GetMapping("/findCustomerCollateralList")
	@ApiOperation(value = "客戶擔保品庫存查詢", notes = "")
	@ApiResponses({ @ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 404, message = "系統異常") })
	public BasicResult<String> health() {
		BasicResult<String> resultObj = new BasicResult<String>();
		try {

            /**
             * TODO
             * 1.客戶擔保品資料
             * 2.目前除試算外都會使用到
             * 3.對應table PSC_COLLATERAL
             */
			
			resultObj.setItem(MessageConstants.MESSAGE_SYSTEM_HEALTH_NORMALY);
		} catch (Exception e) {
			LogUtil.setErrorLog("/health", e);
			resultObj.setSystemError();
		}
		return resultObj;
	}



}
