package com.kalelogistics.main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookIssueRequestDTO {
	private String memberCode;
	private String bookCode;
}
