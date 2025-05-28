package com.pradeep.Contact_Management_System.service.impl;

import com.pradeep.Contact_Management_System.dtos.ContactInfoDTO;
import com.pradeep.Contact_Management_System.repository.contactRepo;
import com.pradeep.Contact_Management_System.service.contactService;
import com.pradeep.students_common.entities.contactInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class contactServiceImpl implements contactService {

    @Autowired
    private contactRepo contactRepo;

    @Override
    public ContactInfoDTO createContact(ContactInfoDTO contactInfoDTO) {
        contactInfo contact = mapToEntity(contactInfoDTO);
        contact = contactRepo.save(contact);
        return mapToDTO(contact);
    }

    @Override
    public ContactInfoDTO getContactById(String id) {
        contactInfo contact = contactRepo.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
        return mapToDTO(contact);
    }

    @Override
    public List<ContactInfoDTO> getAllContacts() {
        return contactRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ContactInfoDTO updateContact(String id, ContactInfoDTO contactInfoDTO) {
        contactInfo contact = contactRepo.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
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
    public void deleteContact(String id) {
        contactRepo.deleteById(id);
    }

    private contactInfo mapToEntity(ContactInfoDTO contactInfoDTO) {
        return new contactInfo(
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

    private ContactInfoDTO mapToDTO(contactInfo contact) {
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