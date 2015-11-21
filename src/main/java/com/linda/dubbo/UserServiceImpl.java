package com.linda.dubbo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.alibaba.dubbo.rpc.RpcContext;

public class UserServiceImpl implements UserService{
	
	private AtomicLong index = new AtomicLong(1);
	
	private Map<Long,User> userIdMap = new ConcurrentHashMap<Long,User>();
	
	private Map<String,User> userAccountMap = new ConcurrentHashMap<String,User>();
	
	public UserServiceImpl(){
		User user1 = new User(index.get(),"test","123456",44);
		userIdMap.put(user1.getId(), user1);
		userAccountMap.put(user1.getName(), user1);
		index.incrementAndGet();
		User user2 = new User(index.get(),"admin","654321",21);
		userIdMap.put(user2.getId(), user2);
		userAccountMap.put(user2.getName(), user2);
	}

	@Override
	public Map<String,Object> getById(long id) {
		User user = userIdMap.get(id);
		if(user!=null){
			return KopUtils.packResult(200, "success", user);
		}else{
			return KopUtils.packResult(401, "not found", null);
		}
	}

	@Override
	public Map<String,Object> login(String account, String password) {
		User user = userAccountMap.get(account);
		if(user==null){
			return KopUtils.packResult(401, "not found", null);
		}
		if(!user.getPassword().equals(password)){
			return KopUtils.packResult(301, "wrong password", null);
		}
		return KopUtils.packResult(200, "success", user);
	}

	@Override
	public Map<String,Object> reg(String account, String password, int age) {
		User user = userAccountMap.get(account);
		if(user!=null){
			return KopUtils.packResult(302, "user already registered", null);
		}
		index.incrementAndGet();
		User user2 = new User(index.get(),account,password,age);
		userIdMap.put(user2.getId(), user2);
		userAccountMap.put(user2.getName(), user2);
		return KopUtils.packResult(200, "success", user2);
	}

	@Override
	public Map<String,Object> getUsers(List<String> accounts) {
		ArrayList<User> users = new ArrayList<User>();
		for(String account:accounts){
			User user = userAccountMap.get(account);
			if(user!=null){
				users.add(user);
			}
		}
		return KopUtils.packResult(200, "success", users);
	}

	@Override
	public Map<String,Object> getUserByArray(String[] accounts) {
		List<String> accs = Arrays.asList(accounts);
		return this.getUsers(accs);
	}

	@Override
	public Map<String,Object> loginBytes(byte[] acc, byte[] pass,String haha,int id2) {
		String account = new String(acc);
		String password = new String(pass);
		User user = userAccountMap.get(account);
		if(user==null){
			return KopUtils.packResult(401, "not found", null);
		}
		if(!user.getPassword().equals(password)){
			return KopUtils.packResult(301, "wrong password", null);
		}
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("user", user);
		map.put("haha", haha);
		map.put("id",id2);
		return KopUtils.packResult(200, "success", map);
	}

	@Override
	public Map<String, Object> testObject(long id, UserBean user) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("idx", id);
		map.put("user", user);
		return KopUtils.packResult(200, "request success", map);
	}

	@Override
	public Map<String, Object> testTokenAndMobileType(String token, int id,
			String mobileType, String ip) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("token", token);
		map.put("ixd", id);
		map.put("mobileType", mobileType);
		map.put("ip", ip);
		map.put("test", "5555555");
		return KopUtils.packResult(200, "request success", map);
	}

	@Override
	public Map<String, Object> testMm2(int a, String b, boolean c, long d) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("inta", a);
		map.put("stringb", b);
		map.put("booleanc", c);
		map.put("longd", d);
		map.put("test", "122222---testMm2");
		return KopUtils.packResult(200, "request success", map);
	}

	@Override
	public Map<String, Object> testObjectToken(long id, UserToken user) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("usr", user);
		return KopUtils.packResult(200, "request success", map);
	}

	@Override
	public Map<String, Object> testObjAa(long b, int a, Abcd abcd) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("b", b);
		map.put("a", a);
		map.put("abcd", abcd);
		return KopUtils.packResult(200, "request success", map);
	}

	@Override
	public Map<String, Object> sessionTest(String session, String appVersion, long id) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("session", session);
		map.put("appVersion", appVersion);
		map.put("id", id);
		return KopUtils.packResult(200, "request success", map);
	}

	@Override
	public Map<String, Object> testNull(String str, Integer idx) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("str", str);
		map.put("idx", idx);
		return KopUtils.packResult(200, "request success", map);
	}

	@Override
	public Map<String, Object> testRisk(RiskObject risk, String sessionId, long id) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("risk", risk);
		map.put("idx", id);
		map.put("sessionId", sessionId);
		return KopUtils.packResult(200, "request success", map);
	}

	@Override
	public Map<String, Object> testToken2(long id, String token, Long userId, Integer userRole, String imei) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		map.put("token", token);
		map.put("userRole", userRole);
		map.put("imei", imei);
		map.put("id", id);
		return KopUtils.packResult(200, "request success", map);
	}

	@Override
	public Map<String, Object> testRisk33(String sessionId, long id, RiskObject risk) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("risk22", risk);
		map.put("idx", id);
		map.put("sessionId", sessionId);
		map.put("version", "testRisk22");
		return KopUtils.packResult(200, "request success", map);
	}

	@Override
	public Map<String, Object> testContext(String haha) {
		String attachment = RpcContext.getContext().getAttachment("riskParams");
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("haha", haha);
		map.put("riskParam", JSONUtils.fromJson(attachment, Map.class));
		return KopUtils.packResult(200, "request success", map);
	}

}
