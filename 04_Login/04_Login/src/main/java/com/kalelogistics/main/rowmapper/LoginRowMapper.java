package com.kalelogistics.main.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kalelogistics.main.domain.Login;

public class LoginRowMapper implements RowMapper<Login> {

	@Override
	public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
		String loginId = rs.getString("login_id");
		String password = rs.getString("password");

		Login login = new Login(loginId, password);
		return login;
	}

}
