package com.example.demo.student.config;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.student.bean.Student;
import com.example.demo.student.repository.StudentRepository;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			Student student1 = new Student("Valerio Cavalieri 1", LocalDate.of(1984, Month.JANUARY, 9), "kyosuke1984@email.com");
			Student student2 = new Student("Mariangela D'Elia 2", LocalDate.of(1984, Month.SEPTEMBER, 8), "madoka8983@email.com");
			studentRepository.saveAll(List.of(student1, student2));
		};
	}

}
