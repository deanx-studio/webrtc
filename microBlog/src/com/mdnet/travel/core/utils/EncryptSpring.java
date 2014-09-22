package com.mdnet.travel.core.utils;

import java.security.NoSuchAlgorithmException;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

public class EncryptSpring {
	public static String md5_32(String password) {
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		// false 表示：生成32位的Hex版, 这也是encodeHashAsBase64的, Acegi 默认配置; true
		// 表示：生成24位的Base64版
		md5.setEncodeHashAsBase64(false);
		return md5.encodePassword(password, null);
	}

	public static String md5_24(String password) {
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		// false 表示：生成32位的Hex版, 这也是encodeHashAsBase64的, Acegi 默认配置; true
		// 表示：生成24位的Base64版
		md5.setEncodeHashAsBase64(true);
		return md5.encodePassword(password, null);
	}

	public static String sha_256_44(String pass) throws NoSuchAlgorithmException {
		ShaPasswordEncoder sha = new ShaPasswordEncoder(256);
		sha.setEncodeHashAsBase64(true);
		return sha.encodePassword(pass, null);
	}

	public static String sha_SHA_256_40(String pass) {
		ShaPasswordEncoder sha = new ShaPasswordEncoder();
		sha.setEncodeHashAsBase64(false);
		return sha.encodePassword(pass, null);
	}

	public static String md5_SystemWideSaltSource_32(String username,String pass) {
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		md5.setEncodeHashAsBase64(false);

		// 使用动态加密盐的只需要在注册用户的时候将第二个参数换成用户名即可
		return md5.encodePassword(pass, username);
	}
}
