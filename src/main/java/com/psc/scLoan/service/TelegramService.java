package com.psc.scLoan.service;

import org.springframework.stereotype.Service;

@Service
public class TelegramService {

	/**
	 * 電文 判斷是否補單成功
	 * 
	 * @return
	 */
	public boolean reissueDocuments() {
		return true;
	}
	
	/**
	 * 扣款
	 */
	public void doDebit() {
		
	}
	
	/**
	 * 電文 刪單
	 */
	public void removeDocuments() {

	}
	
}
