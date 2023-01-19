package com.developmate.demo.repository;

import com.developmate.demo.model.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentRepository extends MongoRepository<Document, String> {
    List<Document> findByType(String type);
    Optional<Document> findBy_id(String id);
}
