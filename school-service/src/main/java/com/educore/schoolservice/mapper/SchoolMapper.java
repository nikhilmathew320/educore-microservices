package com.educore.schoolservice.mapper;

import com.educore.schoolservice.domain.School;
import com.educore.schoolservice.dto.SchoolRegistrationRequest;
import com.educore.schoolservice.dto.SchoolResponse;
import com.educore.schoolservice.entity.SchoolEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface SchoolMapper {
    @Mapping(target = "schoolId", ignore = true)
    School toDomain(SchoolRegistrationRequest request);

    @Mapping(target = "schoolId", ignore = true)
    SchoolEntity toEntity(School school);

    School toDomain(SchoolEntity schoolEntity);

    SchoolResponse toResponse(School school);
}
