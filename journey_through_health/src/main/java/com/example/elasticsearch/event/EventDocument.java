package com.example.elasticsearch.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.*;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "event", createIndex = false)
public class EventDocument {
    @Id
    private Long id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String description;

    @Field(type = FieldType.Text)
    private String hospital;

    @Field(type = FieldType.Keyword)
    private Type type;

    @Field(type = FieldType.Keyword)
    private Priority priority;

    @JsonProperty("created_at")
    @Field(type = FieldType.Date)
    private Instant createdAt;

    public enum Type {
        appointment,
        surgery,
        exam,
        test,
        imaging;
    }

    public enum Priority {
        high,
        medium,
        low;
    }
}
