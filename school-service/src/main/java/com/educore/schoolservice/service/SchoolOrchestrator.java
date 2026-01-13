package com.educore.schoolservice.service;

import com.educore.schoolservice.dto.SchoolResponse;

import java.util.List;

public interface SchoolOrchestrator {
    /**
     *
     * @return List of all school details
     */
    List<SchoolResponse> getAllSchools();
}
