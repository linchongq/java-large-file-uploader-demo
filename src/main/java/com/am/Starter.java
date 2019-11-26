package com.am;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableScheduling
@ServletComponentScan(basePackages = "com.am.jlfu")
@SpringBootApplication
public class Starter {

	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);
	}
}
