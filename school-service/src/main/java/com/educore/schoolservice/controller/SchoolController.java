package com.educore.schoolservice.controller;

import com.educore.schoolservice.dto.SchoolRegistrationRequest;
import com.educore.schoolservice.dto.SchoolResponse;
import com.educore.schoolservice.service.SchoolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping
    public ResponseEntity<SchoolResponse> schoolRegistration(@RequestBody @Valid SchoolRegistrationRequest request){
        SchoolResponse schoolResponse = schoolService.createSchool(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(schoolResponse);
    }

    @GetMapping
    public List<SchoolResponse> findAllSchools(){
        return schoolService.getAllSchools();
    }

    @GetMapping("/{id}")
    public SchoolResponse findSchoolDetailsById(@PathVariable("id") Integer schoolId){
        return schoolService.getSchoolById(schoolId);
    }
}
