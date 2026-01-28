package com.kalelogistics.main.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kalelogistics.main.dto.BookDTO;

public class BookRowMapper implements RowMapper<BookDTO> {
	@Override
	public BookDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

		String bookCode = rs.getString("book_code");
		String title = rs.getString("title");
		String author = rs.getString("author");
		boolean issuable = rs.getInt("issuable") == 1;
		boolean issued = rs.getInt("issued") == 1;

		BookDTO bookDTO = new BookDTO(bookCode, title, author, issuable, issued);
		return bookDTO;
	}
}
