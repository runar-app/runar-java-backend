package com.developmate.demo.controller;

import com.developmate.demo.model.Document;
import com.developmate.demo.repository.DocRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
public class DocController {
    private final DocRepository repository;
    public DocController(DocRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/menu")
    public List<Document> getRootMenu() {
        return repository.findByType("root").stream()
                .sorted(Comparator.comparing(Document::getSortOrder))
                .toList();
    }
    @GetMapping("/menu/{id}")
    public List<Document> getSubMenus(@PathVariable("id") String id) {
        Optional<Document> documents = repository.findBy_id(id);
        return documents.map(value -> value.getChildIds().stream()
                .map(repository::findBy_id)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .sorted(Comparator.comparing(Document::getSortOrder))
                .toList()).orElseGet(ArrayList::new);
    }

}
