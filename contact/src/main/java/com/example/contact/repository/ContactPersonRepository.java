package com.example.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.contact.model.Person;

@Repository
public interface ContactPersonRepository extends JpaRepository<Person, Long> {

	

}