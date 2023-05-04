/**
 * @Copyright
 *
 * @author Babalu kumar
 * @since May 2023
 */
package com.api.data.Babalukumar_Assignment.repository;

import com.api.data.Babalukumar_Assignment.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * this interface makes bridge between application and database
 */
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
