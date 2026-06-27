package com.quiz.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3001")
public class QuizController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/hello")
    public String sayHello() {
        return "Vanakkam da Mapla! Backend Work Aagudhu!";
    }
    
    @GetMapping("/questions/{subject}")
    public List<Map<String, Object>> getQuestions(@PathVariable String subject) {
        String sql = "SELECT id, subject, question_text as question, option1, option2, option3, option4, correct_answer as correctAnswer FROM questions WHERE subject = ? ORDER BY RAND() LIMIT 20";
        return jdbcTemplate.queryForList(sql, subject.toLowerCase());
    }
}