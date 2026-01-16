package com.educore.schoolservice.service.client;

import com.educore.schoolservice.dto.StudentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service")
public interface StudentClient {

    @GetMapping("/api/v1/students/school/{school-id}")
    List<StudentResponse> findAllStudentsBySchool(@PathVariable("school-id") Integer schoolId);
}
