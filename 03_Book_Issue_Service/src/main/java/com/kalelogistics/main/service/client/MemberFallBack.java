package com.kalelogistics.main.service.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.kalelogistics.main.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MemberFallBack implements MembersFeignClient {
	@Override
	public ResponseEntity<MemberDTO> getMember(String memberCode) {
		log.info("In MemberFallBack :: MemberService failed");
		return null;
	}

}
