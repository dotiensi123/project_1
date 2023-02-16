package com.example.third.controller;

import com.example.third.model.Course;
import com.example.third.model.Student;
import com.example.third.service.CourseService;
import com.example.third.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final CourseService courseService;
    @GetMapping()
    public ResponseEntity<?> getUser(){
        Map<String, Object> map = new LinkedHashMap<>();
        List<Student> students = studentService.getAllStudent();
        if(!students.isEmpty()){
            map.put("status",1);
            map.put("data",students);
            return ResponseEntity.ok(map);
        }
        else {
            map.clear();
            map.put("status", 0);
            map.put("data", "data is not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        Map<String, Object> map = new LinkedHashMap<>();
        studentService.save(student);
        map.put("status",1);
        map.put("message","save ok");
        return new ResponseEntity<>(map,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id){
        Map<String, Object> map = new LinkedHashMap<>();
        try{
            Student student = studentService.getStudentById(id);
            map.put("status",1);
            map.put("data",student);
            return new ResponseEntity<>(map,HttpStatus.OK);
        }catch(Exception e){
            map.put("status",0);
            map.put("data","student not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable("id") Long id){
        Map<String,Object> map = new LinkedHashMap<>();
        try{
            Student student = studentService.findById(id);
            studentService.delete(student);
            map.put("status",1);
            map.put("message","delete student ok");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }catch(Exception e){
            map.clear();
            map.put("status",0);
            map.put("message","data is not found");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudentById(@PathVariable("id") Long id,
                                               @RequestParam(required = false) String name,
                                               @RequestParam(required = false) String email,
                                               @RequestParam(required = false) String phone){
        Map<String,Object> map = new LinkedHashMap<>();
        try{
            Student student = studentService.findById(id);
            if(name!= null) student.setName(name);
            studentService.save(student);
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
