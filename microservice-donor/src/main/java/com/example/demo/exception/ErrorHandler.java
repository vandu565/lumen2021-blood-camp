package com.example.demo.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorHandler {
	private LocalDateTime currentTime; 
	private String message;
	private String description;


}
