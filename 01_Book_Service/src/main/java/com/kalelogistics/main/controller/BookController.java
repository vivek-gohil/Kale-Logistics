package com.kalelogistics.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kalelogistics.main.dto.BookContactDetails;
import com.kalelogistics.main.dto.BookDTO;
import com.kalelogistics.main.dto.ResponseDTO;
import com.kalelogistics.main.service.BookService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("books")
@AllArgsConstructor
public class BookController {
	private BookService bookService;

	@Autowired
	private final BookContactDetails bookContactDetails;

	@GetMapping("/{bookCode}")
	public ResponseEntity<BookDTO> getBook(@PathVariable String bookCode) {
		log.info("Request received to fetch book {}", bookCode);

		BookDTO bookDTO = bookService.getBook(bookCode);

		return ResponseEntity.status(HttpStatus.OK).body(bookDTO);
	}

	@PostMapping("{bookCode}/issue")
	public ResponseEntity<ResponseDTO> issueBook(@PathVariable String bookCode) {
		log.info("Request received to issue book {} ", bookCode);

		bookService.issueBook(bookCode);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO("Book Issued Successfully", bookCode));

	}

	@GetMapping("contact-info")
	public ResponseEntity<BookContactDetails> getContactInfo() {
		log.info("Request received for getContactInfo");
		return ResponseEntity.status(HttpStatus.OK).body(bookContactDetails);
	}
}
