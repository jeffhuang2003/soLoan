package com.psc.scLoan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fori.util.LogUtil;
import com.psc.scLoan.api.form.RepayMentForm;
import com.psc.scLoan.api.result.BasicResult;
import com.psc.scLoan.api.ui.RepayMentUI;
import com.psc.scLoan.config.PropConfig;
import com.psc.scLoan.constants.MessageConstants;
import com.psc.scLoan.service.RepayMentService;
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
@RequestMapping("/SCLOAN020")
@Api(tags = "SCLOAN020-還款申請")
public class SCLOAN020Controller {

	@Autowired
	private PropConfig fileConfig;

	@Autowired
	private UserProfService userProfService;

	@Autowired
	private RepayMentService repayMentService;

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

	@GetMapping("/repayMentCashQry")
	@ApiOperation(value = "/repayMentCashQry", notes = "")
	@ApiResponses({ @ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 404, message = "系統異常") })
	public BasicResult<RepayMentUI> repayMentCashQry(@RequestBody RepayMentForm repayMentForm) {
		BasicResult<RepayMentUI> resultObj = new BasicResult<RepayMentUI>();
		try {

			RepayMentUI repayMentUI;

			if (repayMentForm.getRepayAll()) {

				repayMentUI = repayMentService.repayMentCashQryAll(repayMentForm.getUserId());

			} else {

				repayMentUI = repayMentService.repayMentCashQry(repayMentForm.getUserId(), repayMentForm.getYear(), repayMentForm.getMonth());

			}

			resultObj.setItem(repayMentUI);

		} catch (Exception e) {
			LogUtil.setErrorLog("/health", e);
			resultObj.setSystemError();
		}
		return resultObj;
	}

	@GetMapping("/rayMentStockQry")
	@ApiOperation(value = "/rayMentStockQry", notes = "")
	@ApiResponses({ @ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 404, message = "系統異常") })
	public BasicResult<RepayMentUI> rayMentStockQry(@RequestBody RepayMentForm repayMentForm) {
		BasicResult<RepayMentUI> resultObj = new BasicResult<RepayMentUI>();
		try {

			RepayMentUI repayMentUI = repayMentService.rayMentStockQry(repayMentForm.getUserId());

			resultObj.setItem(repayMentUI);

		} catch (Exception e) {
			LogUtil.setErrorLog("/health", e);
			resultObj.setSystemError();
		}
		return resultObj;
	}

	@GetMapping("/addRayMentDetail")
	@ApiOperation(value = "/addRayMentDetail", notes = "")
	@ApiResponses({ @ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 404, message = "系統異常") })
	public BasicResult<String> addRayMentDetail() {
		BasicResult<String> resultObj = new BasicResult<String>();
		try {

		} catch (Exception e) {
			LogUtil.setErrorLog("/health", e);
			resultObj.setSystemError();
		}
		return resultObj;
	}
}
