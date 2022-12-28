package com.pratian.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pratian.springbootdemo.mapper.StudentMapper;
import com.pratian.springbootdemo.mapper.StudentMapperImpl;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
	
	
	@Bean
	public StudentMapper getStudentMapper() {
		return new StudentMapperImpl();
	}
}
