package com.pratian.springbootdemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.pratian.springbootdemo.controller.dto.StudentDto;
import com.pratian.springbootdemo.entities.Student;

@Mapper
public interface StudentMapper {

	StudentDto convertToStudentDto(Student student);

	Student updateStudentEntity(StudentDto studentDto, @MappingTarget Student student);
}
