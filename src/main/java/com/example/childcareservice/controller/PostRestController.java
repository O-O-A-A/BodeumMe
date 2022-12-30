package com.example.childcareservice.controller;

import com.example.childcareservice.dto.PostRequestDTO;
import com.example.childcareservice.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PostRestController {

    PostService postService;

    @GetMapping("/post/sort")
    public List<PostRequestDTO> sort(@RequestParam("sort") String sort){
        return postService.getList(sort);
    }

}
