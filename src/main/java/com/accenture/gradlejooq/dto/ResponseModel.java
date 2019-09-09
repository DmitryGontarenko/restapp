package com.accenture.gradlejooq.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Instant;

public class ResponseModel<T> {

    private Instant actualTimestamp;

    private String status;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private T data;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String errorMessage;

    public ResponseModel(Instant actualTimestamp, String status, T data) {
        this.actualTimestamp = actualTimestamp;
        this.status = status;
        this.data = data;
    }

    public ResponseModel(Instant actualTimestamp, String status, T data, String errorMessage) {
        this.actualTimestamp = actualTimestamp;
        this.status = status;
        this.data = data;
        this.errorMessage = errorMessage;
    }

    public Instant getActualTimestamp() {
        return actualTimestamp;
    }

    public void setActualTimestamp(Instant actualTimestamp) {
        this.actualTimestamp = actualTimestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}


