package com.example.elasticsearch.event;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EventSearchRepository extends ElasticsearchRepository<EventDocument, Long> {

}
