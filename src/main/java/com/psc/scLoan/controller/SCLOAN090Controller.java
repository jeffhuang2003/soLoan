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
import com.psc.scLoan.api.ui.CustomerInfoUI;
import com.psc.scLoan.config.PropConfig;
import com.psc.scLoan.constants.ApiCodeConstants;
import com.psc.scLoan.constants.MessageConstants;
import com.psc.scLoan.model.CustomerInfo;
import com.psc.scLoan.service.CustomerInfoService;
import com.psc.scLoan.service.UserProfService;
import com.psc.scLoan.util.ObjectUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * 建立日期：2022/6/13 上午 01:23
 * 程式摘要：com.psc.scLoan.controller
 * 類別名稱：SCLOAN090Controller.java
 * 程式內容說明：共用模組
 * @author kunlung
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/SCLOAN090")
@Api(tags = "SCLOAN090-共用模組")
public class SCLOAN090Controller {
	@Autowired
	private PropConfig fileConfig;
	private CustomerInfoService service;
	
	@Autowired
	public SCLOAN090Controller(CustomerInfoService service, PropConfig fileConfig) {
		this.fileConfig = fileConfig;
		//this.loginService = loginService;
		this.service = service;
	}
	
	
	@PostMapping("/customerInfo")
	@ApiOperation(value = "客戶基本資料查詢 ", notes = "共用基本資料查詢")
	@ApiResponses({ @ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 404, message = "系統異常") })
	public BasicResult<CustomerInfoUI> customerInfoSerch(@RequestBody LoginForm form) {
		BasicResult<CustomerInfoUI> resultObj = new BasicResult<CustomerInfoUI>();
		try {

            /**
             * Todo
             * 1. 為借款申請、還款申請上方共用客戶資訊及帳務資訊使用
             * 2. 對應table 為 PSC_CUSTOMER_INFO(主表)、PSC_CUSTOMER_DETAIL(子表)
             */
			String account = form.getAccount();
			CustomerInfo customerInfo = service.findById(account);
			CustomerInfoUI ui = new CustomerInfoUI();
			LogUtil.logObjectToString(customerInfo);
			if (!ObjectUtil.containsNonSpace(customerInfo)) {
				resultObj.setAuthFailed();
				return resultObj;
			}
			ui.setId(customerInfo.getId());
			ui.setName(customerInfo.getName());
			/*	
			 * TODO
			 * 1.另一張表資料PSC_CUSTOMERINFO_DETAIL找的資料
			 * 2.還有融通額度跟已借金額要放
			 * */
//			ui.setBranch_type();
//			ui.setAccount();
			ui.setBorrow_limit(customerInfo.getBorrow_limit());
			ui.setMaintenance_ratio(customerInfo.getMaintenance_ratio());
			
			
            resultObj.setItem(ui);
		} catch (Exception e) {
			LogUtil.setErrorLog("/customerInfo ", e);
			resultObj.setSystemError();
		}
		return resultObj;
	}

}
