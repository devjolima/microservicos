package com.forcode.e4y.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/rest")
public class InitController {

    @GetMapping
    public ResponseEntity actuator(){
        return new ResponseEntity(HttpStatus.OK).ok().body("Running ...");
    }
}
