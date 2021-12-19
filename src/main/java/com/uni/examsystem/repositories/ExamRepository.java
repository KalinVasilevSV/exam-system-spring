package com.uni.examsystem.repositories;

import com.uni.examsystem.models.entities.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExamRepository extends JpaRepository<ExamEntity,Long> {

    Optional<ExamEntity> findByExamName(String examname);
}
