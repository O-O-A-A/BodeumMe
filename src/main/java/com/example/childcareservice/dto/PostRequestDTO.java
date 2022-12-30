package com.example.childcareservice.dto;

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


}
