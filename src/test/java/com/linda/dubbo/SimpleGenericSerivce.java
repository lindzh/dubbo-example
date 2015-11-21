package com.linda.dubbo; 

import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;

public class SimpleGenericSerivce implements GenericService{

	@Override
	public Object $invoke(String methodName, String[] argsType, Object[] args)
			throws GenericException {
		System.out.println("method:"+methodName+" argsType:"+argsType);
		return new User(44,"user","pwd",23);
	}

}
