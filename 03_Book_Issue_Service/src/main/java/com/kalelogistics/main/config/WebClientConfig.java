package com.kalelogistics.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class WebClientConfig {

	@Bean
	public WebClient webClient() {
		log.info("WebClient object created!");

		return WebClient.builder().build();
	}
}
