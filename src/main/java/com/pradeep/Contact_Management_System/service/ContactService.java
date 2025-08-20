package com.pradeep.Contact_Management_System.service;

import com.pradeep.Contact_Management_System.dtos.ContactInfoDTO;
import com.pradeep.students_common.common.StudentResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContactService {

    ContactInfoDTO createContact(ContactInfoDTO contactInfoDTO);
    ContactInfoDTO getContactById(String id);
    List<ContactInfoDTO> getAllContacts();
    ContactInfoDTO updateContact(String id, ContactInfoDTO contactInfoDTO);
    ResponseEntity<StudentResponse> deleteContact(String id);

}
