package com.example.childcareservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MemberDTO {
    private long userNumber;
    private String userID;
    private String userPassword;
    private String userName;
    private String userSalt;
    private String userAddress;
    private String userGender;
    private String userPhoneNumber;
    private String userEmail;
    private String userRole;
    private String userRegistDate;
    private String userUpdateDate;
    private String profileImageName;
    private String profileImagePath;

    public MemberDTO(String id, String pw){
        this.userID = id;
        this.userPassword = pw;
    }
}
