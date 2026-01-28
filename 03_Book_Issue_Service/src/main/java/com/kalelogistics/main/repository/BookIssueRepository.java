package com.kalelogistics.main.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kalelogistics.main.domain.BookIssue;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Repository
public class BookIssueRepository {
	private final JdbcTemplate jdbcTemplate;

	private static final String INSERT_BOOK_ISSUE = "INSERT INTO book_issues(member_code,book_code,issue_date, due_date,status) VALUES(?,?,?,?,'ISSUED')";
	private static final String SELECT_BOOK_ISSUE_COUNT_BY_MEMBER = "SELECT COUNT(member_code) FROM book_issues WHERE member_code=? AND status= 'ISSUED'";

	public int countIssuedBooks(String memberCode) {
		log.info("countIssuedBooks " + memberCode);
		int count = jdbcTemplate.queryForObject(SELECT_BOOK_ISSUE_COUNT_BY_MEMBER, Integer.class, memberCode);
		log.info("Count = " + count);

		return count;
	}

	public boolean issueBook(BookIssue bookIssue) {
		return jdbcTemplate.update(INSERT_BOOK_ISSUE, bookIssue.getMemberCode(), bookIssue.getBookCode(),
				bookIssue.getIssueDate(), bookIssue.getDueDate()) == 1;
	}
}
