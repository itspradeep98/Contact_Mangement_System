package com.pradeep.Contact_Management_System.dtos;

import java.util.List;

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
}