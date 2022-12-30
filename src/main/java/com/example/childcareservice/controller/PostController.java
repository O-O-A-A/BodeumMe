package com.example.childcareservice.controller;

import com.example.childcareservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post/*")
@RequiredArgsConstructor
public class PostController {

    PostService postService;

    @GetMapping("/list")
    public String getList(Model model) {
        model.addAttribute("post", postService.getList());
        return "/post/post";
    }


}
