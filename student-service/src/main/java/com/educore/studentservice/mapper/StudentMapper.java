package com.educore.studentservice.mapper;

import com.educore.studentservice.domain.Student;
import com.educore.studentservice.dto.StudentRegistrationRequest;
import com.educore.studentservice.dto.StudentResponse;
import com.educore.studentservice.entity.StudentEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface StudentMapper {
    @Mapping(target = "id", ignore = true)
    Student toDomain(StudentRegistrationRequest studentRegistrationRequest);

    @Mapping(target = "studentId", ignore = true)
    StudentEntity toEntity(Student student);

    @Mapping(source = "studentId", target = "id")
    Student toDomain(StudentEntity studentEntity);

    @Mapping(source = "id", target = "studentId")
    StudentResponse toResponse(Student student);
}
