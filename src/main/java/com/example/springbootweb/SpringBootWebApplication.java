package com.example.springbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@EnableAutoConfiguration(exclude = SwaggerConfig.class)//Exclude class from autoconfiguration
public class SpringBootWebApplication {//extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(WavefrontProperties.Application.class);
//	}

}
