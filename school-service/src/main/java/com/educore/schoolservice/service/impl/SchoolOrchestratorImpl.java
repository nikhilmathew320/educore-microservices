package com.educore.schoolservice.service.impl;

import com.educore.schoolservice.dto.SchoolResponse;
import com.educore.schoolservice.dto.StudentResponse;
import com.educore.schoolservice.service.SchoolOrchestrator;
import com.educore.schoolservice.service.SchoolService;
import com.educore.schoolservice.service.client.StudentClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SchoolOrchestratorImpl implements SchoolOrchestrator {

    private final SchoolService schoolService;
    private final StudentClient studentClient;

    @Override
    @Transactional(readOnly = true)
    public List<SchoolResponse> getAllSchools() {
        List<SchoolResponse> allSchoolsWithoutStudents = schoolService.getAllSchoolsWithoutStudents();
        return allSchoolsWithoutStudents.stream()
                .map(school -> {
                    List<StudentResponse> students = new ArrayList<>();
                    try {
                        students = studentClient.findAllStudentsBySchool(school.schoolId());
                    } catch (Exception e) {
                        log.error("Failed to fetch students for school ID: {}. Reason: {}",
                                school.schoolId(), e.getMessage(), e);
                    }
                    return new SchoolResponse(
                            school.schoolId(),
                            school.schoolName(),
                            school.email(),
                            school.principalName(),
                            students
                    );
                }).toList();
    }
}
