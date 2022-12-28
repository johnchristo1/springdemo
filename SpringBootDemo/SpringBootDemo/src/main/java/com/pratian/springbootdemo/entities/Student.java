package com.pratian.springbootdemo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
	
	@Id
	@GeneratedValue
	private long studentId;
	
	private String studentName;
	
	private int age;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

}
