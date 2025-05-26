package com.pradeep.Contact_Management_System.repository;

import com.pradeep.students_common.entities.contactInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface contactRepo extends MongoRepository<contactInfo, String> {
}
