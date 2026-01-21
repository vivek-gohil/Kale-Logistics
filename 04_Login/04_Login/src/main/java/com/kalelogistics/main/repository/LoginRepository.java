package com.kalelogistics.main.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.kalelogistics.main.domain.Login;
import com.kalelogistics.main.exception.ResourceNotFoundException;
import com.kalelogistics.main.rowmapper.LoginRowMapper;

@Component
public class LoginRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String VALIDATE_USER = "SELECT * FROM login_details WHERE login_id=? AND password=?";

	public Login validateUser(Login login) {
		try {
			Login validatedUser = jdbcTemplate.queryForObject(VALIDATE_USER, new LoginRowMapper(), login.getLoginId(),
					login.getPassword());
			return validatedUser;
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Login Details", "LoginId Or Password ",
					login.getLoginId() + " || " + login.getPassword());
		}

	}
}
