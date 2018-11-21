package cn.itcast.ssm.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5_test {

		public static String getMd5(String source){

		String salt = "qwerty";
		int hashIterations = 1;

		//第一个参数：散列算法
		//第二个参数：明文，原始密码
		//第三个参数：盐，通过使用随机数
		//第四个参数：散列的次数
		SimpleHash simpleHash = new SimpleHash("md5", source, salt, hashIterations);
		return simpleHash.toString();
	}

}
