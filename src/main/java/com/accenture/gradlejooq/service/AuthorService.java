package com.accenture.gradlejooq.service;

import com.accenture.gradlejooq.domain.tables.records.AuthorRecord;
import com.accenture.gradlejooq.dto.request.AuthorRequest;
import com.accenture.gradlejooq.dto.response.AuthorResponse;

import java.util.List;
import java.util.Map;

public interface AuthorService {
    AuthorResponse createAuthor(AuthorRequest authorRequest);
    List<AuthorResponse> getAllAuthors();
    AuthorResponse getAuthorById(Integer id);
    AuthorResponse updateAuthorById(Map<String, Object> map, Integer id);
    void deleteAuthorById(Integer id);
}
