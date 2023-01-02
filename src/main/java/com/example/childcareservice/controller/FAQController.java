package com.example.childcareservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/FAQ/*")
@Controller
@RequiredArgsConstructor
public class FAQController {
    @GetMapping("/FAQ_list")
    public String FAQListPage(){
        return "/FAQ/FAQ_list";
    }

}