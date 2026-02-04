package com.kalelogistics.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.kalelogistics.main.dto.IssueContactDetails;

@SpringBootApplication
@EnableConfigurationProperties(value = { IssueContactDetails.class })
@EnableFeignClients
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
