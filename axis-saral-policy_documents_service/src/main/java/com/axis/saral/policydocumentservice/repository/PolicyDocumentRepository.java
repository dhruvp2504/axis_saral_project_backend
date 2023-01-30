package com.axis.saral.policydocumentservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.axis.saral.policydocumentservice.entity.PolicyDocument;

@Repository
public interface PolicyDocumentRepository extends MongoRepository<PolicyDocument, String>{

}
