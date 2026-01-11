package com.educore.schoolservice.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class School {
    private Integer schoolId;
    private String schoolName;
    private String email;
    private String principalName;
}
