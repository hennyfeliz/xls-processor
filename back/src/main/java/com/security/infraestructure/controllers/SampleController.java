package com.security.infraestructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sample")
public class SampleController {
    @GetMapping("/")
    public ResponseEntity<String> getAllCargos(){
        return new ResponseEntity<>("funciona", HttpStatus.OK);
    }

}
