package com.example.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.example.contact.model.Person;

import com.example.contact.repository.ContactPersonRepository;


@Service
public class ContactPersonService {

	@Autowired//dependency injection
	//ContactOrganizationRepository orgRepository;
	ContactPersonRepository perRepository;
	
	//add person
public Person add(Person per) {
		return perRepository.save(per);
	
	}
//List person
public List<Person> list(Person per){
	per.getId();
	per.getName();
	return perRepository.findAll();
	}
//info person
public List<Person> info(Long id) {
	return perRepository.findAll();
}
//delete person
public void delete(Long id) {
	perRepository.deleteById(id);
}

//update person

public Person updateContact(Long id, Person perDetails) {
    Person per = perRepository.findById(id).get();
    per.setName(perDetails.getName());
    per.setEmail(perDetails.getEmail());
    per.setPhoneNumber(perDetails.getPhoneNumber());
      
    return perRepository.save(per);     
    }



//check phone number validation

/*public void validPhoneNumber(String phoneNumber) {
		Long.valueOf(phoneNumber);
		if (phoneNumber.length()==10) {
						
			}
		else {
			System.out.println("no number");
		}
			}
		
}*/
}

