package com.example.childcareservice.repository;

import com.example.childcareservice.domain.MemberDTO;
import com.example.childcareservice.mapper.FAQMapper;
import com.example.childcareservice.mapper.LoginMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FAQDAO {
    private final FAQMapper faqMapper;
}
