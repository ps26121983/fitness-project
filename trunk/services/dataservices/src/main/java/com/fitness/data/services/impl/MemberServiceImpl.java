package com.fitness.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fitness.data.core.model.Member;
import com.fitness.data.services.MemberService;
import com.fitness.data.services.dao.MemberDAO;

public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDao;
		
	public List<Member> getMember(int memberId) {		
			
		return memberDao.getMember(memberId);				
	}
	
	public String createMember(Member member) {
		
		memberDao.createMember(member);
		return "";
	}

	public String updateMember(Member member) {
		
		memberDao.updateMember(member);
		return null;
	}
}
