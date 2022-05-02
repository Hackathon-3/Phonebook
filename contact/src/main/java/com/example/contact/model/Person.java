package com.example.contact.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person extends Contact {

	public Person(Long id, String name, String phoneNumber, String email, LocalDateTime createdAt) {
		super(id, name, phoneNumber, email, createdAt);

	}

	public Person() {
		super();

	}

}
