package com.kalelogistics.main.service;

import org.springframework.stereotype.Service;

import com.kalelogistics.main.dto.BookDTO;
import com.kalelogistics.main.repository.BookRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class BookService {
	private final BookRepository bookRepository;

	public BookDTO getBook(String bookCode) {
		return bookRepository.findBookByBookCode(bookCode);
	}
}
