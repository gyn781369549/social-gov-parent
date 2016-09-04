package com.coaware.social.common.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author zhangyahua
 * 
 */
public class Base64Util {

	private static final Log LOG = LogFactory.getLog(Base64Util.class);

	/**
	 * 编码
	 * 
	 * @param content
	 * @return
	 */
	public static String encode(String content)
			throws Exception {
		byte[] b = content.getBytes();
		Base64 base64 = new Base64();
		b = base64.encode(b);
		String s = new String(b);
		return s;
	}

	/**
	 * 解码
	 * 
	 * @param content
	 * @return
	 */
	public static String decode(String content) {
		byte[] b = content.getBytes();
		Base64 base64 = new Base64();
		b = base64.decode(b);
		String s = new String(b);
		return s;

	}

	public static void main(String[] args) throws Exception {
		String msg = "加密";
		String charset = "UTF-8";
		msg = Base64Util.encode(msg);
		System.out.println("encode:" + msg);
		System.out.println("decode:" + Base64Util.decode(msg));
	}

}
