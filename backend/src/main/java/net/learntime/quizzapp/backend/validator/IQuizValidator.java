package net.learntime.quizzapp.backend.validator;

import net.learntime.quizzapp.backend.model.entity.QuizEntity;
import net.learntime.quizzapp.backend.model.request.QuizApiRequest;

public interface IQuizValidator {

    QuizEntity validateId(String id);

    QuizEntity validate(QuizApiRequest request);

}
