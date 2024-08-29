package com.demo.quizzapp.controller;

import com.demo.quizzapp.model.Question;
import com.demo.quizzapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity <List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("category/{category}")
    public ResponseEntity <List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question, @PathVariable Integer id){
        question.setId(id);
        return questionService.updateQuestion(question);
    }

    @DeleteMapping("delete/{id}")
    public void deleteQuestion(@PathVariable Integer id){
        questionService.deleteQuestion(id);
    }




}
