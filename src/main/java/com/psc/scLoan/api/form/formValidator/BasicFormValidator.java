package com.psc.scLoan.api.form.formValidator;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import com.fori.util.DateUtil;
import com.fori.util.LogUtil;
import com.psc.scLoan.api.form.BasicForm;
import com.psc.scLoan.constants.Constants;
import com.psc.scLoan.util.ObjectUtil;
@Service
public class BasicFormValidator implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * @param form
	 * @param checkMessage
	 * @return
	 * @throws Exception
	 */
	public String validate(BasicForm form) throws Exception {
		LogUtil.logObjectToString(form);

		StringBuffer sb = new StringBuffer();
		if (!ObjectUtil.containsNonSpace(form.getToken())) {
			sb.append(" token 未輸入 ,");
		}
		if (!ObjectUtil.containsNonSpace(form.getId())) {
			sb.append(" 編號 未輸入 ,");
		}
		if (!ObjectUtil.containsNonSpace(form.getStatus())) {
			sb.append(" 狀態 未輸入 ,");
		}
		return sb.toString();
	}

	/**
	 * @param form
	 * @param checkMessage
	 * @return
	 * @throws Exception
	 */
	public String validateId(BasicForm form) throws Exception {
		LogUtil.logObjectToString(form);

		StringBuffer sb = new StringBuffer();
		if (!ObjectUtil.containsNonSpace(form.getToken())) {
			sb.append(" token 未輸入 ,");
		}
		if (!ObjectUtil.containsNonSpace(form.getId())) {
			sb.append(" 編號 未輸入 ,");
		}
		
		return sb.toString();
	}
	public String validateDate(String startDate,String endDate) throws Exception {
		StringBuffer sb = new StringBuffer();
		try {
			if(ObjectUtil.containsNonSpace(startDate)) {
				DateUtil.parse(startDate, Constants.DATE_PATTERN);
			}
			
		}catch(Exception e) {	
			sb.append(" 日期(起)，格式異常(yyyy/MM/dd)");
		}
		try {
			if(ObjectUtil.containsNonSpace(endDate)) {
				DateUtil.parse(endDate, Constants.DATE_PATTERN);
			}
		}catch(Exception e) {	
			sb.append(" 日期(迄)，格式異常(yyyy/MM/dd)");
		}
		return sb.toString();
	}
}
