package com.example.STUDENT_MANAGEMENT.MODEL;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.STUDENT_MANAGEMENT.ENTITY.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
