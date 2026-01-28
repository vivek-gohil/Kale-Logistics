package com.kalelogistics.main.service;

import org.springframework.stereotype.Service;

import com.kalelogistics.main.dto.BookDTO;
import com.kalelogistics.main.exception.BookAlreadyIssuedException;
import com.kalelogistics.main.exception.BookNotIssuableException;
import com.kalelogistics.main.repository.BookRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class BookService {
	private final BookRepository bookRepository;

	public boolean issueBook(String bookCode) {
		BookDTO bookDTO = getBook(bookCode);

		if (bookDTO.isIssuable() == false) {
			throw new BookNotIssuableException(bookCode);
		}
		boolean updated = false;

		if (bookDTO.isIssued() == false) {
			updated = bookRepository.markAsIssued(bookCode);
			log.info("Book {} issued successfully", bookCode);
			return true;
		}

		if (!updated) {
			throw new BookAlreadyIssuedException(bookCode);
		}

		return false;
	}

	public BookDTO getBook(String bookCode) {
		return bookRepository.findBookByBookCode(bookCode);
	}
}
