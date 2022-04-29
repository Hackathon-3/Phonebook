package com.example.contact.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.contact.model.Organization;
import com.example.contact.repository.ContactOrganizationRepository;

@Service
public class ContactOrganizationService {

	@Autowired // dependency injection
	ContactOrganizationRepository orgRepository;

	public Organization add(Organization org) {
		return orgRepository.save(org);
	}

	public List<Organization> info(Long organizationId) {
		return orgRepository.findAll();
	}

	public void delete(Long id) {
		orgRepository.deleteById(id);
	}

	public List<Organization> list(Organization org) {
		org.getId();
		org.getName();
		return orgRepository.findAll();
	}

	public Organization update(Long Id, Organization orgDetails) {
		Organization org = orgRepository.findById(Id).get();
		org.setName(orgDetails.getName());
		org.setWebsite(orgDetails.getWebsite());
		org.setPhoneNumber(orgDetails.getPhoneNumber());

		return orgRepository.save(org);
	}

	public Long count() {
		return orgRepository.count();
	}

	public Organization patch(Long id, String newName) {
		Organization org = orgRepository.findById(id).get();
		org.setName(newName);
		return orgRepository.save(org);
	}
}
