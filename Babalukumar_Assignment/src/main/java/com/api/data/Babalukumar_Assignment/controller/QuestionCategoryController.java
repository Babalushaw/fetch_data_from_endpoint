/**
 * @Copyright
 *
 * @author Babalu kumar
 * @since May 2023
 */
package com.api.data.Babalukumar_Assignment.controller;

import com.api.data.Babalukumar_Assignment.model.Payload;
import com.api.data.Babalukumar_Assignment.service.QuestionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class QuestionCategoryController {
    private Logger log= LoggerFactory.getLogger(QuestionCategoryController.class );
    @Autowired
    private QuestionService questionService;
    @GetMapping("/add")
    public ResponseEntity<Object> addQuestion() throws JsonProcessingException {
        log.info("fetc");
            return ResponseEntity.status(HttpStatus.OK).body(questionService.addQuestion());
    }
    @GetMapping("/play")
    public ResponseEntity<Object> playQuestion(){
        return ResponseEntity.status(HttpStatus.OK).body(questionService.play());
    }
    @PostMapping("/next")
    public ResponseEntity<Object> nextQuestion(@RequestBody Payload payload){
        return ResponseEntity.status(HttpStatus.OK).body(questionService.payload(payload));
    }

}
