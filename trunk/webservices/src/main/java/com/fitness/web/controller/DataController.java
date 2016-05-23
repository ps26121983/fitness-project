package com.fitness.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.data.core.model.Member;
import com.fitness.data.services.MemberService;
import com.fitness.data.services.impl.MemberServiceImpl;

@RestController
public class DataController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/api/members", method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<Member> getDataInJson(){
		
		return memberService.getMember(2);
	}
	
	@RequestMapping(value="/api/data.xml", method=RequestMethod.GET,produces="application/xml")
	@ResponseBody
	public List<Member> getDataInXml(){		
		
		return memberService.getMember(10001);
	}
		
	@RequestMapping(value="/api/members/new", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	@ResponseBody
	public ResponseEntity<Member> createMember(@RequestBody Member member){
		
		if (member!=null)
		{			
			System.out.println(memberService.createMember(member));
		}
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/members/update", method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public ResponseEntity<Member> updateMember(@RequestBody Member member){
		
		if (member!=null){
			memberService.updateMember(member);
		}
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	
}
