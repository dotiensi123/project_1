package com.example.first.controller;

import com.example.first.service.StudentService;
import com.example.first.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @PostMapping("/crestudent")
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentByID(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
    }
    @PutMapping("/{id}")
    public void updateStudent(@PathVariable("id") Long id,
                              @RequestParam(required = false) String name){
        studentService.updateStudent(id,name);
    }

}
