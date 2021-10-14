package com.example.demo.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name = "table_donor")
@Transactional
public class Donor {
	
	
	@Id
	@Column(name = "id")
	@GeneratedValue(generator="donor_id_seq")
	@SequenceGenerator(name="my_seq",sequenceName="DONOR_ID_SEQ", allocationSize=1,initialValue = 101)
	int id;
	@Column(name = "age")
	int age;
	@Column(name = "name")
	String name;
	@Column(name = "address")
	String address;
	@Column(name = "bloodgrp")
	String bloodGrp;
	@Column(name= "phonenumber")
	String phoneNumber;
	@Column(name = "donationdate")
	@DateTimeFormat(iso = ISO.DATE)
	LocalDate donationDate;
	@ManyToMany(mappedBy = "donors")
	List<Camp> camps;
}
