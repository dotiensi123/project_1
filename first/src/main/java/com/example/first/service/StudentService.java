package com.example.first.service;

import com.example.first.repository.StudentRepository;
import com.example.first.student.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service

public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByName  = studentRepository
                .findStudentByName(student.getName());
        if(studentByName.isPresent()){
            throw new IllegalStateException("name taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("student with id "+id + "not exists");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException(
                        "student with id " + id +"doesn't not exist"
                )) ;
            student.setName(name);
        studentRepository.save(student);
    }
}
