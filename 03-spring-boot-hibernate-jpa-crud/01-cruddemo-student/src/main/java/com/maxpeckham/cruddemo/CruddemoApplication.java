package com.maxpeckham.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.maxpeckham.cruddemo.dao.StudentDAO;
import com.maxpeckham.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAll(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student[] students = new Student[] {
			new Student("John", "Doe", "jdoe@w.com"),
			new Student("Mary", "Public", "mpublic@w.com"),
			new Student("Bonita", "Applebum", "bapplebum@w.com")
		};
		for (Student s : students) {
			System.out.println("Saving: " + s);
			studentDAO.save(s);
			System.out.println("Saved: " + s);
		}
	}

	private void deleteStudent(StudentDAO studentDAO) {
		Student student = new Student("Allen", "Turing", "atur@www.net");
		studentDAO.save(student);
		int studentId = student.getId();
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	/* 
	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@maxpeckham.com");
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
	*/
	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		System.out.println("Updating stduent..");
		myStudent.setFirstName("John");
		studentDAO.update(myStudent);
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Doe");
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new stduent object ...");
		Student tempStudent = new Student("Daffy", "Duck", "dd@maxpeckham.com");
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);
		System.out.println("Retrieving the student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);
		System.out.println("Found the student: " + myStudent);
	}

    private void deleteAll(StudentDAO studentDAO) {
		  System.out.println("Deleting all students");
		  int numRowsDeleted = studentDAO.deleteAll();
		  System.out.println("Delete row count: " + numRowsDeleted);
    }
}
