package com.fitness.data.services.dao;

import java.util.List;

import com.fitness.data.core.model.Member;

public interface MemberDAO {
	
	public List<Member> getMember(int memberId);
	public String createMember(Member member);
	public String updateMember(Member member);

}
