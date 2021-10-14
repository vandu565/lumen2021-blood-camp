package com.example.demo.controller;


import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Camp;
import com.example.demo.entity.Donor;

@Controller
public class BloodBankController {
	@Autowired
	private Donor object;
	@Autowired
	private Camp campObj;
	@Autowired
	private RestTemplate template;
	
	private Donor data;
	private Camp campData;

//	@RequestMapping(value = "/" ,method = RequestMethod.GET)
//	public String init(Model model) {
//		return "main";
//	}
	
	@GetMapping(path="/")
	public String home(Model model) {
		return "main";
	}
	
	
	@GetMapping(path = "/donorRegisteration")
	public String loadDonor(Model model) {
		model.addAttribute("donorObj",object);
		model.addAttribute("errorMsg", "");
		return "donorRegisteration";
	}
	@PostMapping(path = "/donor")
	public String postDonor(@Valid Model model,Donor donor,BindingResult result) {
		data = donor;
		System.out.println("ENTITY= "+ model +donor);
		String nextStep = "success";
		try {
		if(result.hasErrors()) {
			nextStep="donorRegisteration";
		}
		else {
			
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Donor> requestBody = new HttpEntity<>(donor,headers);
		    Donor obj =  this.template.postForObject("http://localhost:3031/api/v1/donors/", requestBody, Donor.class);
		    model.addAttribute("object",obj);
		    }
			
		}
		
		catch(Exception e) {
			String errorMsg = "Error occured During Registration.";
			return "redirect:/registerError?errorMsg="+errorMsg;	
		}
		return nextStep;
	}
	
	@GetMapping("/registerError")
	public String registerError(@RequestParam("errorMsg") String errorMsg, Model model) {
		model.addAttribute("donorObj",data);
		model.addAttribute("errorMsg",errorMsg);
		return "donorRegisteration";
	}
	
	@GetMapping(path = "/search")
	public String loadSearch(Model model) {
		return "search";
	}
	@GetMapping(path = "/searchbybloodgroup")
	public String loadSearchByGroup(Model model) {	
		model.addAttribute("donorObj",object);
		return "bloodGroup";
	}
	@GetMapping(path = "/bloodgroup")
	public String searchByGroup(@RequestParam String bloodGrp,Model model) {	
		Donor[] resp =template.getForObject("http://localhost:3031/api/v1/donors/bloodgrp/"+bloodGrp,Donor[].class);
		model.addAttribute("donors",resp);
		model.addAttribute("bloodGrp", bloodGrp);
		return "listBloodGroup";
	}
	@GetMapping(path = "/searchbyaddress")
	public String loadSearchByLocation(Model model) {	
		model.addAttribute("donorObj",object);
		return "location";
	}
	
	
	
	@GetMapping(path = "/donorderegistration")
	public String loadDeregistration(Model model) {
		model.addAttribute("donorObj", object);
		return "cancelDonor";
	}
	@GetMapping(path = "/delete")
	public String deleteDonor(@RequestParam int id, Model model) {
		try {
		this.template.delete("http://localhost:3031/api/v1/donors/"+id);
		}
		catch(Exception e) {
			model.addAttribute("message", "Donor Does Not Exist");
			return "delete";
		}
		model.addAttribute("message", "Donor is successfully Un-registered From The Camp");
		return "delete";
	}
	
	@GetMapping(path = "/update")
	public String updateDonor(Model model) {
		model.addAttribute("donorObj",object);
		String[] resp =template.getForObject("http://localhost:3031/api/v1/donors/getall/ids",String[].class);
		model.addAttribute("ids", resp);
		return "IdList";
	}
	@GetMapping(path = "/updateform")
	public String updateDonorById(@RequestParam int id, Model model) {
		Donor obj = template.getForObject("http://localhost:3031/api/v1/donors/"+id, Donor.class);
		model.addAttribute("errorMsg", "");
		model.addAttribute("donorObj", obj);
		return "updateDonor";
	}
	@PostMapping(path="/update")
	public String putDonor(@Valid Model model,Donor donor,BindingResult result) {
		data = donor;
		String nextStep = "updateResponse";
		try {
		if(result.hasErrors()) {
			nextStep="updateDonor";
		}
		else {
			
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Donor> requestBody = new HttpEntity<>(donor,headers);
		     this.template.put("http://localhost:3031/api/v1/donors/", requestBody, Donor.class);
		  //  model.addAttribute("object",obj);
		    }
			
		}
		catch(Exception e) {
			String errorMsg = "Error occured During Registration.";
			return "redirect:/updateError?errorMsg="+errorMsg;	
		}
		return nextStep;
	}
	
	@GetMapping("/updateError")
	public String updateError(@RequestParam("errorMsg") String errorMsg, Model model) {
		model.addAttribute("donorObj",data);
		model.addAttribute("errorMsg",errorMsg);
		return "updateDonorForm";
	}
	
	
	@GetMapping(path = "/registerCamp")
	public String loadCamp(Model model) {
		model.addAttribute("campObj", campObj);
		model.addAttribute("errorMsg", "");
		return "CampRegisteration";
	}
	@PostMapping(path = "/registerCamp")
	public String postCamp(@Valid Model model,Camp camp,BindingResult result) {
		campData = camp;
		String nextStep = "success";
		try {
		if(result.hasErrors()) {
			nextStep="CampRegisteration";
		}
		else {
			
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Camp> requestBody = new HttpEntity<>(camp,headers);
		    Camp obj =  this.template.postForObject("http://localhost:3032/api/v1/camps/", requestBody, Camp.class);
		    model.addAttribute("object",obj);
		    }
			
		}
		catch(Exception e) {
			String errorMsg = "Error occured During Registration.";
			return "redirect:/registerCampError?errorMsg="+errorMsg;	
		}
		return nextStep;
	}
	
	@GetMapping("/registerCampError")
	public String registerCampError(@RequestParam("errorMsg") String errorMsg, Model model) {
		model.addAttribute("campObj", campData);
		model.addAttribute("errorMsg",errorMsg);
		return "donationCamp";
	}
	
	@GetMapping(path = "/deletecamp")
	public String deleteCamp(@RequestParam int id, Model model) {
		try {
		this.template.delete("http://localhost:3032/api/v1/camps/"+id);
		}
		catch(Exception e) {
			model.addAttribute("message", "Camp Does Not exist");
			return "delete";
		}
		model.addAttribute("message", "Camp is un registered successfully");
		return "delete";
	}
	
	
	@GetMapping(path = "/campderegistration")
	public String loadCampDeRegistration(Model model) {
		model.addAttribute("campObj", campObj);
		return "removeCamp";
	}
	@GetMapping(path = "/address")
	public String searchByLocation(@RequestParam String address,Model model) {
		address = address.trim();
		if(address.length()==0) {
			return "locationList";
		}
		Donor[] resp =template.getForObject("http://localhost:3031/api/v1/donors/address/"+address,Donor[].class);
		model.addAttribute("donors",resp);
		model.addAttribute("location", address);
		return "locationList";
	}
}
