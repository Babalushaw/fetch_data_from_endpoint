/**
 * @Copyright
 *
 * @author Babalu kumar
 * @since May 2023
 */


package com.api.data.Babalukumar_Assignment.serviceImpl;

import com.api.data.Babalukumar_Assignment.model.Payload;
import com.api.data.Babalukumar_Assignment.model.PlayResponse;
import com.api.data.Babalukumar_Assignment.model.Question;
import com.api.data.Babalukumar_Assignment.model.Response;
import com.api.data.Babalukumar_Assignment.repository.CategoryRepository;
import com.api.data.Babalukumar_Assignment.repository.QuestionRepository;
import com.api.data.Babalukumar_Assignment.service.QuestionService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of QuestionService class method
 */
@Repository
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Object addQuestion() {
        try{
            Question question=getQuestion();
            if(question==null){
                return "Question not present tap next";
            }
            if(questionRepository.existsById(question.getId())){
                return "Already visited";
            }
            questionRepository.save(question);
            categoryRepository.save(question.getCategory());

            return ResponseEntity.status(HttpStatus.OK).body(question);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please try after some time");
        }
    }

    @Override
    public Object play() {
        List<PlayResponse> playResponsesList=new ArrayList<>();
        try{
          questionRepository.findAll().stream().forEach(i->{
              PlayResponse playResponse=new PlayResponse();
              playResponse.setQuestion(i.getQuestion());
              playResponse.setQuestion_id(i.getId());
              playResponsesList.add(playResponse);
          });
          return playResponsesList;
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please try after some time");
        }
    }



    @Override
    public Object payload(Payload payload) {
        try{
           Question question=getQuestion();
           if(question==null){
               return "Question not present tap next";
           }
           Response response=new Response();
           response.setQuestion(question.getQuestion());
           response.setQuestion_id(question.getId());
           return response;
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please try after some time");
        }
    }
    public Question getQuestion(){
       try{
           String uri="https://jservice.io/api/random";
           RestTemplate restTemplate=new RestTemplate();
           String stringResponse=restTemplate.getForObject(uri, String.class);
           ObjectMapper objectMapper = new ObjectMapper();
           String response=objectMapper.writeValueAsString(stringResponse);
           List<Question> questionList=objectMapper.readValue(stringResponse,new TypeReference<List<Question>>(){});
           if(questionList.size()==0){
               return null;
           }
           return questionList.get(0);

       }catch (Exception e){
           return null;
       }
    }
}
