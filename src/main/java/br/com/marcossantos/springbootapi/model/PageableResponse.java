package br.com.marcossantos.springbootapi.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PageableResponse<T> extends PageImpl<T> {

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public PageableResponse(@JsonProperty("content") List<T> content, @JsonProperty("number") int page,
      @JsonProperty("size") int size, @JsonProperty("totalElements") long totalElements,
      @JsonProperty("last") boolean last, @JsonProperty("first") boolean first,
      @JsonProperty("totalPages") int totalPages, @JsonProperty("sort") JsonNode sort) {
    super(content, PageRequest.of(page, size), totalElements);
  }

  public PageableResponse(List<T> content, Pageable pageable, long total) {
    super(content, pageable, total);
  }

  public PageableResponse(List<T> content) {
    super(content);
  }

  public PageableResponse() {
    super(new ArrayList<>());
  }

}