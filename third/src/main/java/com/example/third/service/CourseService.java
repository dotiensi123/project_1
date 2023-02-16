package com.example.third.service;

import com.example.third.model.Course;
import com.example.third.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    public List<Course> getAllCourse();
    public void saveCourse(Course course);
    public void delete(Course course);
    public Course getCourseById(Long id);
}
