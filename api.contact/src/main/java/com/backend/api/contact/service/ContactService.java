package com.backend.api.contact.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.backend.api.contact.Utils.ContactUtils;
import com.backend.api.contact.entity.Contact;
import com.backend.api.contact.repo.ContactRepo;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
public class ContactService {

	@Autowired
	private  ContactRepo contactRepo;

	public Page<Contact> getAllContact(int page,int size){
		
		return contactRepo.findAll(PageRequest.of(page, size,Sort.by("name")));
	}
	
	public Contact contactById(String id) {
		return contactRepo.findById(id).orElseThrow(()->new RuntimeException("Contact not found"));
	}
	
	public Contact createContact(Contact contact) {
		return contactRepo.save(contact);
	}
	
	public String deleteContact(String id) {
		contactRepo.deleteById(id);
		return new String("Delete Successful");
	}
	
	public String uploadPhoto(String id, MultipartFile file) {
//		log.info("saving the data");
		Contact contact = contactById(id);
		String photoUrl=photoChanges.apply(id,file);
		
		contact.setPhotoUrl(photoUrl);
		contactRepo.save(contact);
		
		return photoUrl;
	}
	
	private final Function<String,String> FileExtenstion = filename -> Optional.of(filename)
			.filter(name->name.contains(".")).map(name->"."+ name.substring(filename.lastIndexOf(".")+1))
			.orElse(".png");
	
	
	private final BiFunction<String, MultipartFile, String> photoChanges = (id,image) -> {
		String fileName= id+  FileExtenstion.apply(image.getOriginalFilename());
	try {
		Path fileStorageLocation =Paths.get(ContactUtils.PHOTO_DIRECTORY ).toAbsolutePath().normalize();
		if(!Files.exists(fileStorageLocation)) {
			Files.createDirectories(fileStorageLocation);
		}
		
		Files.copy(image.getInputStream(), fileStorageLocation.resolve(fileName),StandardCopyOption.REPLACE_EXISTING);
		return ServletUriComponentsBuilder.fromCurrentContextPath().path("/contacts/image/"+  fileName).toUriString();		
	}
	catch (Exception e) {
		throw new RuntimeException("Unable to save image");
	}
	};
}
