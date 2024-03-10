package com.question.QuestionService.Service;

import com.question.QuestionService.Model.Question;
import com.question.QuestionService.Repository.IQuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class QuestionService implements IQuestionService{

    @Autowired
    private IQuestionsRepository iQuestionsRepository;

    public QuestionService(IQuestionsRepository iQuestionsRepository) {
        this.iQuestionsRepository = iQuestionsRepository;
    }

    @Override
    public Question create(Question question) {
        return iQuestionsRepository.save(question);
    }

    @Override
    public List<Question> getAll() {
        return iQuestionsRepository.findAll();
    }

    @Override
    public Question getAQuestion(Long id) {
        return iQuestionsRepository.findById(id).orElseThrow(() -> new RuntimeException("Question Not Found"));
    }


    public List<Question> findQuestionsByQuizId(Long quizId) {
        return iQuestionsRepository.findByQuizId(quizId);
    }
}
