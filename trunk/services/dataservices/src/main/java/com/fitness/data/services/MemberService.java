package com.fitness.data.services;

import java.util.List;

import com.fitness.data.core.model.Member;

public interface MemberService {
	
	public List<Member> getMember(int member);
	public String createMember(Member member);
	public String updateMember(Member member);

}
