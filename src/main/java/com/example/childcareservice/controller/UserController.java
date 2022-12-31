package com.example.childcareservice.controller;

import com.example.childcareservice.domain.UserVO;
import com.example.childcareservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/join")
    public String goJoinSelect(){
        return "/signup/signupfirst";
    }

    @GetMapping("/join1")
    public String goJoinForm1(){
        return "/signup/signupsecond";
    }

    @GetMapping("/join2")
    public String goJoinForm2(@ModelAttribute("userRole") String userRole){
        return "/signup/signupthird";
    }

    @PostMapping("/join2")
    public RedirectView join(UserVO userVO){
        userService.register(userVO);
        return new RedirectView("/user/join");
    }
}
