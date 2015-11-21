package com.linda.dubbo;

import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;

public class SimpleGenericService implements GenericService{

	@Override
	public Object $invoke(String arg0, String[] arg1, Object[] arg2)
			throws GenericException {
		return null;
	}

}
