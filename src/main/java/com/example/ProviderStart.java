package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * 生产者项目启动类
 * @author tom
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderStart {

	public static void main(String[] args) {
		SpringApplication.run(ProviderStart.class, args);
	}

}
