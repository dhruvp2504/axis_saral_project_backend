package com.axis.saral.policydocumentservice.service;

import java.util.List;

import com.axis.saral.policydocumentservice.entity.PolicyDocument;

public interface PolicyDocumentService {
	PolicyDocument getPolicyDocumentsById(String documentId);
	
	List<PolicyDocument> getAllPolicyDocuments();
	
	void addPolicyDocument(PolicyDocument policyDocument);
	
	void deletePolicyDocumentById(String documentId);
	
	void updatePolicyDocumentById(String documentId, PolicyDocument updatedPolicyDocument);
	
}
