package com.example.childcareservice.postTest;

import com.example.childcareservice.domain.PostVO;
import com.example.childcareservice.dto.PostRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class postTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUP(){
        mockMvc = MockMvcBuilders.webAppContextSetup((webApplicationContext)).build();
    }

    @Test
    public void getListTest() throws Exception{
        assertThat(((List<PostRequestDTO>)mockMvc.perform(MockMvcRequestBuilders.get("/post/list"))
                .andReturn().getModelAndView().getModelMap().get("post")).get(0).getPostTitle()).isEqualTo("구인");
    }

    @Test
    public void getListByCategoryBudgetTest() throws Exception{
//        assertThat(((List<PostRequestDTO>)mockMvc.perform(MockMvcRequestBuilders.get("/post/sort?budget=10000"))
//                .andReturn().getModelAndView().getModelMap().get("post")).size()).isEqualTo(0);

//        assertThat(((List<PostRequestDTO>)mockMvc.perform(MockMvcRequestBuilders.get("/post/sort?category=가사,가사22&budget=10000"))
//                .andReturn().getModelAndView().getModelMap().get("post")).size()).isEqualTo(0);

        assertThat(((List<PostRequestDTO>)mockMvc.perform(MockMvcRequestBuilders.get("/post/sort?category=가사,가사22&budget=10000"))
                .andReturn().getModelAndView().getModelMap().get("post")).size()).isEqualTo(0);

    }
}
