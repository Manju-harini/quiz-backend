package com.quiz.backend;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class QuizService {

    public List<Map<String, Object>> getQuestionsBySubject(String subject) {
        
        List<Map<String, Object>> questions = new ArrayList<>();
        
        if(subject.equals("java")) {
            questions.add(createQuestion(
                "What happens if equals() is overridden but hashCode() is not overridden?",
                Arrays.asList("Compilation Error", "Objects may behave incorrectly in HashMap", "Runtime Exception", "No Impact"),
                "Objects may behave incorrectly in HashMap"
            ));
            questions.add(createQuestion(
                "Which garbage collector is designed for low pause times in large heap applications?",
                Arrays.asList("Serial GC", "Parallel GC", "G1 GC", "Epsilon GC"),
                "G1 GC"
            ));
            questions.add(createQuestion(
                "Which interface must be implemented to define natural ordering?",
                Arrays.asList("Comparator", "Comparable", "Serializable", "Cloneable"),
                "Comparable"
            ));
            questions.add(createQuestion(
                "What is the default value of an object reference instance variable?",
                Arrays.asList("0", "undefined", "null", "false"),
                "null"
            ));
            questions.add(createQuestion(
                "Which collection is thread-safe by default?",
                Arrays.asList("ArrayList", "HashSet", "Vector", "LinkedList"),
                "Vector"
            ));
            // Midha 15 questions ah neeye add panniko da
            return questions;
        }
        
        if(subject.equals("python")) {
            questions.add(createQuestion(
                "What is the output of print(type([]))?",
                Arrays.asList("<class 'list'>", "<class 'tuple'>", "<class 'dict'>", "list"),
                "<class 'list'>"
            ));
            return questions;
        }
        
        if(subject.equals("react")) {
            questions.add(createQuestion(
                "What hook is used for state in functional components?",
                Arrays.asList("useEffect", "useState", "useContext", "useReducer"),
                "useState"
            ));
            return questions;
        }
        
        return questions;
    }
    
    private Map<String, Object> createQuestion(String question, List<String> options, String answer) {
        Map<String, Object> q = new HashMap<>();
        q.put("question", question);
        q.put("options", options);
        q.put("answer", answer);
        return q;
    }
}