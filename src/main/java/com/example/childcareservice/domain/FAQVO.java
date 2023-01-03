package com.example.childcareservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class FAQVO {
    private Integer faqNumber;
    private String faqTitle;
    private String faqContents;

    @Builder
    public FAQVO(String faqTitle, String faqContents) {
        this.faqTitle = faqTitle;
        this.faqContents = faqContents;
    }
}
