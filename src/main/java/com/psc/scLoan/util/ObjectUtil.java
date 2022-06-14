package com.psc.scLoan.util;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * 
 * @author wunhow 
 * 
 */
public class ObjectUtil {

	/**
	 * @param object
	 * @return
	 */
	public static boolean containsNonSpace(Object object) {
		return (object != null && object.toString().trim().length() >= 1);
	}

	/**
	 * @param file
	 * @return
	 */
	public static boolean isNotEmptyFile(MultipartFile file) {
		return file != null && !file.isEmpty();
	}

}