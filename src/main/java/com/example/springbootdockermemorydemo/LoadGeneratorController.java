package com.example.springbootdockermemorydemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadGeneratorController {

    @GetMapping("/generate-load")
    public void generateLoad() {
        System.out.println("generate load triggered");
    }
}
