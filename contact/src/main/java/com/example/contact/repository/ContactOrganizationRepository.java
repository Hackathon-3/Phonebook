package com.example.contact.repository;


	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

import com.example.contact.model.Organization;

	@Repository
	public interface ContactOrganizationRepository extends JpaRepository<Organization, Long> {

	}


