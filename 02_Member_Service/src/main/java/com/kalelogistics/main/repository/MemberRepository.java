package com.kalelogistics.main.repository;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kalelogistics.main.dto.MemberDTO;
import com.kalelogistics.main.exception.MemberNotFoundException;
import com.kalelogistics.main.rowmapper.MemberRowMapper;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class MemberRepository {
	private final JdbcTemplate jdbcTemplate;

	private static final String SELECT_MEMBER_BY_MEMBER_CODE = "SELECT member_code,member_name,member_type,active FROM members WHERE member_code=?";

	public MemberDTO findMemberByMemberCode(String memeberCode) {
		try {
			return jdbcTemplate.queryForObject(SELECT_MEMBER_BY_MEMBER_CODE, new MemberRowMapper(), memeberCode);
		} catch (EmptyResultDataAccessException e) {
			throw new MemberNotFoundException(memeberCode);
		}

	}
}
