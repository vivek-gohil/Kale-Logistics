package com.kalelogistics.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.kalelogistics.main.dto.MemberContactDetails;

@SpringBootApplication
@EnableConfigurationProperties(value = { MemberContactDetails.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
