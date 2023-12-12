package com.atharvapuranik.zenquest.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class welcomeController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String welcomePage(ModelMap modelMap){
        modelMap.put("name", getLoggedInUser());
        return "welcome";
    }

    private String getLoggedInUser(){
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        return loggedInUser.getName();
    }

}
