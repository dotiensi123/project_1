package com.example.third.repository;

import com.example.third.model.Course;
import com.example.third.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query("SELECT s FROM student s")
    List<Student> getAllStudent();

    @Query("select s from student s where s.id = ?1")
    Student getStudentById(Long id);

//    @Query("select cr from student st,course cr  where student.id = ?1")
//    Course getCourse(Long id);
}
