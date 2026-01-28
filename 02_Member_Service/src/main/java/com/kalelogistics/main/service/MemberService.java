package com.kalelogistics.main.service;

import org.springframework.stereotype.Service;

import com.kalelogistics.main.dto.MemberDTO;
import com.kalelogistics.main.exception.MemberInactiveException;
import com.kalelogistics.main.repository.MemberRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class MemberService {
	public final MemberRepository memberRepository;

	public MemberDTO getMember(String memberCode) {
		MemberDTO memberDTO = memberRepository.findMemberByMemberCode(memberCode);

		if (memberDTO.isActive() == false) {
			throw new MemberInactiveException(memberCode);
		}

		return memberDTO;
	}
}
