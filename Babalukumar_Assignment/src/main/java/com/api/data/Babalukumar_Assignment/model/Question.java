/**
 * @Copyright
 *
 * @author Babalu kumar
 * @since May 2023
 */
package com.api.data.Babalukumar_Assignment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * category pojo class, Lombok dependency used for getter setter and constructor
 * Hibernate(@Entity) used for communicate with mysql
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    private Long id;
    private String answer;
    private String question;
    private Long value;
    private String airdate;
    private String created_at;
    private String updated_at;
    private Long category_id;
    private Long game_id;
    private Long invalid_count;
    @Transient
    private Category category;
}
