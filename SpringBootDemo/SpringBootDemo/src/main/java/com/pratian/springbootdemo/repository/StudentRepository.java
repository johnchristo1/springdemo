package com.pratian.springbootdemo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pratian.springbootdemo.entities.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	@Query("from Student s where s.studentName like %:name% ")
	List<Student> getStudentByName(@Param(value = "name") String studentName);
	
	@Modifying
	@Transactional
	@Query("update Student s set s.studentName=:name where s.studentId=:id")
	int updateStudent(@Param(value = "name")String name, @Param(value = "id")long studentId);
	
	@Query("from Student")
	List<Student> getAllStudents(Pageable pagable);
	
}
