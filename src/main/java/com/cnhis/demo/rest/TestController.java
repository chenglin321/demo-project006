package com.cnhis.demo.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping({"/test"})
    public String test() {
        return "";
    }
}
