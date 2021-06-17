package com.example.elasticsearch.event;

import com.example.elasticsearch.ElasticsearchRestTemplateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventSearchQuery implements ElasticsearchRestTemplateService {
   private final ElasticsearchRestTemplate elasticsearchRestTemplate;

   public List<EventDocument> getEvents(String text){
      Query query = new NativeSearchQueryBuilder()
              .withQuery(multiMatchQuery(text)
                      .field("name")
                      .field("type")
                      .field("priority")
                      .field("hospital")
                      .type(MultiMatchQueryBuilder.Type.CROSS_FIELDS).operator(Operator.AND))
              .build();
      SearchHits<EventDocument> searchHits = elasticsearchRestTemplate.search(query, EventDocument.class);

      return searchHits.get().map(SearchHit::getContent).collect(Collectors.toList());
   }
}
