package com.tutrit.qs.webtgbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
@EnableFeignClients
public class Application {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(Application.class, args);
	}

}
