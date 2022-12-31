package com.example.childcareservice.repository;

import com.example.childcareservice.domain.UserVO;
import com.example.childcareservice.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor/* 생성자 자동 생성 */
public class UserDAO {
    private final UserMapper userMapper;

    public void save(UserVO userVO){ userMapper.saveUser(userVO);};

}
