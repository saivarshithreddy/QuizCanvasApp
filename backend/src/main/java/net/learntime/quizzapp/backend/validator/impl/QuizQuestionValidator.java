package net.learntime.quizzapp.backend.validator.impl;

import net.learntime.quizzapp.backend.model.entity.QuizEntity;
import net.learntime.quizzapp.backend.model.entity.QuizQuestionEntity;
import net.learntime.quizzapp.backend.model.request.QuizQuestionApiRequest;
import net.learntime.quizzapp.backend.validator.IQuizQuestionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static net.learntime.quizzapp.backend.model.entity.QuizQuestionEntity.OPTIONS_SEPARATOR;

@Service
public class QuizQuestionValidator implements IQuizQuestionValidator {

    @Autowired
    private CommonValidator commonValidator;

    @Override
    public QuizQuestionEntity validate(QuizQuestionApiRequest request, QuizEntity quiz) {
        var res = new QuizQuestionEntity();
        res.setQuiz(quiz);
        res.setQuestion(commonValidator.validateMandatoryString(request.getQuestion(), "question"));
        res.setAnswerIndex(commonValidator.validateMandatoryInteger(request.getAnswerIndex(), "answerIndex"));
        res.setOptions(commonValidator.validateMandatoryString(String.join(OPTIONS_SEPARATOR, request.getOptions()), "options"));
        return res;
    }

}
