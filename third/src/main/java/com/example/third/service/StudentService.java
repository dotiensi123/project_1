package com.example.third.service;


import com.example.third.model.Course;
import com.example.third.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
   public List<Student> getStudent();
   public List<Student> getAllStudent();
   public void save(Student student);
   public Student findById(Long id);
   public void delete(Student student);
   public Student getStudentById(Long id);

}
