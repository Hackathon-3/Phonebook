package com.example.contact.model;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.AttributeConverter;
import javax.persistence.Column;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Converter(autoApply = true)
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Contact implements AttributeConverter<LocalDate, Date> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	protected Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	public Contact() {
		super();
		this.createdAt = LocalDateTime.now();
	}

	public Contact(Long id, String name, String phoneNumber, String email, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.createdAt = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public Date convertToDatabaseColumn(LocalDate locDate) {
		return locDate == null ? null : Date.valueOf(locDate);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date sqlDate) {
		return sqlDate == null ? null : sqlDate.toLocalDate();
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", createdAt=" + createdAt + "]";
	}

}