package com.example.childcareservice.service;


import com.example.childcareservice.dto.PostRequestDTO;
import com.example.childcareservice.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
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
    public List<PostRequestDTO> getList(String[] category, String budget) {
        log.info("category 길이 : " + category.length);
        log.info("정렬 조건 " + Arrays.toString(category) + " , " + budget);
//        return   postDAO.findAllByCategory(category);
        boolean length = category.length == 0;
        if (length) {
            return postDAO.findAllByBudget(budget);
        }
        HashMap<String, Object> categories = new HashMap<>();
        categories.put("category", category);
        categories.put("budget", budget);
        return postDAO.findAllByCategoryBudget(categories);
    }
}
