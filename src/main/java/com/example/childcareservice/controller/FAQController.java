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

//    @GetMapping("/FAQ_view")
//    public String FAQViewPage(){ return "/FAQ/FAQ_view"; }

    @GetMapping("/FAQ_view00")
    public String FAQViewPage00(){ return "/FAQ/FAQ_view00"; }
    @GetMapping("/FAQ_view01")
    public String FAQViewPage01(){
        return "/FAQ/FAQ_view01";
    }
    @GetMapping("/FAQ_view02")
    public String FAQViewPage02(){
        return "/FAQ/FAQ_view02";
    }
    @GetMapping("/FAQ_view03")
    public String FAQViewPage03(){
        return "/FAQ/FAQ_view03";
    }
    @GetMapping("/FAQ_view04")
    public String FAQViewPage04(){
        return "/FAQ/FAQ_view04";
    }

}
