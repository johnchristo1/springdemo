package com.pratian.springbootdemo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
	
	private long studentId;
	
	private String studentName;
	
	private int age;
	
}
