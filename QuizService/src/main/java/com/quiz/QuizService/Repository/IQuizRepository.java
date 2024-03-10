package com.quiz.QuizService.Repository;

import com.quiz.QuizService.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuizRepository extends JpaRepository<Quiz,Long> {
}
