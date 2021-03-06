package com.example.contact.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.contact.model.Organization;
import com.example.contact.model.Person;
import com.example.contact.repository.ContactPersonRepository;

@Service
public class ContactPersonService {

	@Autowired // dependency injection
	ContactPersonRepository perRepository;

	public Person add(Person per) {
		return perRepository.save(per);
	}

	public Optional<Person> info(Long id) {
		return perRepository.findById(id);
	}

	public void delete(Long id) {
		perRepository.deleteById(id);
	}

	public List<Person> list() {
		return perRepository.findAll();
		
	}

	public Person update(Long id, Person perDetails) {
		Person per = perRepository.findById(id).get();
		per.setName(perDetails.getName());
		per.setEmail(perDetails.getEmail());
		per.setPhoneNumber(perDetails.getPhoneNumber());

		return perRepository.save(per);
	}

	public Long count() {
		return perRepository.count();
	}

	public Person patch(Long id, String newName) {
		Person per = perRepository.findById(id).get();
		per.setName(newName);
		return perRepository.save(per);
	}
	public List<Person> searchByName(String searchName) {
		List<Person> pers = perRepository.findAll();
		if(pers != null) {
			return pers.stream().filter(per -> per.getName().toLowerCase().contains(searchName.toLowerCase())).toList();	
		}
		else
			return null;
	}

	// check phone number validation

	/*
	 * public void validPhoneNumber(String phoneNumber) { Long.valueOf(phoneNumber);
	 * if (phoneNumber.length()==10) {
	 * 
	 * } else { System.out.println("no number"); } }
	 * 
	 * }
	 */
}
