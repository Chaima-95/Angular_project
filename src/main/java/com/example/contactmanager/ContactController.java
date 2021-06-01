package com.example.contactmanager;

import com.example.contactmanager.model.Contact;
import com.example.contactmanager.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }
    /* a list of employees*/
    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getAllContacts(){
        List <Contact> contacts = contactService.findAllContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }
    /* find a user*/
    @GetMapping("/find/{id}")
    public ResponseEntity <Contact> getContactById(@PathVariable("id") Long id){
        Contact contact = contactService.findContactById(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    /* find a user*/
    @PostMapping("/add")
    public ResponseEntity <Contact> addContact(@RequestBody Contact contact){
        Contact newcontact = contactService.addContact(contact);
        return new ResponseEntity<>(newcontact, HttpStatus.CREATED);
    }
    /*update*/
    @PutMapping("/update")
    public ResponseEntity <Contact> updateContact(@RequestBody Contact contact){
        Contact updatecontact = contactService.updateContact(contact);
        return new ResponseEntity<>(updatecontact, HttpStatus.CREATED);
    }

    /*delete*/
    @DeleteMapping("/delete/{id}")
    public ResponseEntity <?> updateContact(@PathVariable("id") Long id){
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
