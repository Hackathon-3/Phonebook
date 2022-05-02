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

import com.example.contact.model.Organization;
import com.example.contact.service.ContactOrganizationService;


@RestController
@RequestMapping("/api")
public class OrgController {
	@Autowired
	ContactOrganizationService orgService;

	@GetMapping("/org/info/{id}")
	public Optional<Organization> info(@PathVariable(value = "id") Long id) {
		return orgService.info(id);
	}

	@GetMapping(value = "/org/list")
	public List<Organization> list() {
		return orgService.list();
	}

	@PostMapping("/org/add")
	public Organization add(@RequestBody Organization org) {
		return orgService.add(org);
	}

	@PutMapping("/org/update/{id}")
	public Organization update(@PathVariable("id") Long id, @RequestBody Organization orgDetails) {
		return orgService.update(id, orgDetails);
	}

	@PatchMapping("/org/patch/{id}/{newname}")
	public Organization patch(@PathVariable(value = "id") Long id, @PathVariable(value = "newname") String newName) {
		return orgService.patch(id, newName);
	}

	@DeleteMapping("/org/delete/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		orgService.delete(id);
	}
	@GetMapping("/org/count")
	public Long count() {
	return orgService.count();	
	}
	@GetMapping("/org/search/{searchname}")
	public List<Organization> search(@PathVariable(value = "searchname") String searchName) {
		return orgService.searchByName(searchName);
	}
}
