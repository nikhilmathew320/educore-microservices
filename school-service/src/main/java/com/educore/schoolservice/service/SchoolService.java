package com.educore.schoolservice.service;

import com.educore.schoolservice.dto.SchoolRegistrationRequest;
import com.educore.schoolservice.dto.SchoolResponse;

import java.util.List;

public interface SchoolService {

    /**
     * create new school
     * @param request - contains all school registration required details
     * @return SchoolResponse - contain all school related details
     */
    SchoolResponse createSchool(SchoolRegistrationRequest request);

    /**
     *
     * @return List of all school details
     */
    List<SchoolResponse> getAllSchools();

    /**
     *
     * @param id - Checking given ID is a registration completed or not
     * @return - SchoolResponse - contain all school details
     */
    SchoolResponse getSchoolById(Integer id);
}
