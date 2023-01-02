package com.example.childcareservice.controller;

import com.example.childcareservice.domain.MemberDTO;
import com.example.childcareservice.service.KakaoService;
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
    private final KakaoService kakaoService;
    private final String loginMember = "loginMember";


    @PostMapping("main")
    @ResponseBody
    public String main(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("checkbox") Boolean checkBox, HttpServletRequest request){
        String re;

        MemberDTO memberDTO = loginService.login(email, password);

        if(memberDTO==null){
            re = "false";
        }else{
            re = "true";
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("MemberInfo", memberDTO);
            if(checkBox){
            }else{
                request.getSession().setMaxInactiveInterval(86400);
            }
        }

        return re;
    }

    @GetMapping("main")
    public String main(){
        return "index";
    }

}
