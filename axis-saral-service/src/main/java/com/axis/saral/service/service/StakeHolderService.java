package com.axis.saral.service.service;

import java.util.List;


import com.axis.saral.service.entity.StakeHolder;


public interface StakeHolderService {
	
	List<StakeHolder> getAllStakeHolders();
	StakeHolder getStakeHolderById(String stakeHolderId);
	void saveStakeHolder(StakeHolder stakeHolder);
	void updateStakeHolderDetails (String stakeHolderId, StakeHolder updatedStakeHolder);
	void deleteStakeHolderById(String stakeHolderId);
}
