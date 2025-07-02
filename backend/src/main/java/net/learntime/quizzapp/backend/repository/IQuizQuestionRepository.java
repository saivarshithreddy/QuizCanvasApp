package net.learntime.quizzapp.backend.repository;

import net.learntime.quizzapp.backend.model.entity.QuizQuestionEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IQuizQuestionRepository extends JpaRepository<QuizQuestionEntity, UUID> {

}
