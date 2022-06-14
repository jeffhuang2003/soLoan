package com.psc.scLoan.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.fori.util.LogUtil;
import com.psc.scLoan.config.PropConfig;
import com.psc.scLoan.constants.Constants;

import freemarker.template.Template;

@Service
public class MailService {
	@Autowired
	private PropConfig propConfig;
	@Autowired
	private FreeMarkerConfigurer fmc;
	@Autowired
	private JavaMailSender sender;
	@Autowired
	private OptionsService optionsService;

	public void sendText(List<String> to, String subject, String taskName, String event) throws MessagingException {
		LogUtil.setInfoLog("mail通知:" + subject + ",task:[" + taskName + "]" + ",event:[" + event + "]");
		try {
			if ("1".equals(propConfig.getIsSimulate())) {
//				List<HashMap<String, String>> remindUsers = optionsService.getRemindUserOptions(Constants.LANGUAGE_ZH);
//				for (HashMap<String, String> map : remindUsers) {
//					to.add(map.get(Constants.MAP_LABEL));
//				}
			}
			MimeMessage mimeMessage = sender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setTo(to.toArray(new String[0]));

			Template t = fmc.getConfiguration().getTemplate("remind.html", "UTF-8");
			Map<String, Object> map = new HashMap<>();
			map.put("taskName", taskName);
			map.put("event", event);
			map.put("serviceUrl", propConfig.getServiceUrl());
			map.put("frontUrl", propConfig.getApplictionUrl());
			map.put("env", "【" + propConfig.getServiceUrl() + "】");
			String content = FreeMarkerTemplateUtils.processTemplateIntoString(t, map);
			mimeMessageHelper.setText(content, true);
			sender.send(mimeMessage);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	public void sendSystemText(List<String> to, String subject, String body) throws MessagingException {
		try {
			if ("1".equals(propConfig.getIsSimulate())) {
//				List<HashMap<String, String>> remindUsers = optionsService.getRemindUserOptions(Constants.LANGUAGE_ZH);
//				for (HashMap<String, String> map : remindUsers) {
//					to.add(map.get(Constants.MAP_LABEL));
//				}
			}
			MimeMessage mimeMessage = sender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setTo(to.toArray(new String[0]));

			Template t = fmc.getConfiguration().getTemplate("remindAdmin.html", "UTF-8");
			Map<String, Object> map = new HashMap<>();
			map.put("subject", subject);
			map.put("body", body);
			map.put("serviceUrl", propConfig.getServiceUrl());
			map.put("frontUrl", propConfig.getApplictionUrl());
			map.put("env", "【" + propConfig.getServiceUrl() + "】");
			String content = FreeMarkerTemplateUtils.processTemplateIntoString(t, map);
			mimeMessageHelper.setText(content, true);
			sender.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 
	 * @param to
	 * @param subject
	 * @param text
	 * @param filePath
	 * @throws MessagingException
	 */
	public void sendAttachments(String to, String subject, String text, String filePath) throws MessagingException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(to);
		helper.setFrom("");
		helper.setSubject(subject);
		helper.setText(text, true);
		FileSystemResource file = new FileSystemResource(new File(filePath));
		String attachmentFilename = filePath.substring(filePath.lastIndexOf(File.separator) + 1);
		helper.addAttachment(attachmentFilename, file);
		sender.send(message);
	}

}
