package com.project.comment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

@Controller
public class Controller {

    @GetMapping("/test")
    public String comment() {
        return "test/CommentTest";
    }
}
