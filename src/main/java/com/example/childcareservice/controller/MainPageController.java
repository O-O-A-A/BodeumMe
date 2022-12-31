package com.example.childcareservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Slf4j
@Controller
@RequiredArgsConstructor
public class MainPageController {
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainPage(){
        return "babysitter";
    }
}
