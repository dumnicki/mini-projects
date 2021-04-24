package com.dumnicki.studentdatabase;

import com.dumnicki.studentdatabase.model.Course;
import com.dumnicki.studentdatabase.repository.CourseRepository;
import com.dumnicki.studentdatabase.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentDatabaseApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course intro = new Course("Intro","Introduction to programming");
		Course python = new Course("Python","Python course");

		courseRepository.save(intro);
		courseRepository.save(python);
	}
}
