package com.educore.studentservice.service;

import com.educore.studentservice.domain.Student;
import com.educore.studentservice.dto.StudentRegistrationRequest;
import com.educore.studentservice.dto.StudentResponse;
import com.educore.studentservice.entity.StudentEntity;
import com.educore.studentservice.exception.ResourceNotFoundException;
import com.educore.studentservice.exception.StudentAlreadyExistsException;
import com.educore.studentservice.mapper.StudentMapper;
import com.educore.studentservice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentResponse registerStudent(StudentRegistrationRequest studentRegistrationRequest) {
        if (studentRepository.existsByEmail(studentRegistrationRequest.email())) {
           throw new StudentAlreadyExistsException("Student already exists with this email:" + studentRegistrationRequest.email());
        }
        Student student = studentMapper.toDomain(studentRegistrationRequest);
        StudentEntity studentEntity = studentMapper.toEntity(student);
        StudentEntity savedStudentEntity = studentRepository.save(studentEntity);
        return studentMapper.toResponse(studentMapper.toDomain(savedStudentEntity));
    }

    public List<StudentResponse> findAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDomain)
                .map(studentMapper::toResponse)
                .collect(Collectors.toList());
    }

    public StudentResponse findById(Long id) {
        return studentRepository.findById(id)
                .map(studentMapper::toDomain)
                .map(studentMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
    }

    public List<StudentResponse> findAllStudentsBySchool(Integer schoolId) {
        return studentRepository.findAllBySchoolId(schoolId)
                .stream()
                .map(studentMapper::toDomain)
                .map(studentMapper::toResponse)
                .collect(Collectors.toList());
    }
}
