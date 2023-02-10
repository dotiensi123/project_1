package com.example.first.repository;

import com.demoapplicationForStudent.applicant.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepostitory extends JpaRepository<Student,Long> {

}
