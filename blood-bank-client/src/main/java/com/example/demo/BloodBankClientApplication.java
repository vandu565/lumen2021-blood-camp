package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BloodBankClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodBankClientApplication.class, args);
	}
	
	@Bean
	public ModelAndView mdlView() {
		
		return new ModelAndView();
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Bean 
	public RestTemplateBuilder builder() {
		
		return new RestTemplateBuilder();
	}
	

}
