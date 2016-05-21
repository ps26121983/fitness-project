package com.fitness.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="/api/data.json", method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public Member getDataInJson(){		
		
		return memberService.getMember("10001");
	}
	
	@RequestMapping(value="/api/data.xml", method=RequestMethod.GET,produces="application/xml")
	@ResponseBody
	public Member getDataInXml(){		
		
		return memberService.getMember("10001");
	}

}
