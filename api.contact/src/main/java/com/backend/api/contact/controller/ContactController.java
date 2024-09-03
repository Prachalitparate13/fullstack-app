package com.backend.api.contact.controller;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.backend.api.contact.Utils.ContactUtils;
import com.backend.api.contact.entity.Contact;
import com.backend.api.contact.service.ContactService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@PostMapping
	public ResponseEntity<Contact> createContact(@RequestBody Contact contact){
		
		return ResponseEntity.created(URI.create("/contacts/userId")).body(contactService.createContact(contact));
	}
	
	@GetMapping
	public ResponseEntity<Page<Contact>> getContact(@RequestParam(value="page",defaultValue = "0" )int page,
				@RequestParam(value="size",defaultValue = "10")int size){
		return ResponseEntity.ok().body(contactService.getAllContact(page, size));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Contact> getContact(@PathVariable(value="id")String id){
		return ResponseEntity.ok().body(contactService.contactById(id));
	}
	
	@PutMapping("/photo")
	public ResponseEntity<String> uploadPhoto(@RequestParam(value="id") String id,@RequestParam(value="file") MultipartFile file){
		return ResponseEntity.ok().body(contactService.uploadPhoto(id, file));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deletePhoto(@RequestParam(value="id") String id){
		return ResponseEntity.ok().body(contactService.deleteContact(id));
	}
	@GetMapping(path="/image/{filename}",produces= {MediaType.IMAGE_PNG_VALUE,MediaType.IMAGE_JPEG_VALUE})
	public byte[] getPhoto(@PathVariable(value="filename") String filename)throws IOException{
		return Files.readAllBytes(Paths.get(ContactUtils.PHOTO_DIRECTORY+filename));
	}
}
