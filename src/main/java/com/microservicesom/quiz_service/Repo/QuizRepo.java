package com.microservicesom.quiz_service.Repo;
import com.microservicesom.quiz_service.Dao.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Integer> {

}
