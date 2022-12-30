package com.example.childcareservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor

public class UserVO {
    private Integer userNumber;
    private String userId;
    private String userPassword;
    private String userName;
    private String userAddress;
    private String userGender;
    private String userPhoneNumber;
    private String userEmail;
    private Boolean userRole;
    private String userRegistDate;
    private String userUpdateDate;
}
