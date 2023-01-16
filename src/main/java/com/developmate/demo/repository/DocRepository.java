package com.developmate.demo.repository;

import com.developmate.demo.model.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface DocRepository extends MongoRepository<Document, String> {
    List<Document> findByType(String type);
    Optional<Document> findBy_id(String id);
}
