package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Donor;
import com.example.demo.exception.IdNotFoundException;
import com.example.demo.repo.DonorRepository;

@Service
public class DonorService {
	
	@Autowired
	private DonorRepository repo;
	
	public List<Donor> findAll(){
		return this.repo.findAll();
	}
	
	public Donor addDonor(Donor entity) {
		return this.repo.save(entity);
	}
	
     public Object updateDonor(Donor entity) {
		
		return this.repo.updateDonor(entity.getId(),entity.getName(),entity.getAge(),entity.getAddress(),entity.getBloodGrp(),entity.getPhoneNumber(),entity.getDonationDate());
	}
	public List<Donor> findByaddress(String address){
		return this.repo.findByAddress(address);
	}
	public List<Donor> findByBloodGroup(String bloodGroup){
		return this.repo.findByBloodGrp(bloodGroup);
	}
	
	public List<Integer> getbyAllIds(){
		return this.repo.getIds();
	}
	
	public Donor findByID(Integer id) throws IdNotFoundException {
		return this.repo.findById(id).orElseThrow(()->new IdNotFoundException("Id not found"));
	}
	public int remove(int id) {
		int rowDeleted=0;
		if(this.repo.existsById(id)) {
			rowDeleted=1;
			this.repo.deleteById(id);
		}
		return rowDeleted;
	}
	

}
