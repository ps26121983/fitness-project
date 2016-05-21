package com.fitness.data.services.impl;

import com.fitness.data.core.model.Member;
import com.fitness.data.services.MemberService;

public class MemberServiceImpl implements MemberService{

	public Member getMember(String memberId) {
		final Member member = new Member();
		
		member.setId(memberId);
		member.setName("PrjectMember");
		return member;
	}

}
