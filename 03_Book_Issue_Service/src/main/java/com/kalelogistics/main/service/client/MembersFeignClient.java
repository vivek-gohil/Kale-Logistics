package com.kalelogistics.main.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kalelogistics.main.dto.MemberDTO;

@FeignClient(name = "member", fallback = MemberFallBack.class)
public interface MembersFeignClient {
	@GetMapping("members/{memberCode}")
	public ResponseEntity<MemberDTO> getMember(@PathVariable String memberCode);
}
