package com.linda.dubbo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.GenericService;

public class DubboClient {
	
	public static void main(String[] args) {
		ApplicationConfig appConfig = new ApplicationConfig();
		appConfig.setName("dubbo");
		
		ConsumerConfig consumerConfig = new ConsumerConfig();
		consumerConfig.setTimeout(10000);
		consumerConfig.setRetries(3);
		
		RegistryConfig registryConfig = new RegistryConfig();
		registryConfig.setProtocol("zookeeper");
		registryConfig.setAddress("10.0.50.150:2181");
		
		ReferenceConfig referenceConfig = new ReferenceConfig();
		referenceConfig.setApplication(appConfig);
		referenceConfig.setConsumer(consumerConfig);
		referenceConfig.setRegistry(registryConfig);
		
		referenceConfig.setInterface(UserService.class);
		referenceConfig.setVersion("1.2_dev");
		UserService userService = (UserService)referenceConfig.get();
		
		Map<String, Object> user = userService.getById(1);
		System.out.println(user);
		
		ReferenceConfig<GenericService> genericService = new ReferenceConfig<GenericService>();
		genericService.setApplication(appConfig);
		genericService.setConsumer(consumerConfig);
		genericService.setRegistry(registryConfig);
		genericService.setGeneric(true);
		genericService.setInterface("com.linda.dubbo.UserService");
		genericService.setVersion("1.2_dev");
		GenericService service = genericService.get();
		
		RpcContext.getContext().setAttachment("haha", "this is a test login");
		Object $invoke = service.$invoke("login", new String[]{"java.lang.String","java.lang.String"}, new Object[]{"test","123456"});
		System.out.println($invoke);
		
		List<String> list = new ArrayList<String>();
		list.add("admin");
		list.add("test");
		RpcContext.getContext().setAttachment("haha", "this is a test getUsers");
		Object object = service.$invoke("getUsers", new String[]{"java.util.List"}, new Object[]{list});
		System.out.println(object);
		
		RpcContext.getContext().setAttachment("haha", "this is a test getUserByArray");
		Object $invoke2 = service.$invoke("getUserByArray", new String[]{"java.lang.String[]"}, new Object[]{list.toArray()});
		System.out.println($invoke2);
	
		RpcContext.getContext().setAttachment("haha", "this is a test loginBytes");
		Object $invoke3 = service.$invoke("loginBytes", new String[]{"byte[]","byte[]"}, new Object[]{"test".getBytes(),"123456".getBytes()});
		System.out.println($invoke3);
	}

}
