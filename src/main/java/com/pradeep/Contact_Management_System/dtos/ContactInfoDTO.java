package com.pradeep.Contact_Management_System.dtos;

import java.util.List;

import com.pradeep.students_common.entities.contactInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactInfoDTO {
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private List<String> contactNumbers;
    private String email;
    private String field;


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