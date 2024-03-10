package com.question.QuestionService.Controller;

import com.question.QuestionService.Model.Question;
import com.question.QuestionService.Service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {



    private final QuestionService questionService;
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public Question create(@RequestBody Question question){
        return questionService.create(question);
    }

    @GetMapping
    public List<Question> getAllQuestions(){
        return questionService.getAll();
    }

    @GetMapping("/{id}")
    public Question getAQuestion(@PathVariable Long id){
        return  questionService.getAQuestion(id);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> findQuestionsByQuizId(@PathVariable Long quizId)
    {
        return  questionService.findQuestionsByQuizId(quizId);
    }



}
