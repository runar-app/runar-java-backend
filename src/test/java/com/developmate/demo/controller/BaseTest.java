package com.developmate.demo.controller;

import com.developmate.demo.model.Document;
import com.developmate.demo.repository.DocumentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BaseTest {

    @Autowired
    private DocumentController controller;

    @Autowired
    private DocumentRepository repository;

    @BeforeEach
    public void beforeEach() {
        List<Document> documents = new ArrayList<>();
        Document document2 = new Document();
        document2.set_id("2");
        document2.setSortOrder(2L);
        document2.setType("root");
        documents.add(document2);
        Document document3 = new Document();
        document3.set_id("3");
        document3.setSortOrder(3L);
        document3.setType("root");
        documents.add(document3);
        Document document4 = new Document();
        document4.set_id("4");
        document4.setSortOrder(4L);
        document4.setType("text");
        documents.add(document4);
        Document document5 = new Document();
        document5.set_id("5");
        document5.setSortOrder(5L);
        document5.setType("text");
        documents.add(document5);
        Document document1 = new Document();
        document1.set_id("1");
        document1.setSortOrder(1L);
        document1.setType("root");
        document1.setChildIds(List.of("3", "4"));
        documents.add(document1);

        repository.saveAll(documents);
        System.out.println("Before each test.");
    }

    @Test
    public void getRootMenuTest() {
        Assertions.assertThat(controller.getRootMenu())
                .hasSize(3)
                .extracting(Document::getType)
                .containsOnly("root");
        System.out.println("Test completed!");
    }

    @AfterEach
    public void afterEach() {
        repository.deleteAll();
        System.out.println("After each test.");
    }
}
