package com.example.childcareservice.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserVO {
    private long userNumber;
    private String userID;
    private String userPassword;
    private String userName;
    private String userAddress;
    private String userGender;
    private String userPhoneNumber;
    private String userEmail;
    private String userRole; /* 질문 */
    private String userRegistDate;
    private String userUpdateDate;
    private String profileImageName; /* 질문 */
    private String profileImagePath; /* 질문 */
}

