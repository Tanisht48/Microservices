package com.quiz.QuizService.Controller;

import com.quiz.QuizService.Model.Quiz;
import com.quiz.QuizService.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {


    @Autowired
    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    @PostMapping
    public Quiz create(@RequestBody Quiz quiz)
    {
        return quizService.add(quiz);
    }

    @GetMapping
    public List<Quiz> getALLQuiz(){
        return quizService.get();
    }

    @GetMapping("/{id}")
    public Quiz getAQuiz(@PathVariable Long id){
        return quizService.get(id);
    }
}
