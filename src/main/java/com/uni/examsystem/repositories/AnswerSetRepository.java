package com.uni.examsystem.repositories;

import com.uni.examsystem.models.entities.AnswerSetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerSetRepository extends JpaRepository<AnswerSetEntity,Long> {
}
