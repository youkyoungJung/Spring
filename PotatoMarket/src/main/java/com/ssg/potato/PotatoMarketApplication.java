package com.ssg.potato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PotatoMarketApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PotatoMarketApplication.class);
	}
	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/s0102");
		SpringApplication.run(PotatoMarketApplication.class, args);
	}

}
