package com.educore.identityservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_credential")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCredential {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String email;

    private String password;
}
