package com.mtm.plan.web.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Write your web form here...<br>
 * This is the main place where to make form for request and response.
 ** <br>
 * <pre style='color: orange;'>Note::Please do not use the business logic here!</pre>
 *
 * @author SaiZawMyint
 */
@Controller
public class AuthController {

    @GetMapping("/login")
    public ModelAndView LoginPage(Authentication auth) {
        String page = auth == null ? "guestLogin":"redirect:/";
        ModelAndView model = new ModelAndView(page);
        return model;
    }

}
