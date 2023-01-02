package com.example.childcareservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AccountFoundController {
    @GetMapping("/loginFind")
    public String loginFind(){
        return "/login/loginFind";
    }

//    @PostMapping("/loginFind")
//    public String loginFind(){
//        return "/login/loginFind";
//    }

}
