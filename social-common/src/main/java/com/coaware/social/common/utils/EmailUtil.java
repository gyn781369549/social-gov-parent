package com.coaware.social.common.utils;
/**
 * 发邮件
 * @author gengzhijie
 *
 */

import java.util.Random;


public class EmailUtil {
	/**
	 * @Title: getSMTPHostName
	 * @Description: 根据电子邮件地址取得该邮件地址的SMTP后缀地址
	 * @param @param email
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String getSMTPHostName(String email) {
		if (email == null || "".equals(email)) {
			return null;
		}
		String host = "smtp." + email.substring(email.lastIndexOf("@") + 1);
		return host;
	}
	
	/**
	 * 随机生成8位数字字符数组
	 * 
	 * @return rands
	 */
	public static String randomNumber8() {
		String param;
		//随机生成一个大写字母
		char[] codeSeq1 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
				'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z'};
		String[] fontTypes1 = {"Arial","Arial Black","AvantGarde Bk BT","Calibri"}; 
		Random random1 = new Random();
		StringBuilder s1 = new StringBuilder();
		for (int i = 0; i < 1; i++) {
			String r = String.valueOf(codeSeq1[random1.nextInt(codeSeq1.length)]);//random.nextInt(10));
			
			s1.append(r);
		}
		
		//随机生成一个小写字母
		char[] codeSeq2 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j',
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 't', 'u', 'v', 'w',
				'x', 'y', 'z'};
		
		Random random2 = new Random();
		for (int i = 0; i < 1; i++) {
			String r = String.valueOf(codeSeq2[random2.nextInt(codeSeq2.length)]);//random.nextInt(10));			
			s1.append(r);
		}
		param = s1.toString();
		
		//随机生成一个数字
		String chars = "0123456789";
		char[] rands = new char[1];
		for (int i = 0; i < 1; i++) {
			int rand = (int) (Math.random() * 10);
			rands[i] = chars.charAt(rand);
		}
		param = param+(new String(rands));
		
		//随机生成长度为 5 的字符串
		char[] codeSeq = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
				'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9' ,
				'1','0','a','b','c','d','e','f'};
		
		Random random = new Random();
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			String r = String.valueOf(codeSeq[random.nextInt(codeSeq.length)]);//random.nextInt(10));
			
			s.append(r);
		}
		param = param+(s.toString());
		return param;
	}
	
			
	public  EmailUtil()
	{

		
	
	}
		


		public static void main(String args[])
		{
			System.out.println(randomNumber8());
			//System.out.println("随机数"+randomNumber6());			
			//System.out.println("随机数"+getSMTPHostName("930040863@qq.com"));
			//sendEmail(new String[]{"xxx@163.com"},new String[]{"xxx@gmail.com"}, "测试发送邮件功能13:25！", "邮件标题13：25");
		}
	
}
