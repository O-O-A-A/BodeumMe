package com.example.childcareservice.service;


import com.example.childcareservice.dto.PostRequestDTO;
import com.example.childcareservice.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("post") @Primary
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;

    @Override
    public List<PostRequestDTO> getList() {
        return postDAO.findAll();
    }

    @Override
    public List<PostRequestDTO> getList(String sort) {
        return postDAO.findAllByOrderBySort(sort);
    }
}
