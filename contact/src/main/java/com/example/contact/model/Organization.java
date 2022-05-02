package com.example.contact.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "Organization")
public class Organization extends Contact{

	@Column(name = "Website")
	private String website;

	public Organization(Long id, String name, String phoneNumber, String email, LocalDateTime createdAt,
			String website) {
		super(id, name, phoneNumber, email, createdAt);
		this.website = website;
	}

	
	public Organization() {
		super();
	
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	


}
