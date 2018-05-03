package com.kgfsl.springdata1.repository;

import com.kgfsl.springdata1.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    
	
}