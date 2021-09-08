package com.group4.twitter.Controllers;

import com.group4.twitter.Entities.User;
import com.group4.twitter.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public String profilePage(){
        return "This is your twitter profile page";
    }
    @PostMapping("/user/addUser")
    public String addUser(@RequestBody User user){
        userService.addUser(user);
        return "redirect:/login";
    }
    @RequestMapping(name="/user/update", method = RequestMethod.PUT)
    public String updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    @RequestMapping("/user/all")
    public List<User> showAll(){
        return userService.findAllUsers();
    }
    @RequestMapping("/user/find")
    public User findUser(@RequestParam("id") int id){
        return userService.findUser(id);
    }
}
