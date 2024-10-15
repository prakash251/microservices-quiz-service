package com.microservicesom.quiz_service.feign;


import com.microservicesom.quiz_service.Dao.QuestionWrapper;
import com.microservicesom.quiz_service.Dao.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("question-service")
public interface QuizInterface {

    //generate questions
    @GetMapping("questions/generate")
    public ResponseEntity<List<Integer>> generateQuestionsForQuiz(@RequestParam Integer numberOfQuestions);
//getQuestion by question id

    @PostMapping("questions/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);
//submit

    @PostMapping("questions/getscore")
    public ResponseEntity<Integer> submitResponse(@RequestBody List<Response> responses);

}
