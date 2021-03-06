package com.da.common;

import javax.servlet.http.HttpSessionListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;


@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = {"com.da"})
public class DealingArtApplication extends SpringBootServletInitializer{
	
	static {
        System.setProperty("com.amazonaws.sdk.disableEc2Metadata", "true");
    }
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DealingArtApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(DealingArtApplication.class, args);
	}
	
	@Bean
    MappingJackson2JsonView jsonView(){
        return new MappingJackson2JsonView();
    }
	
	@Bean
	public RestTemplate getRestTemplate(){
	    return new RestTemplate();
	}
	
	@Bean
	public HttpSessionListener httpSessionListener(){

		return new SessionListener();

	}
}
