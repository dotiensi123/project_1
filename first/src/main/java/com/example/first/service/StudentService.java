package com.example.first.service;

import com.example.first.model.Student;
import com.example.first.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudent() {
       return studentRepository.findAll();
    }

    public void createStudent(Student student) {
        Optional<Student> student1
                = studentRepository.findStudentByEmail(student.getEmail());
        if(student1.isPresent()){
            throw new IllegalStateException("email taken ");
        }
        studentRepository.save(student);
    }


    public void deleteStudentById(Long id) {
        boolean exists = studentRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("student with id" +id);
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "student by id "+ id +"not exits"));
        student.setName(name);
        student.setEmail(email);
        studentRepository.save(student);
    }
}
