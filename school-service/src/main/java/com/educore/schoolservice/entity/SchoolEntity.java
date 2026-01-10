package com.educore.schoolservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "schools")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SchoolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer schoolId;

    @Column(name = "name", nullable = false)
    private String schoolName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "principal_name")
    private String principalName;

}
