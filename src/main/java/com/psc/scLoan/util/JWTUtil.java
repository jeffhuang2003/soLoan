package com.psc.scLoan.util;

import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.fori.util.Id;
import com.fori.util.MD5;
import com.google.gson.Gson;
import com.psc.scLoan.model.UserProf;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Service
public class JWTUtil {

//	private static final String signature = "foritech";
	private static final String USERID = "id";
	private static final String ACCOUNT = "account";
	private static final String NAME = "name";
	private static final String ENNAME = "enName";
	private static final String ENV = "environment";
	
	public static UserProf parseJWT(String jsonWebToken,String signature) {
		UserProf obj = new UserProf();
		try {
			Claims claims = Jwts.parser().setSigningKey(MD5.encode(signature)).parseClaimsJws(jsonWebToken).getBody();
			HashMap<String, Object> mapObj = new Gson().fromJson(claims.getSubject(), HashMap.class);
			obj.setId((String)mapObj.get(USERID));
			obj.setAccount((String)mapObj.get(ACCOUNT));
			obj.setName((String)mapObj.get(NAME));
//			obj.setEn_name((String)mapObj.get(ENNAME));
			return obj;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
//	iss: 發行者的 token
//	sub: 主題的 token
//	aud: 接受者(聽眾)的 token
//	exp: 這可能是 Registered Claims 最常用的，定義數字格式的有效期限，重點是有效期限一定要大於現在的時間
//	nbf: 生效時間，定義一個時間在這個時間之前 JWT 不能進行處理
//	iat: 發行的時間，可以被用來判斷 JWT 已經發出了多久
//	jti: JWT 唯一的識別值，可用來防止 JWT 被重複使用，尤其在一次性的 token 特別好用
	public static String createJWT(String subject,String signature) {
		JwtBuilder builder = null;
		try {
			SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
			long nowMillis = System.currentTimeMillis();
//			long expMillis = nowMillis + 1000 * 60 * 60 * 24;
			Date now = new Date(nowMillis);
//			Date exp = new Date(expMillis);
			// ADD JWT的参数
			builder = Jwts.builder().setId(Id.id32()).setHeaderParam("typ", "JWT").setHeaderParam("alg", "HS256")
					.setSubject(subject).setIssuedAt(now).signWith(signatureAlgorithm, MD5.encode(signature));
			// ADD Token Expiration
//			builder.setExpiration(exp);
//			LogUtil.setInfoLog("JWT now:" + now);
//			LogUtil.setInfoLog("JWT exp:" + exp);
		} catch (Exception e) {
			e.printStackTrace();		}
		// 生成JWT
		return builder.compact();
	}

	/**
	 * 生成subject信息
	 * 
	 * @param user
	 * @return
	 */
	public static String generalSubject(UserProf userProf,String env,String language) {
		HashMap<String, Object> obj = new HashMap<String, Object>();
		obj.put(USERID, userProf.getId());
		obj.put(ACCOUNT, userProf.getAccount());
		obj.put(NAME, userProf.getName());
//		obj.put(ENNAME, userProf.getEn_name());
		obj.put(ENV, env);

		return new Gson().toJson(obj);
	}
	
	
	

}