package com.pradeep.Contact_Management_System.service.impl;

import com.pradeep.Contact_Management_System.dtos.ContactInfoDTO;
import com.pradeep.Contact_Management_System.repository.ContactRepo;
import com.pradeep.Contact_Management_System.service.ContactService;
import com.pradeep.students_common.common.StudentResponse;
import com.pradeep.students_common.entities.ContactInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepo contactRepo;

    @Override
    public ContactInfoDTO createContact(ContactInfoDTO contactInfoDTO) {
        ContactInfo contact = mapToEntity(contactInfoDTO);
        contact = contactRepo.save(contact);
        return mapToDTO(contact);
    }

    @Override
    public ContactInfoDTO getContactById(String id) {
        ContactInfo contact = contactRepo.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
        return mapToDTO(contact);
    }

    @Override
    public List<ContactInfoDTO> getAllContacts() {
        return contactRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ContactInfoDTO updateContact(String id, ContactInfoDTO contactInfoDTO) {
        ContactInfo contact = contactRepo.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
        contact.setFirst_Name(contactInfoDTO.getFirstName());
        contact.setMiddle_Name(contactInfoDTO.getMiddleName());
        contact.setLast_Name(contactInfoDTO.getLastName());
        contact.setContact_Numbers(contactInfoDTO.getContactNumbers());
        contact.setEmail(contactInfoDTO.getEmail());
        contact.setFeild(contactInfoDTO.getField());
        contact = contactRepo.save(contact);
        return mapToDTO(contact);
    }

    @Override
    public ResponseEntity<StudentResponse> deleteContact(String id) {
        try{
            ContactInfo contactInfo = contactRepo.findById(id).orElse(null);
            if(contactRepo.findById(id) == null) {
                throw new RuntimeException("Contact not found");
            }
            contactRepo.deleteById(id);
            return ResponseEntity.ok(new StudentResponse("Contact deleted successfully", HttpStatus.OK, contactInfo));
        }catch (RuntimeException e) {
            return ResponseEntity.ok(new StudentResponse(e.getMessage(), HttpStatus.NOT_FOUND, null));
        }catch (Exception e){
            return ResponseEntity.ok(new StudentResponse("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR, null));
        }

    }

    private ContactInfo mapToEntity(ContactInfoDTO contactInfoDTO) {
        return new ContactInfo(
                contactInfoDTO.getId(),
                null, // Assuming `students` is handled elsewhere
                contactInfoDTO.getFirstName(),
                contactInfoDTO.getMiddleName(),
                contactInfoDTO.getLastName(),
                contactInfoDTO.getContactNumbers(),
                contactInfoDTO.getEmail(),
                contactInfoDTO.getField()
        );
    }

    private ContactInfoDTO mapToDTO(ContactInfo contact) {
        return new ContactInfoDTO(
                contact.getId(),
                contact.getFirst_Name(),
                contact.getMiddle_Name(),
                contact.getLast_Name(),
                contact.getContact_Numbers(),
                contact.getEmail(),
                contact.getFeild()
        );
    }
}