package com.developmate.demo.controller;

import com.developmate.demo.model.Document;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:applicationTest.properties")
public class ControllerTest {

    @Autowired
    private DocumentController controller;

    @Test
    public void getRootMenuTest() {
        Assertions.assertThat(controller.getRootMenu())
                .extracting(Document::getType)
                .containsOnly("root");
    }
}
