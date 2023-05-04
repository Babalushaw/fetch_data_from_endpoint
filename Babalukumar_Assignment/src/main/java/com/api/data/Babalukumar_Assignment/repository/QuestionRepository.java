/**
 * @Copyright
 *
 * @author Babalu kumar
 * @since May 2023
 */
package com.api.data.Babalukumar_Assignment.repository;

import com.api.data.Babalukumar_Assignment.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * this interface makes bridge between application and database
 */
public interface QuestionRepository extends JpaRepository<Question,Long> {
}
