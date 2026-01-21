package com.kalelogistics.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kalelogistics.main.dto.LoginDTO;
import com.kalelogistics.main.service.LoginService;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("loginapi")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("login")
	public ResponseEntity<LoginDTO> validateUser(@Valid @RequestBody LoginDTO loginDTO) {
		return ResponseEntity.status(HttpStatus.OK).body(loginService.validateUser(loginDTO));
	}
}
