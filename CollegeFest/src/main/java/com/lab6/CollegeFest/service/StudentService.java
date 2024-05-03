package com.lab6.CollegeFest.service;

import java.util.List;

import com.lab6.CollegeFest.entity.Student;

public interface StudentService {
	public List<Student> getAllStudents();

	public void addStudent(Student student);

	public Student getStudent(int studentId);

	public void updateStudent(int studentId, Student student);

	public void deleteStudent(int studentId);

}
