package com.example.childcareservice.repository;

import com.example.childcareservice.domain.MemberDTO;
import com.example.childcareservice.mapper.LoginMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final LoginMapper loginMapper;
    public MemberDTO login(String id, String password) {
        return loginMapper.select(id, password);
    }
    public  String getTime(){
        return loginMapper.getTime();
    }
}
