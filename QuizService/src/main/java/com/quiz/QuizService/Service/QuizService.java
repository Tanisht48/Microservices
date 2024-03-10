package com.quiz.QuizService.Service;

import com.quiz.QuizService.Model.Question;
import com.quiz.QuizService.Model.Quiz;
import com.quiz.QuizService.Repository.IQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService implements IQuizService{

    private IQuizRepository iQuizRepository;
    private QuestionClient questionClient;
    public QuizService(IQuizRepository iQuizRepository ,QuestionClient questionClient ) {
        this.questionClient = questionClient;
        this.iQuizRepository = iQuizRepository;
    }


    @Override
    public Quiz add(Quiz quiz) {
        return iQuizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes = iQuizRepository.findAll();

        return quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz =  iQuizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz Not Found"));

        List<Question> questions = questionClient.getQuestionOfQuiz(quiz.getId());

        quiz.setQuestions(questions);

        return quiz;
    }
}
