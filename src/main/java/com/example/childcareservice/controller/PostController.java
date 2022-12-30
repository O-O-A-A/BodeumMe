package com.example.childcareservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post/*")
public class PostController {

    @GetMapping("/list")
    public String getList() {
        return "/board/board";
    }
}
