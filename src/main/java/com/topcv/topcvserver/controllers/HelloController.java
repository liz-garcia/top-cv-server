package com.topcv.topcvserver.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    @GetMapping("/hello")
    public String greeting() {
        return "Hello, World!";
    }

    @GetMapping("/secured")
    public String secured() {
        return "If you see this, then you are logged in.";
    }
}
