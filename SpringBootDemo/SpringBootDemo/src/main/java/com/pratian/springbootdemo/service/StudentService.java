package com.pratian.springbootdemo.service;

import java.util.List;

import com.pratian.springbootdemo.controller.dto.StudentDto;
import com.pratian.springbootdemo.entities.Student;
import com.pratian.springbootdemo.exceptions.StudentNotFoundException;

public interface StudentService {
	
	public StudentDto getStudentById(long studentId) throws StudentNotFoundException;
	
	public Student addStudent(Student student);

	public List<Student> getStudentByName(String studentName);

	public int updateStudent(Student student) throws StudentNotFoundException;

	public Student updateStudent(StudentDto studentDto) throws StudentNotFoundException;

	public void deleteStudentById(long studentId) throws StudentNotFoundException;

	public List<Student> getAllStudents(int page);

	List<Student> getAllStudentsCustom(int page);
}
