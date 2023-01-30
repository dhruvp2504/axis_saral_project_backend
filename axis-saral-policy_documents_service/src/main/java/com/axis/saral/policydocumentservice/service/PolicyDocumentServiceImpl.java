package com.axis.saral.policydocumentservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.saral.policydocumentservice.entity.PolicyDocument;
import com.axis.saral.policydocumentservice.repository.PolicyDocumentRepository;

@Service
public class PolicyDocumentServiceImpl implements PolicyDocumentService{

	@Autowired
	PolicyDocumentRepository policyDocumentRepository;

	@Override
	public PolicyDocument getPolicyDocumentsById(String documentId) {
		// TODO Auto-generated method stub
		return policyDocumentRepository.findById(documentId).get();
	}

	@Override
	public List<PolicyDocument> getAllPolicyDocuments() {
		// TODO Auto-generated method stub
		return policyDocumentRepository.findAll();
	}

	@Override
	public void addPolicyDocument(PolicyDocument policyDocument) {
		// TODO Auto-generated method stub
		policyDocumentRepository.save(policyDocument);
	}

	@Override
	public void deletePolicyDocumentById(String documentId) {
		// TODO Auto-generated method stub
		policyDocumentRepository.deleteById(documentId);
		
	}

	@Override
	public void updatePolicyDocumentById(String documentId, PolicyDocument updatedPolicyDocument) {
		// TODO Auto-generated method stub
		policyDocumentRepository.save(updatedPolicyDocument);
	}
	
}
