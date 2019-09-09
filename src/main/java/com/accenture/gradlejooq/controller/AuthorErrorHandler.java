package com.accenture.gradlejooq.controller;

import com.accenture.gradlejooq.constant.StatusConstant;
import com.accenture.gradlejooq.exceptions.RecordNotFoundException;
import com.accenture.gradlejooq.dto.ResponseModel;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuthorErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    protected ResponseEntity<ResponseModel> recordNotFontHandler(RecordNotFoundException ex, WebRequest request) {
        return new ResponseEntity<ResponseModel>(new ResponseModel(Instant.now(), StatusConstant.ERROR, null, ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}
