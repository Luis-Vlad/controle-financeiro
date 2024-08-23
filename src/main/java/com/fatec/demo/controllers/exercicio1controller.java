package com.fatec.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;





//ENDEREÇO DO ENDPOINT

//http://localhost:8090/api/exercicio1
@RestController
@RequestMapping("/api/exercicio1")
public class exercicio1controller {
    

    @GetMapping("hello1")
    public String helloWorld() {
        return "hello1";
    }
    
    


}
