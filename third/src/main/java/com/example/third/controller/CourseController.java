package com.example.third.controller;

import com.example.third.model.Course;
import com.example.third.model.Student;
import com.example.third.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping()
    public ResponseEntity<?> getALLStudent(){
        Map<String, Object> map = new LinkedHashMap<>();
        List<Course> courses = courseService.getAllCourse();
        if(courses.isEmpty()){
            map.clear();
            map.put("status", 0);
            map.put("data", "data is not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
        else{
            map.put("status",1);
            map.put("data",courses);
            return ResponseEntity.ok(map);
        }
    }

    @PostMapping()
    public ResponseEntity<?> saveCourse(@RequestBody Course course){
        Map<String, Object> map = new LinkedHashMap<>();
        courseService.saveCourse(course);
        map.put("status",1);
        map.put("message","save ok");
        return new ResponseEntity<>(map,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable("id") Long id){
        Map<String, Object> map = new LinkedHashMap<>();
        try{
            Course course = courseService.getCourseById(id);
            map.put("status",1);
            map.put("data",course);
            return new ResponseEntity<>(map,HttpStatus.OK);
        }catch(Exception e){
            map.put("status",0);
            map.put("data","course not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourseById(@PathVariable("id") Long id){
        Map<String, Object> map = new LinkedHashMap<>();
        try{
            Course course = courseService.getCourseById(id);
            courseService.delete(course);
            map.put("status",1);
            map.put("message","delete course ok");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }catch(Exception e){
            map.clear();
            map.put("status",0);
            map.put("message","data is not found");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCoursetById(@PathVariable("id") Long id,
                                               @RequestParam(required = false) String name,
                                               @RequestParam(required = false) String description){
        Map<String,Object> map = new LinkedHashMap<>();
        try{
            Course course = courseService.getCourseById(id);
            if(name!= null) course.setName(name);
            if(description!=null) course.setDescription(description);
            courseService.saveCourse(course);
            map.put("status",1);
            map.put("message","update ok");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }catch(Exception e){
            map.clear();
            map.put("status",0);
            map.put("message","data not found");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
    }
}
