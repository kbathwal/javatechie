package com.javatechie.springboot.springboothibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.springboot.springboothibernate.dao.PersonDao;
import com.javatechie.springboot.springboothibernate.model.Person;

@RestController
//@RequestMapping("/spring-boot-orm")
public class PersonController {
	
	@Autowired
	private PersonDao personDao;
	
	@PostMapping("/savePerson")
	public String save(@RequestBody Person person) {
		personDao.savePerson(person);
		return("SUCCESS");
		
	}
	
	@GetMapping("/getMapping")
	public List<Person>getAllPerson(){
		return personDao.getPerson();
		
	}

}
