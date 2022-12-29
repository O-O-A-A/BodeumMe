package com.example.childcareservice.service;

import com.example.childcareservice.domain.MemberDTO;

public interface LoginService {
    public MemberDTO login(String id, String password);
    public String getTime();
}
