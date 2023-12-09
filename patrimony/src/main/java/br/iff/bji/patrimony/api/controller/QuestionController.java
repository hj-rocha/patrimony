package br.iff.bji.patrimony.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.iff.bji.patrimony.api.entity.Question;
import br.iff.bji.patrimony.api.service.QuestionService;

@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "infoQ", method = RequestMethod.GET)
    public String info(){
        return "The application is up...";
    }

    @RequestMapping(value = "createquestion", method = RequestMethod.POST)
    public String createQuestion(@RequestBody Question question){
        return questionService.createQuestion(question);
    }

    @RequestMapping(value = "readquestions", method = RequestMethod.GET)
    public List<Question> readQuestions(){
        return questionService.readQuestions();
    }

    @RequestMapping(value = "updatequestion", method = RequestMethod.PUT)
    public String updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }

    @RequestMapping(value = "deletequestion", method = RequestMethod.DELETE)
    public String deleteQuestion(@RequestBody Question question){
        return questionService.deleteQuestion(question);
    }
}
