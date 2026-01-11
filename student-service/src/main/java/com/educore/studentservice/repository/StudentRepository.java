package com.educore.studentservice.repository;

import com.educore.studentservice.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    boolean existsByEmail(String email);
    List<StudentEntity> findAllBySchoolId(Integer schoolId);
}
