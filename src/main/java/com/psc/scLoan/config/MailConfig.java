package com.psc.scLoan.config;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.fori.util.LogUtil;

@Configuration
@ConfigurationProperties(prefix = "spring.mail")
public class MailConfig {
	private static final String STARTTLS = "mail.smtp.starttls.enable";
	private static final String DEBUG = "false";
	private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

	static final int TIMEOUT = 50000;
	/** SMTP server host. For instance, `smtp.example.com`. */
	private String host;
	/** SMTP server port. */
	private Integer port;
	/*** Login user of the SMTP server. */
	private String username;
	private String password;
	/** Protocol used by the SMTP server. */
	private String protocol = "smtp";
	/** Default MimeMessage encoding. */
	private Charset defaultEncoding = DEFAULT_CHARSET;

	/** Additional JavaMail Session properties. */
	private Map<String, String> properties = new HashMap<>();

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(this.getHost());
		mailSender.setPort(this.getPort());

		mailSender.setUsername(this.getUsername());
		mailSender.setPassword(this.getPassword());

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.smtp.starttls.enable", this.getProperties().get(STARTTLS));
		props.put("mail.debug", DEBUG);
		props.put("mail.transport.protocol", getProtocol());
		props.put("mail.smtp.host", this.getHost());
		// 正式機 false
		props.put("mail.smtp.auth", false);
		props.put("mail.smtp.connectiontimeout", TIMEOUT);
		props.put("mail.smtp.timeout", TIMEOUT);
		properties.put("mail.smtp.localhost", "localhost");
		LogUtil.setInfoLog(this.getHost());
		LogUtil.setInfoLog("getPort:" + this.getPort());
		LogUtil.setInfoLog(this.getUsername());
		LogUtil.setInfoLog(this.getPassword());
		LogUtil.setInfoLog(this.getProperties().toString());
		return mailSender;
	}

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return this.port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProtocol() {
		return this.protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public Charset getDefaultEncoding() {
		return this.defaultEncoding;
	}

	public void setDefaultEncoding(Charset defaultEncoding) {
		this.defaultEncoding = defaultEncoding;
	}

	public Map<String, String> getProperties() {
		return this.properties;
	}
}
