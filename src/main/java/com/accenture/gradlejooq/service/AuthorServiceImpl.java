package com.accenture.gradlejooq.service;

import com.accenture.gradlejooq.constant.MessagesConstant;
import com.accenture.gradlejooq.dao.AuthorDAO;
import com.accenture.gradlejooq.domain.tables.records.AuthorRecord;
import com.accenture.gradlejooq.dto.request.AuthorRequest;
import com.accenture.gradlejooq.dto.response.AuthorResponse;
import com.accenture.gradlejooq.exceptions.RecordNotFoundException;
import org.jooq.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);

    private final AuthorDAO authorDAO;

    @Autowired
    public AuthorServiceImpl(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Override
    public AuthorResponse createAuthor(AuthorRequest authorRequest) {
        AuthorRecord record = createRecord(authorRequest);
        log.info("Record - {} created", record);
        return authorDAO.create(record).into(AuthorResponse.class);
    }

    @Override
    public List<AuthorResponse> getAllAuthors() {
        return ((Result<AuthorRecord>)authorDAO.findAll()).into(AuthorResponse.class);
    }

    @Override
    public AuthorResponse getAuthorById(Integer id) throws RecordNotFoundException {
        return authorDAO.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(MessagesConstant.RECORD_NOT_FOUND))
                .into(AuthorResponse.class);
    }

    @Override
    public void deleteAuthorById(Integer id) {
        AuthorRecord authorRecord = authorDAO.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(MessagesConstant.RECORD_NOT_FOUND));
        authorDAO.deleteById(authorRecord);
    }

    private AuthorRecord createRecord(AuthorRequest authorRequest) {
        AuthorRecord record = new AuthorRecord();
        record.from(authorRequest);
        return record;
    }

}
