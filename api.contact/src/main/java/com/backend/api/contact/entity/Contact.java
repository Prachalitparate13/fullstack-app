package com.backend.api.contact.entity;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Table(name="CONTACTS")
public class Contact {

//	primary key
	@Id
	@UuidGenerator
	@Column(name="id",unique = true,updatable = false)
	private String id;
	private String name;
	private String email;
	private String title;
	private String phone;
	private String address;
	private String status;
	private String photoUrl;
	
	
	public Contact() {
	}


	public Contact(String id, String name, String email, String title, String phone, String address, String status,
			String photoUrl) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.title = title;
		this.phone = phone;
		this.address = address;
		this.status = status;
		this.photoUrl = photoUrl;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPhotoUrl() {
		return photoUrl;
	}


	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	
}
