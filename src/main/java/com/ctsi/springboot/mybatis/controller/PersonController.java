package com.ctsi.springboot.mybatis.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctsi.springboot.mybatis.entity.Person;
import com.ctsi.springboot.mybatis.mapper.PersonMapper;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	private static final Logger log = Logger.getLogger(PersonController.class);
	
	@Autowired
	private PersonMapper personMapper;
	
	@RequestMapping("/get")
	public String getOne() {
		Person p = personMapper.findById(2);
		log.info("## " + p.toString());
		
		return p.toString();
	}
	
	@RequestMapping("/getone/{id}")
	public String getOne(@PathVariable long id) {
		log.info("## " + id);
		Person p = personMapper.findById(id);
		
		return p.toString();
	}
	
}
