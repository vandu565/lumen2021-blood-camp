package com.example.demo.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Camp;

@Repository
public interface CampRepo extends JpaRepository<Camp, Integer>{

	List<Camp> findByLocation(String location);

}
