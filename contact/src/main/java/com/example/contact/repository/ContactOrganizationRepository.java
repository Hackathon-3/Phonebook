package com.example.contact.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.contact.model.Organization;


	@Repository
	public interface ContactOrganizationRepository extends JpaRepository<Organization, Long> {

		@Query("select per.id,per.name from Organization per")
		
		public List<Organization> getList();

	}


