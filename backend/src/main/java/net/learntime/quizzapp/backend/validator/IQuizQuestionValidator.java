package net.learntime.quizzapp.backend.validator;

import net.learntime.quizzapp.backend.model.entity.QuizEntity;
import net.learntime.quizzapp.backend.model.entity.QuizQuestionEntity;
import net.learntime.quizzapp.backend.model.request.QuizQuestionApiRequest;

public interface IQuizQuestionValidator {

    QuizQuestionEntity validate(QuizQuestionApiRequest request, QuizEntity quiz);

}
