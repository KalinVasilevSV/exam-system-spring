package com.uni.examsystem.repositories;

import com.uni.examsystem.models.entities.ScoreCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreCardRepository extends JpaRepository<ScoreCardEntity,Long> {
}
