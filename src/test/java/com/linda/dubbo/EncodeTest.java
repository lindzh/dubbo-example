package com.linda.dubbo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class EncodeTest {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String encode = URLDecoder.decode("iphone7%2C%2C%2C%2C", "utf-8");
		System.out.println(encode);
	}

}
