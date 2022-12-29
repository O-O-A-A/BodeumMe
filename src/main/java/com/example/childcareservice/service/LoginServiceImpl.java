package com.example.childcareservice.service;

import com.example.childcareservice.domain.MemberDTO;
import com.example.childcareservice.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("login") @Primary
@Slf4j
public class LoginServiceImpl implements LoginService {
    private final MemberDAO memberDAO;
    @Override
    public MemberDTO login(String id, String password) {
        return memberDAO.login(id, password);
    }

    public String getTime(){
        return memberDAO.getTime();
    }
}
