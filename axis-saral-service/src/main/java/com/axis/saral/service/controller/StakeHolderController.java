package com.axis.saral.service.controller;

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

import com.axis.saral.service.entity.StakeHolder;
import com.axis.saral.service.service.StakeHolderService;

@CrossOrigin("http://localhost:3000")
@RestController
public class StakeHolderController {

	@Autowired
	private StakeHolderService stakeHolderService;

	@GetMapping("/stake-holders")
	public List<StakeHolder> getAllStakeHolders() {
		return stakeHolderService.getAllStakeHolders();
	}

	@GetMapping("/stake-holder/{stakeHolderId}")
	public StakeHolder getStakeHolderId(@PathVariable String stakeHolderId) {
		return stakeHolderService.getStakeHolderById(stakeHolderId);
	}

	@PostMapping("/stake-holder")
	public ResponseEntity<String> saveStakeHolder(@RequestBody StakeHolder stakeHolder) {
		stakeHolderService.saveStakeHolder(stakeHolder);
		return new ResponseEntity<String>("StakeHolder Added Sucessfully", HttpStatus.CREATED);
	}

	@DeleteMapping("/stake-holder/delete/{stakeHolderId}")
	public ResponseEntity<String> deleteStakeHolderById(@PathVariable String stakeHolderId) {
		stakeHolderService.deleteStakeHolderById(stakeHolderId);
		return new ResponseEntity<String>("StakeHolder deleted sucessfully"  + stakeHolderId, HttpStatus.OK);
	}
	
	@PutMapping("/stake-holder/update/{stakeHolderId}")
	public ResponseEntity<String> updateStakeHolderDetails(@PathVariable String stakeHolderId,
			@RequestBody StakeHolder updatedStakeHolder){
		if(stakeHolderId != updatedStakeHolder.getStakeHolderId()) {
			return new ResponseEntity<String>("StakeHolder Not Found!!", HttpStatus.BAD_REQUEST);
		}else {
			stakeHolderService.updateStakeHolderDetails(stakeHolderId, updatedStakeHolder);
			return new ResponseEntity<String>("StakeHolder updated Successfully", HttpStatus.OK);
		}
	}
}
