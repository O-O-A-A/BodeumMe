package com.example.childcareservice.mapper;

import com.example.childcareservice.domain.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
    public MemberDTO select(@Param("id") String id, @Param("password") String password);
    public String getTime();
}
