package com.psc.scLoan.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fori.util.NumberUtil;
import com.psc.scLoan.constants.Constants;
import com.psc.scLoan.model.Options;
import com.psc.scLoan.repository.OptionsRepository;

/**
 * 後台管理者
 * 
 * @author wunhow
 *
 */
@Service
public class OptionsService {

	@Autowired
	private OptionsRepository repository;

	public void testDB() throws Exception {
		repository.testDB();
	}

	public HashMap<String, String> findOptions(String category, String status, String language) throws Exception {
		List<Options> optionList = repository.findList(category, status, language);
		HashMap<String, String> result = new HashMap<String, String>();
		for (Options obj : optionList) {
			result.put(obj.getVal(), obj.getLabel());
		}
		return result;
	}

	/**
	 * 取得狀態Map
	 * 
	 * @return
	 * @throws Exception
	 */
	public HashMap<String, String> getStatusOptions(String language) throws Exception {
		return this.findOptions(Constants.STATUS_OPTION, Constants.STATUS_ON, language);
	}

	/**
	 *
	 * 取得月份選單
	 * 
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public List<HashMap<String, String>> getMonthsOption() throws Exception {
		LinkedList<HashMap<String, String>> list = new LinkedList<HashMap<String, String>>();
		HashMap<String, String> result = new HashMap<String, String>();
		String str = "%02d";
		for (int i = 1; i < 13; i++) {
			result = new HashMap<String, String>();
			result.put(Constants.MAP_VAL, String.format(str, i));
			result.put(Constants.MAP_LABEL, String.format(str, i));
			list.add(result);
		}
		return list;
	}

	/**
	 * 取得狀態選單
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<HashMap<String, String>> getStatusOptionList(String language) throws Exception {
		List<Options> optionList = repository.findList(Constants.STATUS_OPTION, Constants.STATUS_ON, language);
		LinkedList<HashMap<String, String>> list = new LinkedList<HashMap<String, String>>();
		HashMap<String, String> result = new HashMap<String, String>();
		for (Options obj : optionList) {
			result = new HashMap<String, String>();
			result.put(Constants.MAP_VAL, obj.getVal());
			result.put(Constants.MAP_LABEL, obj.getLabel());
			list.add(result);
		}
		return list;
	}

	/**
	 * 取得角色選單
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<HashMap<String, String>> getRoleOptionList(String language) throws Exception {
		List<Options> optionList = repository.findList(Constants.ROLE_OPTION, Constants.STATUS_ON, language);
		LinkedList<HashMap<String, String>> list = new LinkedList<HashMap<String, String>>();
		HashMap<String, String> result = new HashMap<String, String>();
		for (Options obj : optionList) {
			result = new HashMap<String, String>();
			result.put(Constants.MAP_VAL, obj.getVal());
			result.put(Constants.MAP_LABEL, obj.getLabel());
			list.add(result);
		}
		return list;
	}

}
