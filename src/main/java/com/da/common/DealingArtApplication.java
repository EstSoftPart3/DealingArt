package com.da.common;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.da"})
public class DealingArtApplication {

	public static void main(String[] args) {
		SpringApplication.run(DealingArtApplication.class, args);
	}
}
