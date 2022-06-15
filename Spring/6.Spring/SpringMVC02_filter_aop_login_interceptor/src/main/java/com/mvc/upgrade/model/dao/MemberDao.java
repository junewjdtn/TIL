package com.mvc.upgrade.model.dao;

import com.mvc.upgrade.model.dto.MemberDto;

public interface MemberDao {
	// mapper를 사용하기 위한 NAMESPACE 선언
	String NAMESPACE = "mymember.";
	
	public MemberDto login(MemberDto dto);
	
}
