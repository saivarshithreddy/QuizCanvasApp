package net.learntime.quizzapp.backend.validator.impl;

import net.learntime.quizzapp.backend.model.entity.QuizPlayEntity;
import net.learntime.quizzapp.backend.model.request.QuizPlayApiRequest;
import net.learntime.quizzapp.backend.repository.IUserRepository;
import net.learntime.quizzapp.backend.validator.IQuizPlayValidator;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizPlayValidator implements IQuizPlayValidator {

    @Autowired
    private CommonValidator validator;
    
    @Autowired
    private QuizValidator quizValidator;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public QuizPlayEntity validate(QuizPlayApiRequest request) {
        var res = new QuizPlayEntity();
        res.setUser(userRepository.findByAccessToken(request.getToken()));
        res.setQuiz(quizValidator.validateId(request.getQuizId()));
        res.setCorrectQuestionsNumber(validator.validateMandatoryInteger(request.getCorrectQuestionsNumber(), "correctQuestionsNumber"));
        res.setPlayedAt(ZonedDateTime.now());
        return res;
    }

}
