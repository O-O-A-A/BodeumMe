package com.example.childcareservice.service;

import com.example.childcareservice.domain.UserVO;
import com.example.childcareservice.repository.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServicempl implements UserService {

    private final UserDAO userDAO;

    @Override
    public void register(UserVO userVO) {
        userDAO.save(userVO);
    }
}
