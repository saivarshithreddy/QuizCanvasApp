package net.learntime.quizzapp.backend.validator.impl;

import net.learntime.quizzapp.backend.exception.QuizNotFoundException;
import net.learntime.quizzapp.backend.model.entity.QuizEntity;
import net.learntime.quizzapp.backend.model.request.QuizApiRequest;
import net.learntime.quizzapp.backend.repository.IQuizRepository;
import net.learntime.quizzapp.backend.validator.IQuizValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static net.learntime.quizzapp.backend.model.entity.QuizEntity.*;

@Service
public class QuizValidator implements IQuizValidator {

    @Autowired
    private IQuizRepository repository;

    @Autowired
    private CommonValidator commonValidator;

    @Autowired
    private QuizQuestionValidator questionValidator;

    @Override
    public QuizEntity validateId(String id) {
        return repository.findById(commonValidator.validateMandatoryUUID(id)).orElseThrow(() -> new QuizNotFoundException(id));
    }

    @Override
    public QuizEntity validate(QuizApiRequest request) {
        var res = new QuizEntity();
        res.setTitle(commonValidator.validateMandatoryString(request.getTitle(), "title"));
        res.setDescription(commonValidator.validateMandatoryString(request.getDescription(), "description"));
        res.setThumbnail(commonValidator.validateMandatoryString(request.getThumbnail(), "thumbnail"));
        res.setTags(commonValidator.validateMandatoryString(String.join(TAGS_SEPARATOR, request.getTags()), "tags"));
        res.setQuestions(request.getQuestions().stream().map(question -> questionValidator.validate(question, res)).toList());
        return res;
    }

}
