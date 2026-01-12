package com.educore.studentservice.controller;

import com.educore.studentservice.dto.StudentRegistrationRequest;
import com.educore.studentservice.dto.StudentResponse;
import com.educore.studentservice.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponse> registerStudent(
            @RequestBody @Valid StudentRegistrationRequest request
    ) {
        StudentResponse studentResponse = studentService.registerStudent(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentResponse);
    }

    @GetMapping
    public List<StudentResponse> findAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponse findStudentById(
            @PathVariable("id") Long studentId
    ) {
        return studentService.findById(studentId);
    }

    @GetMapping("/school/{school-id}")
    public List<StudentResponse> findAllStudentsBySchool(@PathVariable("school-id") Integer id) {
        return studentService.findAllStudentsBySchool(id);
    }
}