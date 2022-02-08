package com.loopy.AcquaintanceInformationManagementSystem.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class HelloworldControllerTest {

    @Autowired
    private HelloworldController helloworldController;

    @Test
    void helloWorld(){

        assertThat(helloworldController.helloWorld()).isEqualTo("hello world");
    }

}