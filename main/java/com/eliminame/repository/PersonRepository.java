package com.eliminame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eliminame.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	Person findById(Long Id);
}
