package com.example.demo.student.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.student.bean.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	Optional<Student> findByEmail(String email);
	
}
