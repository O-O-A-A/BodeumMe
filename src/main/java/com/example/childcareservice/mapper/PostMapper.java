package com.example.childcareservice.mapper;

import com.example.childcareservice.dto.PostRequestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

    public List<PostRequestDTO> selectAll();
    public List<PostRequestDTO> sortAll(String[] sort);

}
