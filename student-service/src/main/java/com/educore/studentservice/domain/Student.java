package com.educore.studentservice.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer schoolId;
}
