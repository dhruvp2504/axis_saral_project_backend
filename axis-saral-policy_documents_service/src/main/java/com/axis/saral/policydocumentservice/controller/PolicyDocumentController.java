	package com.axis.saral.policydocumentservice.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.axis.saral.policydocumentservice.entity.PolicyDocument;
import com.axis.saral.policydocumentservice.service.PolicyDocumentService;

@CrossOrigin("http://localhost:3000")
@RestController
public class PolicyDocumentController {

	@Autowired
	PolicyDocumentService policyDocumentService;
	
	@GetMapping("/policydocuments")
	public List<PolicyDocument> getAllPolicyDocuments(){
		return policyDocumentService.getAllPolicyDocuments();
	}
	
	@GetMapping("/policydocument/{documentId}")
	public PolicyDocument getPolicyDocumentById(@PathVariable String documentId) {
		return policyDocumentService.getPolicyDocumentsById(documentId);
	}
	
	@PostMapping("/policydocument")
	public ResponseEntity<String> addPolicyDocument(@RequestBody PolicyDocument policyDocument){
		policyDocumentService.addPolicyDocument(policyDocument);
		return new ResponseEntity<String>("New Policy Document Added", HttpStatus.OK);
	}
	
	@DeleteMapping("/policydocument/delete/{documentId}")
	public ResponseEntity<String> deletePolicyDocumentById(@PathVariable String documentId){
		policyDocumentService.deletePolicyDocumentById(documentId);
		return new ResponseEntity<String>("Property deleted successfully", HttpStatus.OK);
	}
	
	@PutMapping("/policydocument/update/{documentId}")
	public ResponseEntity<String> updatePolicyDocumentById(@PathVariable String documentId,@RequestBody PolicyDocument updatedPolicyDocument){
		if(documentId.equals(updatedPolicyDocument.getDocumentId())) {	
			policyDocumentService.updatePolicyDocumentById(documentId, updatedPolicyDocument);
			return new ResponseEntity<String>("Policy updated Successfully..!!", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Property with provided ID not found", HttpStatus.BAD_REQUEST);
		}
	}
}
