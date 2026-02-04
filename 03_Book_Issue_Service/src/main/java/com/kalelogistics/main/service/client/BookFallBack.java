package com.kalelogistics.main.service.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.kalelogistics.main.dto.BookDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BookFallBack implements BooksFeignClient {

	@Override
	public ResponseEntity<BookDTO> getBook(String bookCode) {
		log.info("In BookFallBack :: BookService failed");
		return null;
	}

}
