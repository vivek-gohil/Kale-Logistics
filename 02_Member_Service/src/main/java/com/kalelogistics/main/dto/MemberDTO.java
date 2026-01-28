package com.kalelogistics.main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberDTO {
	private String memberCode;
	private String memberName;
	private String memberType;
	private boolean active;
}
