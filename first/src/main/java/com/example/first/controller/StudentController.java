package com.example.first.controller;

import com.demoapplicationForStudent.applicant.model.Student;
import com.demoapplicationForStudent.applicant.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/all")
    public List<Student> getAllStudent(){
        return studentService.getStudents();
    }
}
