/**
 * @Copyright
 *
 * @author Babalu kumar
 * @since May 2023
 */
package com.api.data.Babalukumar_Assignment.service;

import com.api.data.Babalukumar_Assignment.model.Payload;
import org.springframework.stereotype.Service;
/**
 * Only method written here, implementation written in QuestionServiceImpl class
 */
@Service
public interface QuestionService {
    Object addQuestion();

    Object play();

    Object payload(Payload payload);
}
