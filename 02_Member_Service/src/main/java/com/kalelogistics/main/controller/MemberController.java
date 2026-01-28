package com.kalelogistics.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kalelogistics.main.dto.MemberDTO;
import com.kalelogistics.main.service.MemberService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("members")
@AllArgsConstructor
public class MemberController {
	private final MemberService memberService;

	@GetMapping("{memberCode}")
	public ResponseEntity<MemberDTO> getMember(@PathVariable String memberCode) {
		return ResponseEntity.status(HttpStatus.OK).body(memberService.getMember(memberCode));
	}
}
