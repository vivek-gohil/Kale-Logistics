package com.kalelogistics.main.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {
	private String bookCode;
	private String title;
	private String author;
	private boolean issuable;
	private boolean issued;
}
