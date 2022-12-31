package com.example.childcareservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@NoArgsConstructor
public class PostVO {
    private Integer postNumber;
    private Integer userNumber;
    private Boolean userRole;
    private String postTitle;
    private String postContents;
    private String postWorkType;
    private String postCareer;
    private String postPayment;
    private String postAvailableRegion;
    private String postAvailableDays;
    private String postAvailableTime;
    private String postUploadDate;
    private String postUpdateDate;

    @Builder
    public PostVO(String postTitle, String postContents, String postWorkType, String postCareer, String postPayment, String postAvailableRegion, String postAvailableDays, String postAvailableTime) {
        this.postTitle = postTitle;
        this.postContents = postContents;
        this.postWorkType = postWorkType;
        this.postCareer = postCareer;
        this.postPayment = postPayment;
        this.postAvailableRegion = postAvailableRegion;
        this.postAvailableDays = postAvailableDays;
        this.postAvailableTime = postAvailableTime;
    }
}
