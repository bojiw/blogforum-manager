package com.blogforum.manager.common.utils;

import java.security.MessageDigest;
import java.util.Random;

import org.apache.log4j.Logger;

import com.blogforum.common.enums.BizErrorEnum;
import com.blogforum.common.exception.BusinessException;
import com.blogforum.manager.pojo.entity.AdminUser;
import com.blogforum.manager.pojo.entity.User;

public class MD5SaltUtils {
	private static Logger logger = Logger.getLogger(MD5SaltUtils.class);

	/**
	 * MD5+salt算法
	 * 
	 * @param rawPassword
	 * @param salt
	 * @return
	 * @author wwd
	 * @date 2017年2月25日下午3:15:51
	 * @version V1.0
	 */
	public static String encode(String rawPassword, String salt) {
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			result = encoder16(md.digest((addSalt(rawPassword, salt).getBytes("UTF-8"))));
		} catch (Exception e) {
			logger.error(BizErrorEnum.FAIL_ENCODE.getMsg(), e);
			throw new BusinessException(BizErrorEnum.SYS_EXCEPTION);
		}
		return result;
	}

	/**
	 * 给用户添加salt值
	 * 
	 * @param salt
	 * @return
	 * @author wwd
	 * @date 2017年2月25日下午3:18:56
	 * @version V1.0
	 */
	static User addUserSalt(String salt) {
		User user = new User();
		user.setSalt(salt);
		return user;
	}

	/**
	 * 给管理员用户添加salt值
	 * 
	 * @param salt
	 * @return
	 * @author wwd
	 * @date 2017年2月25日下午3:18:39
	 * @version V1.0
	 */
	static AdminUser addAdminUserSalt(String salt) {
		AdminUser adminUser = new AdminUser();
		adminUser.setSalt(salt);
		return adminUser;
	}

	/**
	 * 转换为16位字符串
	 * 
	 * @param b
	 * @return
	 * @author wwd
	 * @date 2017年2月25日下午3:18:13
	 * @version V1.0
	 */
	static String encoder16(byte[] b) {
		String ret = "";
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			ret += hex;
		}
		return ret;
	}

	static String addSalt(String password, String salt) {
		if (password == null) {
			password = null;
			;
		}
		if (salt == null || "".equals(salt)) {
			return password;
		} else {
			return password + salt.toString();
		}
	}

	/**
	 * 随机生一个8位salt值
	 * 
	 * @return
	 * @author wwd
	 * @date 2017年2月25日下午3:17:19
	 * @version V1.0
	 */
	public static String randomCreateSalt() {
		String strArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%&123456";
		Random random = new Random();
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < 8; i++) {
			int randomNum = random.nextInt(strArray.length());
			stringBuffer.append(strArray.charAt(randomNum));
		}
		return stringBuffer.toString();
	}

	public static String randomCreatePwd() {
		String strArray = "abcdefghijklmnopqrstuvwxyz1234567890";
		Random random = new Random();
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			int randomNum = random.nextInt(strArray.length());
			stringBuffer.append(strArray.charAt(randomNum));
		}
		return stringBuffer.toString();
	}
}
