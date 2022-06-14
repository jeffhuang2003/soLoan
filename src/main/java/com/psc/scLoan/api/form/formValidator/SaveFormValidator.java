	package com.psc.scLoan.api.form.formValidator;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import com.fori.util.LogUtil;
import com.psc.scLoan.api.form.SaveForm;
import com.psc.scLoan.util.ObjectUtil;
@Service
public class SaveFormValidator  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String validate(SaveForm form) throws Exception {
		LogUtil.logObjectToString(form);

		StringBuffer sb = new StringBuffer();
		if(!ObjectUtil.containsNonSpace(form.getToken())){
			sb.append(" token 未輸入 ,");
		}
		if(!ObjectUtil.containsNonSpace(form.getStatus())){
			sb.append(" status 未輸入 ,");
		}
	
		return  sb.toString();
	}
	
	/**
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String validateChild(SaveForm form) throws Exception {
		LogUtil.logObjectToString(form);

		StringBuffer sb = new StringBuffer();
		if(!ObjectUtil.containsNonSpace(form.getToken())){
			sb.append(" token 未輸入 ,");
		}
		
		return  sb.toString();
	}
	
	
}
