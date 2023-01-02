package com.example.childcareservice.controller;

import com.example.childcareservice.service.KakaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@Controller
@RequiredArgsConstructor
public class MainPageController {
    private final KakaoService kakaoService;
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainPage(){
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        if(request.getSession().getAttribute("token") != null){
            kakaoService.logoutKakao((String)request.getSession().getAttribute("token"));
            log.info("kakao logout");
        }
        request.getSession().invalidate();
        return "index";
    }



}
