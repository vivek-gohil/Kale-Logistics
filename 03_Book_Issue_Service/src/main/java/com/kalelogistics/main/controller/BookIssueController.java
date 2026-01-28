package com.kalelogistics.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kalelogistics.main.dto.BookIssueRequestDTO;
import com.kalelogistics.main.dto.BookIssueResponseDTO;
import com.kalelogistics.main.service.BookIssueService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("issues")
@AllArgsConstructor
public class BookIssueController {
	private final BookIssueService bookIssueService;

	@PostMapping
	public ResponseEntity<BookIssueResponseDTO> issueBook(@RequestBody BookIssueRequestDTO bookIssueRequestDTO) {
		return ResponseEntity.status(HttpStatus.OK).body(bookIssueService.issueBook(bookIssueRequestDTO));
	}
}
