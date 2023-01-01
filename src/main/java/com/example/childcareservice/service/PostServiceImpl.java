package com.example.childcareservice.service;


import com.example.childcareservice.dto.PostRequestDTO;
import com.example.childcareservice.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;

    @Override
    public List<PostRequestDTO> getList() {
        return postDAO.findAll();
    }

    @Override
    public List<PostRequestDTO> getList(String[] sort) {
//        log.info("정렬 조건" + Arrays.toString(sort));
        return postDAO.findAllByOrderBySort(sort);
    }
}
