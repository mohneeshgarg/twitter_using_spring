package com.group4.twitter.Controllers;

import com.group4.twitter.DAO.UserDAO;
import com.group4.twitter.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/")
    public ModelAndView openHome(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView mv = new ModelAndView("home");
        boolean flag = false;

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            flag = true;
            String username = ((UserDetails)auth.getPrincipal()).getUsername();
            User user = userDAO.findByUserName(username);
            mv.addObject("id", user.getId());
        }
        mv.addObject("flag",  flag);
        return mv;
    }
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
}
