package com.example.demo.student.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.student.bean.Student;
import com.example.demo.student.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents () {
		return studentRepository.findAll();
	}

	public void registerNewStudent(Student student) {
		Optional<Student> studentFound = studentRepository.findByEmail(student.getEmail());
		if(studentFound.isPresent()) {
			throw new IllegalArgumentException("Student already present with email : " + student.getEmail());
		} else {
			studentRepository.save(student);
		}
	}

	public void deleteStudent(Long idStudent) {
		boolean studentFound = studentRepository.existsById(idStudent);
		if(!studentFound) {
			throw new IllegalArgumentException("Student not present with id : " + idStudent);
		} else {
			studentRepository.deleteById(idStudent);
		}
	}

	@Transactional
	public void updateStudent(Long idStudent, String name, String email) {
		Optional<Student> studentFound = studentRepository.findById(idStudent);
		if(!studentFound.isPresent()) {
			throw new IllegalArgumentException("Student not present with id : " + idStudent);
		} else {
			Student realStudent = studentFound.get();
			if(name != null && name.length() > 0) {
				realStudent.setName(name);
			}
			if(email != null && email.length() > 0) {
				realStudent.setName(email);
			}
			studentRepository.save(realStudent);
		}
		
	}
}
