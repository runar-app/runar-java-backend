package com.developmate.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@org.springframework.data.mongodb.core.mapping.Document (collection = "library_ru_notes")
@Data
@Getter
@Setter
@NoArgsConstructor
public class Document {
    @Id
    private String _id;
    private List<String> childIds;
    private String imageUrl;
    private String content;
    private String title;
    private String audioUrl;
    private Long audioDuration;
    private String linkUrl;
    private String linkTitle;
    private List<String> tags;
    private Long sortOrder;
    private String type;
    private Integer __v;
}
