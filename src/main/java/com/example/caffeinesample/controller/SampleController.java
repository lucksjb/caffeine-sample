package com.example.caffeinesample.controller;

import javax.websocket.server.PathParam;

import com.example.caffeinesample.services.SampleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SampleController {
    @Autowired
    private SampleService sampleService;
    
    @GetMapping("/calculo1")
    public ResponseEntity<String> calculo1(@PathParam("a") int a) {
        return ResponseEntity.ok().body(sampleService.calculo1(a));
    }

    
    @GetMapping("/calculo2")
    public ResponseEntity<String> calculo2(@PathParam("a") int a) {
        return ResponseEntity.ok().body(sampleService.calculo2(a));
    }    
}
