package com.example.demo.student.bean;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "STUDENT")
public class Student {

	@Id
	@SequenceGenerator(
		allocationSize = 1,
		name = "student_sequence",
		sequenceName = "student_sequence"
	)
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "student_sequence"
	)  
	private Long id; 
	private String name;
	
	@Transient
	private Integer age;
	
	private LocalDate birthDate;
	private String email;
	
	public Student() {
		super();
	}

	public Student(Long id, String name, LocalDate birthDate, String email) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
	}
	
	public Student(String name, LocalDate birthDate, String email) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return Period.between(birthDate, LocalDate.now()).getYears();
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + getAge() + ", birthDate=" + birthDate + ", email=" + email
				+ "]";
	}

}
