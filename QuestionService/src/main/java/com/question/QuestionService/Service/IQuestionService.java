package com.question.QuestionService.Service;

import com.question.QuestionService.Model.Question;

import java.util.List;

public interface IQuestionService {
    Question create(Question quiz);

    List<Question> getAll();

    Question getAQuestion(Long id);



}
