package com.ctsi.springboot.mybatis.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctsi.springboot.mybatis.entity.Person;
import com.ctsi.springboot.mybatis.mapper.PersonMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;

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
	
	@RequestMapping("/save")
	public void save() {
		Person p = new Person("Jane", 17, new Date());
		personMapper.save(p);
	}
	
	@RequestMapping("/getall/{num}")
	public String getAll(@PathVariable int num) {
		log.info("## " + num);
		int size = 2;
		PageHelper.startPage(num, size);
		List<Person> list = personMapper.findAll();
		PageInfo<Person> pageInfo = new PageInfo<Person>(list);
		log.info("## " + pageInfo);
		
		Gson gson = new Gson();
		String json = gson.toJson(pageInfo);
		log.info("## " + json);
		
		return json;
	}
	
}
