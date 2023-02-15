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
                .hasSize(5)
                .extracting(Document::getType)
                .containsOnly("root");
    }

    @Test
    public void getSubMenusTest() {
        Assertions.assertThat(controller.getSubMenus("6063964d87bafbb125aefdf8").size())
                .isEqualTo(3);
        Assertions.assertThat(controller.getSubMenus("6063944687bafbb125aefdeb").size())
                .isEqualTo(25);
        Assertions.assertThat(controller.getSubMenus("6063944487bafbb125aefdde").size())
                .isEqualTo(9);
        Assertions.assertThat(controller.getSubMenus("6063966c87bafbb125aefdf9").size())
                .isEqualTo(3);
    }
}
