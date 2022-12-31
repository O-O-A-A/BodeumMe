package com.example.childcareservice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class PostRequestDTO {
    private String postTitle;
    private String postContents;
    private String postWorkType;
    private String postCareer;
    private String postPayment;
    private String postAvailableRegion;
    private String postAvailableDays;
    private String postAvailableTime;

    @Builder
    public PostRequestDTO(String postTitle, String postContents, String postWorkType, String postCareer, String postPayment, String postAvailableRegion, String postAvailableDays, String postAvailableTime) {
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
