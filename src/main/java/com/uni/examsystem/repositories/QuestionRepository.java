package com.uni.examsystem.repositories;

import com.uni.examsystem.models.entities.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.authentication.jaas.JaasPasswordCallbackHandler;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity,Long> {
    @Query(value = "SELECT * FROM QUESTIONS",nativeQuery = true)
    public Optional<Set<QuestionEntity>> getAll();
}
