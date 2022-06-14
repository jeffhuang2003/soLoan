package com.psc.scLoan.controller;

import com.fori.util.LogUtil;
import com.psc.scLoan.api.form.LendForm;
import com.psc.scLoan.api.result.BasicResult;
import com.psc.scLoan.config.PropConfig;
import com.psc.scLoan.constants.MessageConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/** 
 * 建立日期：2022/6/12 下午 11:56
 * 程式摘要：com.psc.scLoan.controller
 * 類別名稱：SCLOAN010Controller.java
 * 程式內容說明：
	1. 客戶基本資料查詢 /SCLOAN090/customerInfo
	2. 客戶擔保品庫存查詢 /SCLOAN030/findCustomerCollateralList
	3. 客戶借款申請  /SCLOAN010/lendApply
	4. 客戶借款申請查詢 /SCLOAN010/TODO
 * @author kunlung
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/SCLOAN010")
@Api(tags = "SCLOAN010-借款申請")
public class SCLOAN010Controller {
	@Autowired
	private PropConfig fileConfig;



    @PostMapping("/lendApply")
    @ApiOperation(value = "客戶借款申請", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 404, message = "系統異常"),
            @ApiResponse(code = 405, message = "操作發生錯誤，") })
    public BasicResult<String> lendApply(@RequestBody LendForm command) {
        BasicResult<String> resultObj = new BasicResult<String>();
        try {




        } catch (Exception e) {
            LogUtil.setErrorLog("/health", e);
            resultObj.setSystemError();
        }
        return resultObj;
    }

}
