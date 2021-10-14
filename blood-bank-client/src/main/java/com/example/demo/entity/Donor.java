package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Donor {
	@Id
	@Column(name = "id")
	@GeneratedValue(generator="donor_id_seq")
	@SequenceGenerator(name="my_seq",sequenceName="DONOR_ID_SEQ", allocationSize=1,initialValue = 101)
	int id;
	@NotNull(message = "Required")
	@Column(name = "age")
	int age;
	@NotNull(message = "Required")
	@Column(name = "name")
	String name;
	@NotNull(message = "Required")
	@Column(name = "address")
	String address;
	@Column(name = "bloodgrp")
	String bloodGrp;
	@NotNull(message = "Required")
	@Column(name= "phonenumber")
	String phoneNumber;
	@NotNull(message = "Required")
	@Column(name = "donationdate")
	@DateTimeFormat(iso = ISO.DATE)
	LocalDate donationDate;
	
}
