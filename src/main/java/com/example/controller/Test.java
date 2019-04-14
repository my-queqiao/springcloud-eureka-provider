package com.example.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	@RequestMapping("test/{variable}")
	@ResponseBody
	public Map<String, String> test(@PathVariable("variable")String a,String b,HttpServletRequest request,Map<String,String> map2) {
		Map<String,String> map = new HashMap<>();
		map.put("naive", "yes");
		map.put("naive2", a);
		map.put("naive3", b);
		String value = request.getParameter("p");
		String str = (String)request.getAttribute("p");
		map.put("p", value);
		map.put("str", str);
		map.put("map2", map2.get("p"));
		System.out.println("map2:"+map2);
		return map;
	}
	@RequestMapping("test2")
	@ResponseBody
	public Map<String, String> test2() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-provider");
		URI uri = serviceInstance.getUri();
		System.out.println("测试负载均衡uri:"+uri);
		
		Map<String,String> map = new HashMap<>();
		map.put("naive", "yes");
		map.put("测试负载均衡uri", uri.toString());
		return map;
	}
}
