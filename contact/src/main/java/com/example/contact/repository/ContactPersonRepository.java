package com.example.contact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.contact.model.Person;

@Repository
public interface ContactPersonRepository extends JpaRepository<Person, Long> {

@Query("select per.id,per.name from Person per")

public List<Person> getList();


}