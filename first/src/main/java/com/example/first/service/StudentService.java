package com.example.first.service;

import com.demoapplicationForStudent.applicant.model.Student;
import com.demoapplicationForStudent.applicant.repository.StudentRepostitory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentService {
    @Autowired
    private final StudentRepostitory studentRepostitory;

    public StudentService(StudentRepostitory studentRepostitory) {
        this.studentRepostitory = studentRepostitory;
    }

    public List<Student> getStudents() {
        return studentRepostitory.findAll();
    }
}
