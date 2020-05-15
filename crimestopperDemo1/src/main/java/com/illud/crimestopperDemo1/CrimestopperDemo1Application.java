package com.illud.crimestopperDemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.netflix.feign.EnableFeignClients;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2
@RefreshScope
public class CrimestopperDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(CrimestopperDemo1Application.class, args);
	}
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
		
	}
}
