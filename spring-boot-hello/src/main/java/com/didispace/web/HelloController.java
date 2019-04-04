package com.didispace.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
public class HelloController {
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping("/hello")
	public String index() {
		ServiceInstance  si = client.getLocalServiceInstance();
		System.out.println(si.getHost() + ":" + si.getPort());
		return "Hello World";
	}

}