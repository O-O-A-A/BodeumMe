package com.example.childcareservice.mapper;

import com.example.childcareservice.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;


/* 유저 정보를 DB에 저장하기 위한 Mapper 인터페이스 구현 */
@Mapper
public interface UserMapper {
    public void saveUser(UserVO userVO);
}

