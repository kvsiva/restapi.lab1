package com.sv.restapi.lab1;

import com.sv.entity.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping(path = "/ab")
public class AddressBookController {
    ConcurrentMap<String, Contact> contacts=new ConcurrentHashMap<>();

     @GetMapping("/{id}")
     public Contact getContact(@PathVariable String id){
         return contacts.get(id);
     }

     @GetMapping("/")
     public List<Contact> getAllContacts(){
         return new ArrayList<>(contacts.values());
     }

     @GetMapping(path="/greeting", produces = "text/html")

    public String greeting(){
        return "Hi Welcome to Java REST API";
    }

    @PostMapping("/")
     public Contact addContact(@RequestBody Contact contact){
         contacts.put(contact.getId(),contact);
         return contact;

     }
}