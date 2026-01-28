package com.kalelogistics.main.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookIssueResponseDTO {
	private String message;
	private String memberCode;
	private String bookCode;
	private LocalDate dueDate;
}
