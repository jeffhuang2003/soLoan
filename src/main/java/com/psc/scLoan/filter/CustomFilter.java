package com.psc.scLoan.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.fori.util.LogUtil;
import com.fori.util.WebUtil;
import com.psc.scLoan.config.PropConfig;

@Component
public class CustomFilter implements Filter {
	@Autowired
	private PropConfig fileConfig;
	String param = "";


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String info= fileConfig.getIsSimulate()+"-"+fileConfig.getProjectName()+fileConfig.getDomainUrl()+":"+fileConfig.getUrlPort();
		LogUtil.setInfoLog("☆PSCNET info☆-Config#Simulat:"+info);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, filterConfig.getServletContext());
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		ServletRequest requestWrapper = null;
		StringBuffer sb = new StringBuffer();

		if (request instanceof HttpServletRequest) {
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			if ("POST".equals(httpServletRequest.getMethod().toUpperCase())
					&& httpServletRequest.getContentType().equalsIgnoreCase("application/json; charset=utf-8")) {
				requestWrapper = new BodyReaderHttpServletRequestWrapper((HttpServletRequest) request);
				param = this.getBodyString(requestWrapper.getReader());
				if (param.length() > 0) {
					LogUtil.setInfoLog("RequestBody=>" + param);
					sb.append("RequestBody=>"+param);
				}
			}
		}

		Map<String, String[]> paramMap = request.getParameterMap();
		if (paramMap.size() > 0) {
			List<String> result = new ArrayList<String>(paramMap.keySet());
			for (String paramStr : result) {
				if (!"token".equals(paramStr)) {
					sb.append(paramStr);
					String[] paramArray = paramMap.get(paramStr);
					sb.append("=>" );
					for (String paramArrayStr : paramArray) {
						sb.append( paramArrayStr + "-");
					}
					sb.append("," );
				}
			}
		}
		if(sb.toString().length()>0) {
			LogUtil.setInfoLog(WebUtil.getRemoteAddr(request) + ">" + request.getMethod() + "-" + request.getRequestURI()+","+sb.toString());
		}else {
			if(request.getMethod().indexOf("OPTIONS")<0) {
				LogUtil.setInfoLog(WebUtil.getRemoteAddr(request) + ">" + request.getMethod() + "-" + request.getRequestURI()+",");
			}
		}	

		if (requestWrapper == null) {
			filterChain.doFilter(request, response);
		} else {
			filterChain.doFilter(requestWrapper, response);
		}

	}

	@Override
	public void destroy() {
	}

	public String getBodyString(BufferedReader br) {
		String inputLine;
		String str = "";
		try {
			while ((inputLine = br.readLine()) != null) {
				str += inputLine;
			}
			br.close();
		} catch (IOException e) {
			LogUtil.setErrorLog("IOException: " , e);
		}
		return str;

	}

}
