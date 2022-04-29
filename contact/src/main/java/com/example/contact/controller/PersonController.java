package com.example.contact.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.contact.model.Person;
import com.example.contact.service.ContactPersonService;

@RestController
@RequestMapping("/api")
public class PersonController {
	@Autowired
	ContactPersonService perService;

	//error output when using different ids and gives same result 
	@GetMapping(value = "/person/info/{id}")
	public Optional<Person> info(@PathVariable(value = "id") Long id) {
		return perService.info(id);
	}
//doen't give output
	@GetMapping(value = "/person/list")
	public List<Person> list() {
		return perService.list();
	}

	@PostMapping("/person/add")
	public Person add(@RequestBody Person per) {
		return perService.add(per);
	}

	@PutMapping("/person/update/{id}")
	public Person update(@PathVariable("id") Long id, @RequestBody Person perDetails) {
		return perService.update(id, perDetails);
	}

	@PatchMapping("/person/patch/{id}/{newname}")
	public Person patch(@PathVariable(value = "id") Long id, @PathVariable(value = "newname") String newName) {
		return perService.patch(id, newName);
	}

	@DeleteMapping("/person/delete/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		perService.delete(id);
	}

}