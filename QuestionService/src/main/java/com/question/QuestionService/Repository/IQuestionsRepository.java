package com.question.QuestionService.Repository;

import com.question.QuestionService.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IQuestionsRepository extends JpaRepository<Question,Long> {
    List<Question> findByQuizId(Long quizId);
}
