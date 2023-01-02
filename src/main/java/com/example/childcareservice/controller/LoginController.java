package com.example.childcareservice.controller;

import com.example.childcareservice.domain.MemberDTO;
import com.example.childcareservice.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/login/*")
public class LoginController {
    private final LoginService loginService;
    private final String loginMember = "loginMember";


    @PostMapping("main")
    @ResponseBody
    public String main(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("checkbox") Boolean checkBox, HttpServletRequest request){
        String re;
        log.info("now Controller");
        log.info("email : " + email);
        log.info("password : " + password);
        log.info("checkbox : " + checkBox);

        MemberDTO memberDTO = loginService.login(email, password);

        if(memberDTO==null){
            re = "false";
        }else{
            /*log.info("Login Success!!!");
            log.info("Number : " + memberDTO.getUserNumber());
            log.info("ID : " + memberDTO.getUserID());
            log.info("password : " + memberDTO.getUserPassword());
            log.info("SALT : " + memberDTO.getUserSalt());
            log.info("name : " + memberDTO.getUserName());
            log.info("address : " + memberDTO.getUserAddress());
            log.info("Gender : " + memberDTO.getUserGender());
            log.info("PhoneNumber : " + memberDTO.getUserPhoneNumber());
            log.info("E mail : " + memberDTO.getUserEmail());*/
            re = "true";
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("MemberInfo", memberDTO);
            if(checkBox){
                log.info("Don't remember me");
            }else{
                log.info("Please remember me");
                request.getSession().setMaxInactiveInterval(86400);
            }
        }

        return re;
    }

    @GetMapping("main")
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
