package com.pradeep.Contact_Management_System.service;

import com.pradeep.Contact_Management_System.dtos.ContactInfoDTO;
import java.util.List;

public interface contactService {

    ContactInfoDTO createContact(ContactInfoDTO contactInfoDTO);
    ContactInfoDTO getContactById(String id);
    List<ContactInfoDTO> getAllContacts();
    ContactInfoDTO updateContact(String id, ContactInfoDTO contactInfoDTO);
    void deleteContact(String id);

}
