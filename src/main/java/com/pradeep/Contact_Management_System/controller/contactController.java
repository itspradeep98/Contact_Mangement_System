package com.pradeep.Contact_Management_System.controller;

import com.pradeep.Contact_Management_System.dtos.ContactInfoDTO;
import com.pradeep.Contact_Management_System.service.contactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contacts")
public class contactController {

    @Autowired
    private contactService contactService;

    @PostMapping
    public ResponseEntity<ContactInfoDTO> createContact(@RequestBody ContactInfoDTO contactInfoDTO) {
        return ResponseEntity.ok(contactService.createContact(contactInfoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactInfoDTO> getContactById(@PathVariable String id) {
        return ResponseEntity.ok(contactService.getContactById(id));
    }

    @GetMapping
    public ResponseEntity<List<ContactInfoDTO>> getAllContacts() {
        return ResponseEntity.ok(contactService.getAllContacts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactInfoDTO> updateContact(@PathVariable String id, @RequestBody ContactInfoDTO contactInfoDTO) {
        return ResponseEntity.ok(contactService.updateContact(id, contactInfoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable String id) {
        contactService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }
}