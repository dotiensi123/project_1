package com.example.third.service;

import com.example.third.model.Course;
import com.example.third.model.Student;
import com.example.third.repository.CourseRepository;
import com.example.third.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{


    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
//    @Override
//    public Course getCourse(Long id){
//        return studentRepository.getCourse(id);
//    }

    @Override
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.getAllStudent();
    }


    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }

    @Override

    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }


}

