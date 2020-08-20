package com.sv.restapi.lab1.controller;

import com.sv.restapi.lab1.entity.Contact;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
     @ApiOperation(value="Finds Contacts by id",
             notes=" Provide an id to look up specific contact from the address book",
             response = Contact.class)
     public Contact getContact(@ApiParam(value="ID value for the contact you need to retrieve",required = true) @PathVariable String id){
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

    @DeleteMapping("/{id}")
    void deleteContact(@PathVariable String id) {
         contacts.remove(id);
    }

    @PutMapping("/{id}")
    Contact updateContact(@RequestBody Contact newcontact,@PathVariable String id) {
         contacts.put(id,newcontact);
         return newcontact;
    }
}
