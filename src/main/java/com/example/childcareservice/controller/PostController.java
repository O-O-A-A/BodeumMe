package com.example.childcareservice.controller;

import com.example.childcareservice.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.Arrays;

@Controller
@RequestMapping("/post/*")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    public void getList(Model model) {
        model.addAttribute("post", postService.getList());
    }

    @GetMapping("/sort")
    public String sort(String[] category, String budget, Model model){
        log.info("정렬 조건" + Arrays.toString(category));
        log.info("정렬 조건" + budget);

        model.addAttribute("sortPost", postService.getList(category));
        model.addAttribute("category", category);
        model.addAttribute("budget", budget);
        return "/post/list";
    }

}
