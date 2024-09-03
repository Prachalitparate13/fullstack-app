package com.backend.api.contact.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.api.contact.entity.Contact;

@Repository
public interface ContactRepo extends JpaRepository<Contact,String> {

	Optional<Contact> findById(String id);
	void deleteById(String id);
//	List<Contact> findAll();
}
