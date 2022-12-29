package com.example.childcareservice.controller;

import com.example.childcareservice.domain.MemberDTO;
import com.example.childcareservice.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/login/*")
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/first")
    public String login(){
        return "login/loginFirst";
    }

    @PostMapping("main")
    public String main(String email, String password){
        log.info("email : " + email);
        log.info("password : " + password);
        MemberDTO memberDTO = loginService.login(email, password);
        if(memberDTO==null){
            log.info("Login Failed!!!");
        }else{
            log.info("Login Success!!!");
        }
        return "babysitter";
    }

    @GetMapping("main")
    public String main(){
        log.info("getMain");
        return "babysitter";
    }


}
