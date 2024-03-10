package com.quiz.QuizService.Service;

import com.quiz.QuizService.Model.Quiz;

import java.util.List;

public interface IQuizService {

    Quiz add(Quiz quiz);

    List<Quiz> get();

    Quiz get(Long id);
}
