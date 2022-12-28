package com.pratian.springbootdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pratian.springbootdemo.controller.dto.StudentDto;
import com.pratian.springbootdemo.entities.Student;
import com.pratian.springbootdemo.exceptions.StudentNotFoundException;
import com.pratian.springbootdemo.mapper.StudentMapper;
import com.pratian.springbootdemo.repository.StudentRepository;
import com.pratian.springbootdemo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentMapper studentMapper;

	@Override
	public StudentDto getStudentById(long studentId) throws StudentNotFoundException {
		if (!studentRepository.existsById(studentId)) {
			throw new StudentNotFoundException("Student with that Id does not exists");
		}

		Student studentEntity = studentRepository.findById(studentId).get();

		StudentDto studentDto = studentMapper.convertToStudentDto(studentEntity);

		return studentDto;

	}

	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getStudentByName(String studentName) {

		return studentRepository.getStudentByName(studentName);
	}

	/**
	 * without using Mapper
	 */
	@Override
	public int updateStudent(Student student) throws StudentNotFoundException {
		// using Custom Query to update
		return studentRepository.updateStudent(student.getStudentName(), student.getStudentId());

		// using save method to update
//		Student studentEntity = studentRepository.findById(student.getStudentId())
//				.orElseThrow(() -> new StudentNotFoundException("No student with that Id Exists"));

//		studentEntity.setStudentName(student.getStudentName());
//		return studentRepository.save(studentEntity);

	}

	/**
	 * Used Mapper for updating
	 * 
	 * @param studentDto
	 * @return
	 * @throws StudentNotFoundException
	 */
	@Override
	public Student updateStudent(StudentDto studentDto) throws StudentNotFoundException {
//		

		Student studentEntity = studentRepository.findById(studentDto.getStudentId())
				.orElseThrow(() -> new StudentNotFoundException("No student with that Id Exists"));

		studentEntity = studentMapper.updateStudentEntity(studentDto, studentEntity);
		return studentRepository.save(studentEntity);

	}

	@Override
	public void deleteStudentById(long studentId) throws StudentNotFoundException {
		
		Student studentEntity = studentRepository.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException("No student with that Id Exists"));

		
		studentRepository.delete(studentEntity);
	}

	@Override
	public List<Student> getAllStudents(int page) {
		int size = 3;
		Pageable pagable = PageRequest.of(page,size);
		return studentRepository.findAll(pagable).toList();
	}
	
	@Override
	public List<Student> getAllStudentsCustom(int page){
		int size = 3;
		Pageable pagable = PageRequest.of(page,size);
		return studentRepository.getAllStudents(pagable);
	}

}
