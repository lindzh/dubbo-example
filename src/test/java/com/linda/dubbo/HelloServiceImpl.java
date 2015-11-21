package com.linda.dubbo;


public class HelloServiceImpl implements HelloService{

	@Override
	public RpcResult<String> hello(String hi) {
		return new RpcResult<String>(200,"success","HelloService--"+hi);
	}

	@Override
	public RpcResult<Integer> getInt(String key) {
		return new RpcResult<Integer>(200,"",19);
	}

}
