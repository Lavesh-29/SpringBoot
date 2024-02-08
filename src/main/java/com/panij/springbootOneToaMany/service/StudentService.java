package com.panij.springbootOneToaMany.service;

import com.panij.springbootOneToaMany.model.Student;
import com.panij.springbootOneToaMany.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repo;

    public List<Student> gelAll() {
        return repo.findAll();
    }

    public Student addStudent(Student student) {
        return repo.save(student);
    }

    public Optional<Student> getById(int sid) {
        return repo.findById(sid);
    }

    public Student getByName(String name) {
        return repo.findByName(name);
    }

    public Student update(Student student) {
        Student existingStudent = repo.findById(student.getSid()).orElse(null);

        if(existingStudent!=null){

           existingStudent.setSid(student.getSid());
           existingStudent.setName(student.getName());
           existingStudent.setAddress(student.getAddress());
           existingStudent.setEmail(student.getEmail());
           return repo.save(existingStudent);
        }else{

            throw new RuntimeException("Customer with CID " + student.getSid() + " not found");

        }
    }
    public void delete(int sid){
        repo.deleteById(sid);
    }


}



