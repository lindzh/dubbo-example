package com.linda.dubbo;

import java.util.Map;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;

public class SimpleFilter implements Filter{

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation)
			throws RpcException {
		Map<String, String> context = RpcContext.getContext().getAttachments();
		String json = JSONUtils.toJson(context);
		System.out.println("call json:"+json);
		return invoker.invoke(invocation);
	}

}
