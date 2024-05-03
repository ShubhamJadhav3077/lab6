package com.lab6.CollegeFest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab6.CollegeFest.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}
