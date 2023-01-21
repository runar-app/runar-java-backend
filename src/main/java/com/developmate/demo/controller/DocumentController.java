package com.developmate.demo.controller;

import com.developmate.demo.model.Document;
import com.developmate.demo.repository.DocumentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2")
public class DocumentController {
    private final DocumentRepository repository;
    public DocumentController(DocumentRepository repository) {
        this.repository = repository;
    }
    @GetMapping(value = "/", produces = "application/json")
    public List<Document> getRootMenu() {
        return repository.findByType("root").stream()
                .sorted(Comparator.comparing(Document::getSortOrder))
                .toList();
    }
    @GetMapping(value = "/{id}", produces = "application/json")
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