package com.kalelogistics.main.repository;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kalelogistics.main.dto.BookDTO;
import com.kalelogistics.main.exception.BookNotFoundException;
import com.kalelogistics.main.rowmapper.BookRowMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@AllArgsConstructor
public class BookRepository {
	private final JdbcTemplate jdbcTemplate;

	private static final String SELECT_BOOK_BY_BOOK_CODE = "SELECT * FROM books WHERE book_code=?";

	public BookDTO findBookByBookCode(String bookCode) {
		try {
			return jdbcTemplate.queryForObject(SELECT_BOOK_BY_BOOK_CODE, new BookRowMapper(), bookCode);
		} catch (EmptyResultDataAccessException e) {
			throw new BookNotFoundException(bookCode);
		}
	}
}
