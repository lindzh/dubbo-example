package com.linda.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;

public class DubboServer {
	
	public static void main(String[] args) throws InterruptedException {
		ApplicationConfig appConfig = new ApplicationConfig();
		appConfig.setName("dubbo");
		
		
		ProtocolConfig protocolConfig = new ProtocolConfig();
		protocolConfig.setHost("0.0.0.0");
		protocolConfig.setPort(5443);
		ProviderConfig providerConfig = new ProviderConfig();
		providerConfig.setProtocol(protocolConfig);
		
		providerConfig.setFilter("SimpleFilter");
		
		RegistryConfig registryConfig = new RegistryConfig();
		registryConfig.setProtocol("zookeeper");
		registryConfig.setAddress("121.40.183.89:2181");
		
		ServiceConfig serviceConfig = new ServiceConfig();
		serviceConfig.setApplication(appConfig);
		serviceConfig.setProvider(providerConfig);
		serviceConfig.setRegistry(registryConfig);
		
		serviceConfig.setInterface(UserService.class);
		serviceConfig.setRef(new UserServiceImpl());
		serviceConfig.setVersion("1.2_test");
		serviceConfig.export();
		
		ServiceConfig hello = new ServiceConfig();
		hello.setApplication(appConfig);
		hello.setProvider(providerConfig);
		hello.setRegistry(registryConfig);
		
		hello.setInterface(HelloService.class);
		hello.setRef(new HelloServiceImpl());
		hello.setVersion("1.6_test");
		hello.export();
		
//		ServiceConfig<GenericService> genericService = new ServiceConfig<GenericService>();
//		genericService.setApplication(appConfig);
//		genericService.setProvider(providerConfig);
//		genericService.setRegistry(registryConfig);
//		
//		genericService.setInterface(UserService.class);
//		genericService.setRef(new SimpleGenericSerivce());
//		genericService.setVersion("2.0");
//		genericService.export();
		
		System.out.println("---------started-------------");
		while(true);
		
	}

}
