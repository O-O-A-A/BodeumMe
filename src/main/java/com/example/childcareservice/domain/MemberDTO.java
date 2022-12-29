package com.example.childcareservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MemberDTO {
    private Long userNumber;
    private String userId;
    private String userPassword;

    public MemberDTO(String id, String password){
        this.userId = id;
        this.userPassword = password;
    }
}
