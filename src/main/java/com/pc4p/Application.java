package com.pc4p;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	static final String WEB_SITE_URL = "http://localhost:63343";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
