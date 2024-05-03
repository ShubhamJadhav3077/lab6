package com.lab6.CollegeFest.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab6.CollegeFest.entity.Student;
import com.lab6.CollegeFest.repository.StudentRepository;
import com.lab6.CollegeFest.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	public Student getStudent(int studentId) {

		return studentRepository.findById(studentId).get();
	}

	public void updateStudent(int studentId, Student student) {
		Student updatedStudent = studentRepository.findById(studentId).get();
		updatedStudent.setFirstName(student.getFirstName());
		updatedStudent.setLastName(student.getLastName());
		updatedStudent.setCourse(student.getCourse());
		updatedStudent.setCountry(student.getCountry());
		studentRepository.save(updatedStudent);
	}

	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);

	}

}
