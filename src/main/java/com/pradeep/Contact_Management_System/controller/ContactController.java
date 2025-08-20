package com.pradeep.Contact_Management_System.controller;

import com.pradeep.Contact_Management_System.dtos.ContactInfoDTO;
import com.pradeep.Contact_Management_System.service.ContactService;
import com.pradeep.students_common.common.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<ContactInfoDTO> createContact(@RequestBody ContactInfoDTO contactInfoDTO) {
        return ResponseEntity.ok(contactService.createContact(contactInfoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getContactById(@PathVariable String id) {
        return ResponseEntity.ok(new StudentResponse("Record fetch succesfully", HttpStatus.OK, contactService.getContactById(id)));
    }

    @GetMapping
    public ResponseEntity<StudentResponse> getAllContacts() {
        return ResponseEntity.ok(new StudentResponse("All records fetched successfully", HttpStatus.OK, contactService.getAllContacts()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactInfoDTO> updateContact(@PathVariable String id, @RequestBody ContactInfoDTO contactInfoDTO) {
        return ResponseEntity.ok(contactService.updateContact(id, contactInfoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentResponse> deleteContact(@PathVariable String id) {
        contactService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }
}