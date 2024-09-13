package com.fatec.demo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.demo.entities.User;

@RestController
@RequestMapping("/api/user")
public class userController {

    //CRUD = Create Read Update Delete

    //create
    @PostMapping("path")
    public String postMethodName(@RequestBody User usuario){

        return entity;
        
    }
}