package com.axis.saral.service.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StakeHolder {

	@Id
	private String stakeHolderId;
	private String stakeHolderName;
	private String stakeHolderEmailId;
	private long stakeHolderMobileNumber;
	
	
	public StakeHolder() {
		
	}
	
	public StakeHolder(String stakeHolderId, String stakeHolderName, String stakeHolderEmailId,
			long stakeHolderMobileNumber) {
		super();
		this.stakeHolderId = stakeHolderId;
		this.stakeHolderName = stakeHolderName;
		this.stakeHolderEmailId = stakeHolderEmailId;
		this.stakeHolderMobileNumber = stakeHolderMobileNumber;
	}

	public String getStakeHolderId() {
		return stakeHolderId;
	}

	public void setStakeHolderId(String stakeHolderId) {
		this.stakeHolderId = stakeHolderId;
	}

	public String getStakeHolderName() {
		return stakeHolderName;
	}

	public void setStakeHolderName(String stakeHolderName) {
		this.stakeHolderName = stakeHolderName;
	}

	public String getStakeHolderEmailId() {
		return stakeHolderEmailId;
	}

	public void setStakeHolderEmailId(String stakeHolderEmailId) {
		this.stakeHolderEmailId = stakeHolderEmailId;
	}

	public long getStakeHolderMobileNumber() {
		return stakeHolderMobileNumber;
	}

	public void setStakeHolderMobileNumber(long stakeHolderMobileNumber) {
		this.stakeHolderMobileNumber = stakeHolderMobileNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(stakeHolderId, stakeHolderName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StakeHolder other = (StakeHolder) obj;
		return Objects.equals(stakeHolderId, other.stakeHolderId)
				&& Objects.equals(stakeHolderName, other.stakeHolderName);
	}

	@Override
	public String toString() {
		return "StakeHolders [stakeHolderId=" + stakeHolderId + ", stakeHolderName=" + stakeHolderName
				+ ", stakeHolderEmailId=" + stakeHolderEmailId + ", stakeHolderMobileNumber=" + stakeHolderMobileNumber
				+ "]";
	}
		
	
}
