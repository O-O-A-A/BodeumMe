package com.example.childcareservice.controller;

import com.example.childcareservice.domain.MemberDTO;
import com.example.childcareservice.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/login/*")
public class LoginController {
    private final LoginService loginService;
    private final String loginMember = "loginMember";

    @GetMapping("/first")
    public String login(){
        return "login/loginFirst";
    }

    @PostMapping("/main")
    public String main(String email, String password, @RequestParam(value = "remember", required = false)Boolean checkbox, HttpServletRequest request){
        log.info("email : " + email);
        log.info("password : " + password);
        MemberDTO memberDTO = loginService.login(email, password);
        if(memberDTO==null){
            log.info("Login Failed!!!");
        }else{
            log.info("Login Success!!!");
            log.info("Number : " + memberDTO.getUserNumber());
            log.info("ID : " + memberDTO.getUserID());
            log.info("password : " + memberDTO.getUserPassword());
            log.info("SALT : " + memberDTO.getUserSalt());
            log.info("name : " + memberDTO.getUserName());
            log.info("address : " + memberDTO.getUserAddress());
            log.info("Gender : " + memberDTO.getUserGender());
            log.info("PhoneNumber : " + memberDTO.getUserPhoneNumber());
            log.info("E mail : " + memberDTO.getUserEmail());
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("MemberInfo", memberDTO);
        }
        if(checkbox == null){
            log.info("Don't remember me");
        }else{
            log.info("Please remember me");
            request.getSession().setMaxInactiveInterval(86400);
        }

        return "redirect:/login/main";

    }

    @GetMapping("/main")
    public String main(HttpSession httpSession){
        MemberDTO memberDTO = (MemberDTO) httpSession.getAttribute("MemberInfo");
        log.info("getMain");
        if(memberDTO == null){
            log.info("NO Session");
        }else{
            log.info("There is a Session");
            log.info("Number : " + memberDTO.getUserNumber());
            log.info("ID : " + memberDTO.getUserID());
            log.info("password : " + memberDTO.getUserPassword());
            log.info("SALT : " + memberDTO.getUserSalt());
            log.info("name : " + memberDTO.getUserName());
            log.info("address : " + memberDTO.getUserAddress());
            log.info("Gender : " + memberDTO.getUserGender());
            log.info("PhoneNumber : " + memberDTO.getUserPhoneNumber());
            log.info("E mail : " + memberDTO.getUserEmail());
        }

        return "index";
    }


}
