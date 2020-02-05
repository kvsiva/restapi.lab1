package com.sv.controller;

import com.sv.entity.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
public class AddressBookController {
    ConcurrentMap<String, Contact> contacts=new ConcurrentHashMap<>();

     @GetMapping("/{id}")
     public Contact getContact(@PathVariable String id){
         return contacts.get(id);
     }

     @GetMapping("/")
     public List<Contact> getAllContacts(){
         return new ArrayList<Contact>(contacts.values());
     }

    @GetMapping("/hello")
    public String getStatus(){
        return "Hi Welcome to Java REST API";
    }

    @PostMapping("/")
     public Contact addContact(@RequestBody Contact contact){
         contacts.put(contact.getId(),contact);
         return contact;

     }
}
