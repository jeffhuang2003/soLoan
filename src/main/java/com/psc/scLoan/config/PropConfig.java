package com.psc.scLoan.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:config.properties", encoding = "utf-8")
public class PropConfig {
	@Value("${project.name}")
	private String projectName;
	@Value("${domain.url}")
	private String domainUrl;
	@Value("${url.port}")
	private String urlPort;
	@Value("${appliction.service.url}")
	private String applictionUrl;
	@Value("${service.url}")
	private String serviceUrl;
	@Value("${is.simulate}")
	private String isSimulate;
	@Value("${ldap.url}")
	private String ldap_url;
	@Value("${ldap.bind.dn}")
	private String ldap_bind_dn;
	@Value("${is.ad}")
	private String isAd;
	@Value("${file.read.url}")
	private String fileReadUrl;
	@Value("${file.upload.path}")
	private String fileUpload;

	
	
	
	
	public String getUrlPort() {
		return urlPort;
	}

	public void setUrlPort(String urlPort) {
		this.urlPort = urlPort;
	}



	public String getApplictionUrl() {
		return applictionUrl;
	}

	public void setApplictionUrl(String applictionUrl) {
		this.applictionUrl = applictionUrl;
	}





	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	

	public String getDomainUrl() {
		return domainUrl;
	}

	public void setDomainUrl(String domainUrl) {
		this.domainUrl = domainUrl;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getLdap_url() {
		return ldap_url;
	}

	public String getIsSimulate() {
		return isSimulate;
	}

	public void setIsSimulate(String isSimulate) {
		this.isSimulate = isSimulate;
	}

	public void setLdap_url(String ldap_url) {
		this.ldap_url = ldap_url;
	}

	public String getLdap_bind_dn() {
		return ldap_bind_dn;
	}

	public void setLdap_bind_dn(String ldap_bind_dn) {
		this.ldap_bind_dn = ldap_bind_dn;
	}

	public String getIsAd() {
		return isAd;
	}

	public void setIsAd(String isAd) {
		this.isAd = isAd;
	}

	public String getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(String fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getFileReadUrl() {
		return fileReadUrl;
	}

	public void setFileReadUrl(String fileReadUrl) {
		this.fileReadUrl = fileReadUrl;
	}










	


	

}
