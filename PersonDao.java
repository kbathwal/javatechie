package com.javatechie.springboot.springboothibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javatechie.springboot.springboothibernate.model.Person;

@Repository
@Transactional
public class PersonDao {
	
	@Autowired
	private SessionFactory factory;
	
	public void savePerson(Person person) {
		getSession().save(person);
		
	}
	
	//List of saved records
	@SuppressWarnings("unchecked")
	public List<Person> getPerson(){
		return getSession().createCriteria(Person.class).list();
		

	}
	
	private Session getSession() { 
		Session session=factory.getCurrentSession();
				if(session==null) {
					session=factory.openSession();
				}
		return session;
	}

}
