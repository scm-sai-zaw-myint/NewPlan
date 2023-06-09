package com.mtm.plan.web.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Write your web form here...
 * This is the main place where to make form for request and response.
 *
 * Note::Please do not use the business logic here!
 *
 * @author SaiZawMyint
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
    private Integer id;
    private String name;
    private String email;
    private String password;
}
