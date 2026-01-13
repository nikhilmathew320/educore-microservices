package com.educore.schoolservice.service.impl;

import com.educore.schoolservice.domain.School;
import com.educore.schoolservice.dto.SchoolRegistrationRequest;
import com.educore.schoolservice.dto.SchoolResponse;
import com.educore.schoolservice.dto.StudentResponse;
import com.educore.schoolservice.entity.SchoolEntity;
import com.educore.schoolservice.exception.ResourceNotFoundException;
import com.educore.schoolservice.mapper.SchoolMapper;
import com.educore.schoolservice.repository.SchoolRepository;
import com.educore.schoolservice.service.SchoolService;
import com.educore.schoolservice.service.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;
    private final StudentClient studentClient;

    @Override
    @Transactional
    public SchoolResponse createSchool(SchoolRegistrationRequest request){
        School school = schoolMapper.toDomain(request);
        SchoolEntity schoolEntity = schoolMapper.toEntity(school);
        SchoolEntity savedSchoolEntity = schoolRepository.save(schoolEntity);
        return schoolMapper.toResponse(schoolMapper.toDomain(savedSchoolEntity));
    }

    @Override
    @Transactional(readOnly = true)
    public List<SchoolResponse> getAllSchoolsWithoutStudents() {
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toDomain)
                .map(schoolMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public SchoolResponse getSchoolById(Integer id) {
        return schoolRepository.findById(id)
                .map(schoolMapper::toDomain)
                .map(schoolMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("School", "id", id));
    }
}
