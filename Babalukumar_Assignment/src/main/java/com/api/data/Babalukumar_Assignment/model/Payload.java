/**
 * @Copyright
 *
 * @author Babalu kumar
 * @since May 2023
 */
package com.api.data.Babalukumar_Assignment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * It is written for to get payload request body
 * category pojo class, Lombok dependency used for getter setter and constructor
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payload {
    private Long question_id;
    private String answer;
}
