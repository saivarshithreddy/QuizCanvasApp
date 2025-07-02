package net.learntime.quizzapp.backend.validator;

import net.learntime.quizzapp.backend.model.entity.QuizPlayEntity;
import net.learntime.quizzapp.backend.model.request.QuizPlayApiRequest;


public interface IQuizPlayValidator {

    QuizPlayEntity validate(QuizPlayApiRequest request);

}
