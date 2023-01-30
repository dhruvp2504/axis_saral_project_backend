	package com.axis.saral.policydocumentservice.entity;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PolicyDocument {
	@Id
	private String documentId;
	private String documentTitle;
	private String documentUrl;
	
	public PolicyDocument() {
		
	}

	public PolicyDocument(String documentId, String documentTitle, String documentUrl) {
		super();
		this.documentId = documentId;
		this.documentTitle = documentTitle;
		this.documentUrl = documentUrl;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getDocumentTitle() {
		return documentTitle;
	}

	public void setDocumentTitle(String documentTitle) {
		this.documentTitle = documentTitle;
	}

	public String getDocumentUrl() {
		return documentUrl;
	}

	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}

	@Override
	public int hashCode() {
		return Objects.hash(documentId, documentTitle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PolicyDocument other = (PolicyDocument) obj;
		return Objects.equals(documentId, other.documentId) && Objects.equals(documentTitle, other.documentTitle);
	}

	@Override
	public String toString() {
		return "PolicyDocument [documentId=" + documentId + ", documentTitle=" + documentTitle + ", documentUrl="
				+ documentUrl + "]";
	}
	
	
}
