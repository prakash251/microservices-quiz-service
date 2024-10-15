package com.microservicesom.quiz_service.Controller;

import com.microservicesom.quiz_service.Dao.QuestionWrapper;
import com.microservicesom.quiz_service.Dao.QuizDto;
import com.microservicesom.quiz_service.Dao.Response;
import com.microservicesom.quiz_service.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
   QuizService quizService;


//creating Quiz
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto)
    {
        return quizService.CreateQuiz(quizDto.getNumQ(),quizDto.getTitle());

    }

   //Get Quiz
    @GetMapping("getquiz/{id}")
   public ResponseEntity<List<QuestionWrapper>>getQuiz(@PathVariable Integer id)
   {
     return quizService.getQuiz(id);
   }

   //submitting Answers
    @PostMapping("submit/{id}")
    public  ResponseEntity<Integer> submitResponse(@PathVariable Integer id,@RequestBody List<Response> response){

      return  quizService.submitQuiz(id,response);

    }

}
