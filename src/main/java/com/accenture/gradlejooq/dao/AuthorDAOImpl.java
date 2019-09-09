package com.accenture.gradlejooq.dao;

import com.accenture.gradlejooq.domain.tables.Author;
import com.accenture.gradlejooq.domain.tables.records.AuthorRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorDAOImpl implements AuthorDAO {

    private final DSLContext dsl;

    @Autowired
    public AuthorDAOImpl(DSLContext dsl) {
        this.dsl = dsl;
    }

    private Author author = Author.AUTHOR;

    @Override
    public AuthorRecord create(AuthorRecord authorRecord) {
        return dsl.insertInto(author)
                .set(authorRecord)
                .returning()
                .fetchOne();
    }

    @Override
    public List<AuthorRecord> findAll() {
        return dsl.select()
                .from(author)
                .fetch()
                .into(author);
    }

    @Override
    public Optional<AuthorRecord> findById(Integer id) {
        return dsl.select()
                .from(author)
                .where(author.ID.eq(id))
                .fetchOptionalInto(author);
    }

    @Override
    public AuthorRecord updateById(AuthorRecord authorRecord, Integer id) {
        return dsl.update(author)
                .set(author.FIRST_NAME, authorRecord.getFirstName())
                .set(author.LAST_NAME, authorRecord.getLastName())
                .where(author.ID.eq(id))
                .returning()
                .fetchOne();
    }

    @Override
    public void deleteById(AuthorRecord authorRecord) {
        dsl.delete(author)
                .where(author.ID.eq(authorRecord.getId()))
                .execute();
    }
}
