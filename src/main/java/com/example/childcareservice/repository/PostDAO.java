package com.example.childcareservice.repository;

import com.example.childcareservice.dto.PostRequestDTO;
import com.example.childcareservice.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;

    public List<PostRequestDTO>findAll(){return postMapper.selectAll();}
    public List<PostRequestDTO>findAllByCategory(String[] category){return postMapper.selectAllByCategory(category);}
    public List<PostRequestDTO>findAllByBudget(String budget){return postMapper.selectAllByBudget(budget);}
    public List<PostRequestDTO>findAllByCategoryBudget(HashMap<String, Object> category){return postMapper.selectAllByCategoryBudget(category);}

}
