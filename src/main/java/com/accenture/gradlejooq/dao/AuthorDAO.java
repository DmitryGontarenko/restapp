package com.accenture.gradlejooq.dao;

import com.accenture.gradlejooq.domain.tables.records.AuthorRecord;

import java.util.List;
import java.util.Optional;

public interface AuthorDAO {
    AuthorRecord create(AuthorRecord authorRecord);
    List<AuthorRecord> findAll();
    Optional<AuthorRecord> findById(Integer id);
    AuthorRecord updateById(AuthorRecord authorRecord, Integer id);
    void deleteById(AuthorRecord authorRecord);
}
