package com.example.contactmanager.service;

import com.example.contactmanager.exceptions.UserNotFoundException;
import com.example.contactmanager.model.Contact;
import com.example.contactmanager.repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class ContactService {
    private final ContactRepo contactRepo;

@Autowired
    public ContactService(ContactRepo contactRepo){
        this.contactRepo = contactRepo;
    }

    public Contact addContact(Contact contact){
        contact.setCode(UUID.randomUUID().toString());
        return contactRepo.save(contact);
    }

    public List <Contact> findAllContacts(){
        return contactRepo.findAll();
    }

    public Contact updateContact(Contact contact){
        return contactRepo.save(contact);
    }

    public Contact findContactById(Long id){
        return contactRepo.findContactById(id)
                .orElseThrow(()-> new UserNotFoundException("User was by id"+ id +"was not found"));
    }

    public void deleteContact(Long id){
        contactRepo.deleteById(id);
    }

}
