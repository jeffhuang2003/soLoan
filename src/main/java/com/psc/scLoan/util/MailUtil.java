package com.psc.scLoan.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fori.util.LogUtil;
import com.google.gson.Gson;
import com.psc.scLoan.service.MailService;
import com.psc.scLoan.service.UserProfService;

/**
 * 
 * 
 * @author wunhow 
 * 
 */
@Service
public class MailUtil {
	@Autowired
	private MailService mailService;
	@Autowired
	private UserProfService userProfService;

	/**
	 * pmc選擇流程完成=>通知任務負責人
	 * 
	 * @param taskerObj
	 * @param taskObj
	 * @throws MessagingException
	 */
	public void sendChoseFlowNotice(String taskerEmail) throws Exception {
		List<String> toList = new ArrayList<String>();
		toList.add(taskerEmail);
		String taskInfo = "";
		String subject = "[通知任務負責人] "+taskInfo + "選擇流程已完成";
		String event = "已選擇流程，請準備關卡相關文件並上傳";
		this.send(toList, subject, taskInfo, event);
	}
	
	
	public void send(List<String> to, String subject, String taskName, String event) {

		// 建立 2 個 thread 的 thread pool
		ExecutorService executor = Executors.newFixedThreadPool(1);

		// 執行實作了 Runnable 介面的內部類別 Work
		executor.execute(new mailThread(mailService,to,subject,taskName,event));
	}

	public class mailThread implements Runnable {
		private List<String> to;
		private String subject;
		private String taskInfo;
		private String event;
		private MailService service;

		public mailThread(MailService service,List<String> to, String subject, String taskInfo, String event) {
			this.to= to;
			this.subject=subject;
			this.taskInfo = taskInfo;
			this.event=event;
			this.service = service;
		}

		public void run() {
			String receiver = new Gson().toJson(to);
			try {
				LogUtil.setInfoLog(Thread.currentThread().getName() + " Begins Send=>" + event+",receiver="+receiver);
				service.sendText(to, subject, taskInfo, event);			
				Thread.sleep(5000);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			LogUtil.setInfoLog(Thread.currentThread().getName() + " Ends Send=>" + event+",receiver="+receiver);
		}
	}
}