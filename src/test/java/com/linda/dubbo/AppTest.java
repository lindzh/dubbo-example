package com.linda.dubbo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


/**
 * Unit test for simple App.
 */
public class AppTest {
  public static void main(String[] args) throws UnsupportedEncodingException {
	  AppBean bean = new AppBean();
	  bean.setName("refff");
	  byte[] bytes = "43434".getBytes();
	  bean.setAas(bytes);
	  String json = JSONUtils.toJson(bean);
	  System.out.println(json);
	  AppBean appBean = JSONUtils.fromJson(json, AppBean.class);
	  byte[] aas = appBean.getAas();
	  String string = new String(aas);
	  System.out.println(string);
	  
	  System.out.println("---------------------");
	  String decode = URLDecoder.decode("33%E6%89%93%E5%BC%80%E4%B8%8A%E9%9D%A2%E7%BD%91%E5%9D%80%E6%BB%B4%E6%BB%B4%E4%BB%A3%E9%A9%BE%E6%8A%A5%E5%90%8D", "utf-8");
	  System.out.println(decode);
}
}
