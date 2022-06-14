package com.psc.scLoan.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fori.util.LogUtil;



/**
 * @author wunhow
 *
 */

public class HTTPUtil {

	static final int DEFAULT_TIMES_RETRY = 3;
	static final int DEFAULT_SO_TIMEOUT = 60 * 1000; // Timeout in milliseconds

	public static String post(String url, Map<String, String> para) throws Exception {

		LogUtil.setInfoLog("post url:" + url);
		CloseableHttpClient client = HttpClients.createDefault();
		try {

			HttpPost httpPost = new HttpPost(url);
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();

			if (para != null && para.size() > 0) {
				for (String k : para.keySet()) {
					builder.addTextBody(k, para.get(k), ContentType.TEXT_PLAIN);
				}
			}

			HttpEntity multipart = builder.build();
			httpPost.setEntity(multipart);
			CloseableHttpResponse response = client.execute(httpPost);

			Integer status = -1;
			if (response != null)
				status = response.getStatusLine().getStatusCode();
			if (!status.equals(200)) {
				LogUtil.setInfoLog("post url:" + url + ";status:" + status);
				throw new HttpException();
			}

			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			String inputLine;
			StringBuffer r = new StringBuffer();

			while ((inputLine = reader.readLine()) != null) {
				r.append(inputLine);
			}
			reader.close();
			LogUtil.setInfoLog("post url:" + url + ";response:" + r.toString());
			return r.toString();
		} catch (Exception e) {
			LogUtil.setErrorLog("post", e);
			throw e;
		} finally {
			if (client != null)
				client.close();
		}
	}

	public static String get(String url, Map<String, String> para) throws Exception {

		CloseableHttpClient client = HttpClients.createDefault();
		try {
			if (para != null && para.size() > 0) {
				url += "?";
				for (String k : para.keySet()) {
					url += k + "=" + para.get(k);
				}
			}
			HttpGet httpGet = new HttpGet(url);
			CloseableHttpResponse response = client.execute(httpGet);
			Integer status = -1;
			if (response != null)
				status = response.getStatusLine().getStatusCode();
			if (!status.equals(200)) {
				LogUtil.setInfoLog("get url:" + url + ";status:" + status);
				throw new HttpException();
			}

			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			String inputLine;
			StringBuffer r = new StringBuffer();

			while ((inputLine = reader.readLine()) != null) {
				r.append(inputLine);
			}
			reader.close();
			LogUtil.setInfoLog("get url:" + url + ";response:" + r.toString());
			return r.toString();
		} catch (Exception e) {
			LogUtil.setErrorLog("get", e);
			throw e;
		} finally {
			if (client != null)
				client.close();
		}
	}

	public static String postRaw(String url, String raw) throws Exception {

		LogUtil.setInfoLog("post url:" + url);
		CloseableHttpClient client = HttpClients.createDefault();
		try {

			HttpPost httpPost = new HttpPost(url);
			StringEntity entity = new StringEntity(raw);
			httpPost.setEntity(entity);
			CloseableHttpResponse response = client.execute(httpPost);

			Integer status = -1;
			if (response != null)
				status = response.getStatusLine().getStatusCode();
			if (!status.equals(200)) {
				LogUtil.setInfoLog("post url:" + url + ";status:" + status);
				throw new HttpException();
			}

			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			String inputLine;
			StringBuffer r = new StringBuffer();

			while ((inputLine = reader.readLine()) != null) {
				r.append(inputLine);
			}
			reader.close();
			return r.toString();
		} catch (Exception e) {
			LogUtil.setErrorLog("post", e);
			throw e;
		} finally {
			if (client != null)
				client.close();
		}
	}

	public static String uploadFile(String url, String token, String filePath) throws Exception {

		CloseableHttpClient client = HttpClients.createDefault();
		try {

			HttpPost uploadFile = new HttpPost(url);
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.addTextBody("token", token, ContentType.TEXT_PLAIN);

			File f = new File(filePath);
			builder.addBinaryBody("photo", new FileInputStream(f), ContentType.APPLICATION_OCTET_STREAM, f.getName());

			HttpEntity multipart = builder.build();
			uploadFile.setEntity(multipart);
			CloseableHttpResponse response = client.execute(uploadFile);

			Integer status = -1;
			if (response != null)
				status = response.getStatusLine().getStatusCode();
			if (status != 200) {
				LogUtil.setInfoLog("url:" + url + ";status:" + status);
				throw new HttpException();
			}

			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			String inputLine;
			StringBuffer r = new StringBuffer();

			while ((inputLine = reader.readLine()) != null) {
				r.append(inputLine);
			}
			reader.close();
			return r.toString();
		} catch (Exception e) {
			LogUtil.setErrorLog("post", e);
			throw e;
		} finally {
			if (client != null)
				client.close();
		}
	}
	
	public static String sendRequestToString(String url,String language) throws IOException {
		LogUtil.setInfoLog("start:「"+url+"」");
		URLConnection conn = new URL(url).openConnection();
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		conn.setDoOutput(true);
		conn.setConnectTimeout(15000);
		conn.setReadTimeout(15000);
		conn.connect();
		InputStream inputStream = conn.getInputStream();
		InputStreamReader in = new InputStreamReader(inputStream, language);
		BufferedReader reader = new BufferedReader(in);
		StringBuffer sb = new StringBuffer();

		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		LogUtil.setInfoLog("end :result 「"+sb.toString()+"」");
		return sb.toString();
	}
}
