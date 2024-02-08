package com.panij.springbootOneToaMany.controller;

import com.panij.springbootOneToaMany.model.Student;
import com.panij.springbootOneToaMany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public List<Student> getAll(){
        return service.gelAll();
    }
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        return service.addStudent(student);
    }
    @GetMapping("/student/{sid}")
    public Optional<Student> getById(@PathVariable int sid){
        return service.getById(sid);
    }
    @GetMapping("/student/{name}")
    public Student getByName(@PathVariable String name){
        return service.getByName(name);
    }
    @DeleteMapping("/student/{sid}")
    public String delete(@PathVariable int sid){
         service.getById(sid);
         return sid + " : Student Deleted ";
    }
    @PutMapping("/update/{sid}")
    public Student update(@RequestBody Student student){
        return service.update(student);
    }

}
