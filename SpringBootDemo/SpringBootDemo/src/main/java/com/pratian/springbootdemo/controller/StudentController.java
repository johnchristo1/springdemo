package com.pratian.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pratian.springbootdemo.controller.dto.StudentDto;
import com.pratian.springbootdemo.entities.Student;
import com.pratian.springbootdemo.exceptions.StudentNotFoundException;
import com.pratian.springbootdemo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String getHome() {
		return "Ron";
	}

	@GetMapping("/")
	public ResponseEntity<?> getStudentById(@RequestParam(name = "id") long studentId) throws StudentNotFoundException {

		return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);

	}

	@GetMapping("/searchByName/{name}")
	public ResponseEntity<?> getStudentByName(@PathVariable(value = "name") String studentName) {
		return new ResponseEntity<>(studentService.getStudentByName(studentName), HttpStatus.OK);
	}

	@PostMapping("/")
	public Student postStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}

	@PutMapping("/")
	public ResponseEntity<?> putStudent(@RequestBody Student student) throws StudentNotFoundException {

		return new ResponseEntity<>(studentService.updateStudent(student), HttpStatus.OK);

	}

	// With Mapper and Dto
	@PutMapping("/mapper/")
	public ResponseEntity<?> putStudent(@RequestBody StudentDto studentDto) throws StudentNotFoundException {

		return new ResponseEntity<>(studentService.updateStudent(studentDto), HttpStatus.OK);

	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteStudentById(@PathVariable(value = "id") long studentId) throws StudentNotFoundException {

		studentService.deleteStudentById(studentId);
		return new ResponseEntity<>("Success", HttpStatus.OK);

	}

	@GetMapping(path = "/all/")
	public ResponseEntity<?> getAllStudents(@RequestParam int page) {
		return new ResponseEntity<>(studentService.getAllStudents(page), HttpStatus.OK);
	}

	@GetMapping(path = "/all/custom")
	public ResponseEntity<?> getAllStudentsCustom(@RequestParam int page) {
		return new ResponseEntity<>(studentService.getAllStudentsCustom(page), HttpStatus.OK);
	}

}
