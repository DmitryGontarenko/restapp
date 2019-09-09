package com.accenture.gradlejooq.controller;

import com.accenture.gradlejooq.constant.StatusConstant;
import com.accenture.gradlejooq.dto.View;
import com.accenture.gradlejooq.dto.request.AuthorRequest;
import com.accenture.gradlejooq.dto.response.AuthorResponse;
import com.accenture.gradlejooq.service.AuthorService;
import com.accenture.gradlejooq.dto.ResponseModel;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@RestController
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public ResponseEntity<ResponseModel> getAllAuthors() {
        List<AuthorResponse> allAuthors = authorService.getAllAuthors();
        return new ResponseEntity<>(new ResponseModel(Instant.now(), StatusConstant.SUCCESS, allAuthors), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<AuthorResponse> allAuthors = authorService.getAllAuthors();
        return new ResponseEntity<>(allAuthors, HttpStatus.OK);
    }

    @JsonView(View.Admin.class)
    @GetMapping("/authors/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable("id") Integer id) {
        AuthorResponse authorById = authorService.getAuthorById(id);
        return new ResponseEntity<>(authorById, HttpStatus.OK);
    }

    @PostMapping("/authors")
    public ResponseEntity<?> createNewAuthor(@Validated(AuthorRequest.CreateAuthorRequest.class)
                                                 @RequestBody AuthorRequest authorRequest) {
        AuthorResponse authorResponse = authorService.createAuthor(authorRequest);
        return new ResponseEntity<>(authorResponse, HttpStatus.CREATED);
    }

    @PatchMapping("/authors/{id}")
    public ResponseEntity<ResponseModel> updateAuthorById(@PathVariable("id") Integer id,
                                                           @RequestBody Map<String, Object> map) {
        AuthorResponse authorResponse = authorService.updateAuthorById(map, id);
        return new ResponseEntity<>(new ResponseModel(Instant.now(), StatusConstant.SUCCESS, authorResponse), HttpStatus.OK);
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable("id") Integer id) {
        authorService.deleteAuthorById(id);
        return new ResponseEntity<>("Record with id " + id + " deleted", HttpStatus.OK);
    }
}
