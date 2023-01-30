package com.axis.saral.service.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.saral.service.entity.StakeHolder;
import com.axis.saral.service.exception.StakeHolderNotFoundException;
import com.axis.saral.service.repository.StakeHolderRepository;

@Service
public class StakeHolderServiceImpl implements StakeHolderService {

	@Autowired
	StakeHolderRepository stakeHolderRepository;
	
	@Override
	public List<StakeHolder> getAllStakeHolders() {
		// TODO Auto-generated method stub
		return (List<StakeHolder>) stakeHolderRepository.findAll() ;
	}

	@Override
	public StakeHolder getStakeHolderById(String stakeHolderId) {
		Optional<StakeHolder> stakeHolderOptional = stakeHolderRepository.findById(stakeHolderId);
		if((!stakeHolderOptional.isPresent())){
			throw new StakeHolderNotFoundException("StakeHolder not Found with ID: " +stakeHolderId);
		}
		return stakeHolderOptional.get();
	}

	@Override
	public void saveStakeHolder(StakeHolder stakeHolder) {
		// TODO Auto-generated method stub
		stakeHolderRepository.save(stakeHolder);
	}

	@Transactional
	@Override
	public void updateStakeHolderDetails(String stakeHolderId, StakeHolder updatedStakeHolder) {
		// TODO Auto-generated method stub
		stakeHolderRepository.save(updatedStakeHolder);
	}

	@Override
	public void deleteStakeHolderById(String stakeHolderId) {
		// TODO Auto-generated method stub
		stakeHolderRepository.deleteById(stakeHolderId);
	}

}
