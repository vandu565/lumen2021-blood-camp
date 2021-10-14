package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Camp;
import com.example.demo.repo.CampRepo;

@Service
public class DonationCampService {

	@Autowired
	private CampRepo repo;
	
	public List<Camp> findByLocation(String location){
		return this.repo.findByLocation(location);
	}
	
	public Camp newCamp(Camp entity) {
		return this.repo.save(entity);
	}
	
	public List<Camp> findAllCamps(){
		return this.repo.findAll();
	}

	public int removeCamp(int id) {
		int rowDeleted=0;
		if(this.repo.existsById(id)) {
			rowDeleted=1;
			this.repo.deleteById(id);
		}
		return rowDeleted;
	}
}
