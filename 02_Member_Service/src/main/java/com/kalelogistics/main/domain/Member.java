package com.kalelogistics.main.domain;

import lombok.Data;

@Data
public class Member {
	private String memberCode;
	private String memberName;
	private String memberType;
	private boolean active;
}
