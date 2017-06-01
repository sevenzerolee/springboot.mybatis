package com.ctsi.springboot.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ctsi.springboot.mybatis.entity.Person;

@Mapper
public interface PersonMapper {
	
	@Select("select * from t_person where id = #{id}")  
    Person findById(long id); 

}
