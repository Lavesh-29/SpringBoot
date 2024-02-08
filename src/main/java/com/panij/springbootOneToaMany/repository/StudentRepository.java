package com.panij.springbootOneToaMany.repository;

import com.panij.springbootOneToaMany.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByName(String name);
}
