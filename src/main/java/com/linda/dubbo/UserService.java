package com.linda.dubbo;

import java.util.List;
import java.util.Map;

public interface UserService {
	
	public Map<String,Object> testContext(String haha);
	
	public Map<String,Object> testObject(long id,UserBean user);
	
	public Map<String,Object> testObjectToken(long id,UserToken user);
	
	public Map<String,Object> testToken2(long id,String token,Long userId,Integer userRole,String imei);
	
	public Map<String,Object> getById(long id);
	
	public Map<String,Object> testObjAa(long b,int a,Abcd abcd);
	
	public Map<String,Object> testTokenAndMobileType(String token,int id,String mobileType,String ip);

	public Map<String,Object> login(String account,String password);
	
	public Map<String,Object> reg(String account,String password,int age);
	
	public Map<String,Object> getUsers(List<String> accounts);
	
	public Map<String,Object> getUserByArray(String[] accounts);
	
	public Map<String,Object> loginBytes(byte[] acc,byte[] pass,String haha,int id2);
	
	public Map<String,Object> testMm2(int a,String b,boolean c,long d);
	
	public Map<String,Object> sessionTest(String session,String appVersion,long id);
	
	public Map<String,Object> testNull(String session,Integer idx);
	
	public Map<String,Object> testRisk(RiskObject risk,String sessionId,long id);

	public Map<String,Object> testRisk33(String sessionId,long id,RiskObject risk);
}
