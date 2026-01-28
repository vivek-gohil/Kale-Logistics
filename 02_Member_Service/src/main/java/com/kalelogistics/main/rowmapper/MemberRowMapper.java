package com.kalelogistics.main.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kalelogistics.main.dto.MemberDTO;

public class MemberRowMapper implements RowMapper<MemberDTO> {

	@Override
	public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

		String memberCode = rs.getString("member_code");
		String memberName = rs.getString("member_name");
		String memberType = rs.getString("member_type");
		boolean active = rs.getInt("active") == 1;

		MemberDTO memberDTO = new MemberDTO(memberCode, memberName, memberType, active);
		return memberDTO;
	}

}
