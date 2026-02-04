package com.kalelogistics.main.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kalelogistics.main.dto.BookDTO;

@FeignClient(name = "book", fallback = BookFallBack.class)
public interface BooksFeignClient {
	@GetMapping("books/{bookCode}")
	public ResponseEntity<BookDTO> getBook(@PathVariable String bookCode);
}
