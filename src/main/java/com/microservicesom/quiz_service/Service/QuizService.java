package com.microservicesom.quiz_service.Service;

import com.microservicesom.quiz_service.Dao.Question;
import com.microservicesom.quiz_service.Dao.QuestionWrapper;
import com.microservicesom.quiz_service.Dao.Quiz;
import com.microservicesom.quiz_service.Dao.Response;
import com.microservicesom.quiz_service.Repo.QuizRepo;
import com.microservicesom.quiz_service.feign.QuizInterface;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;
    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> CreateQuiz(Integer numQ, String title) {

       List<Integer> questions =quizInterface.generateQuestionsForQuiz(numQ).getBody();


           Quiz quiz=new Quiz();
           quiz.setQuizTitle(title);
           quiz.setQuestionIds(questions);
           quizRepo.save(quiz);

        return new ResponseEntity<>("creatd Quiz", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {

        Quiz quiz = quizRepo.findById(id).get();
        List<Integer> questionids = quiz.getQuestionIds();
        ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionids);

        return questions;

    }

    public ResponseEntity<Integer> submitQuiz(Integer id, List<Response> response) {


      ResponseEntity<Integer> score = quizInterface.submitResponse(response);

        return score;
    }
}
