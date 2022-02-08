package com.loopy.AcquaintanceInformationManagementSystem.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class HelloworldControllerTest {

    @Autowired
    private HelloworldController helloworldController;

    private MockMvc mockMvc;

    @Test
    void helloWorld(){

        // 메소드를 호출하는 것이며 실행된 서버로 접근하여 http요청을 하는 것은 아니다.
        // -> 호출 형식이 다를경우에도 테스트 통과함. (경로가 다르거나, get을 post로 요청하는 경우 등등)
        assertThat(helloworldController.helloWorld()).isEqualTo("hello world");
    }

    @Test
    void mockMvcTest() throws Exception {

        mockMvc = MockMvcBuilders.standaloneSetup(helloworldController).build();
        mockMvc.perform(
                // http 요청을하여 테스트를 하기에 위의 테스트보다 완성도 높은 테스트 코드라할 수 있다.
                MockMvcRequestBuilders.get("/api/hello"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hello world"));
    }

}