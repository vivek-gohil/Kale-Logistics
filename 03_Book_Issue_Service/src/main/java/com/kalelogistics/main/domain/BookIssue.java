package com.kalelogistics.main.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookIssue {
	private String issueId;
	private String memberCode;
	private String bookCode;
	private LocalDate issueDate;
	private LocalDate dueDate;
	private LocalDate returnDate;
}
