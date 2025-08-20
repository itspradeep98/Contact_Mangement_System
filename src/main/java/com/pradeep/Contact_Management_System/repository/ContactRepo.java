package com.pradeep.Contact_Management_System.repository;

import com.pradeep.students_common.entities.ContactInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends MongoRepository<ContactInfo, String> {
}
