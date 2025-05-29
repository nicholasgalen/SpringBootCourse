package com.ng.aula.controllers;

import com.ng.aula.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/users")
public class UserController {
    @RequestMapping("/{userName}/{age}")
    public User user(
        @PathVariable("userName") String userName,
        @PathVariable("age") String age
    ) throws Exception{
        if (userName.isEmpty() || age.isEmpty()) throw new Exception();
        return new User(userName, age);
    }
}
