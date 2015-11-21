package com.linda.dubbo;


public interface HelloService {
	
	public RpcResult<String> hello(String hi);
	
	public RpcResult<Integer> getInt(String key);

}
