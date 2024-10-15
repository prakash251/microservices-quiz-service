package com.microservicesom.quiz_service.Dao;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String QuizTitle;
    @ElementCollection
    private List<Integer> questionIds;
}
