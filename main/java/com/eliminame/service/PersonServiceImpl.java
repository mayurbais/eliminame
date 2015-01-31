package com.eliminame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliminame.entity.Person;
import com.eliminame.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonRepository personRepository;
	
	public Person findPerson(Long id){
		return personRepository.findOne(id);
		
	}
}
