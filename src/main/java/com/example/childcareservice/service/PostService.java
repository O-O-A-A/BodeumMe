package com.example.childcareservice.service;


import com.example.childcareservice.dto.PostRequestDTO;

import java.util.List;

public interface PostService {
    public List<PostRequestDTO> getList();
    public List<PostRequestDTO> getList(String sort);

}
