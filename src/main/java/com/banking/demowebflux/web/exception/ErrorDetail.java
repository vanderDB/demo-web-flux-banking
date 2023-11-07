package com.banking.demowebflux.web.exception;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ErrorDetail {

    private Timestamp timestamp;
    private LocalDateTime serverDateTime;
    private List<String> messages;

    public ErrorDetail(String message) {
        initialDates();
        this.messages = List.of(message);
    }

    public ErrorDetail(List<String> messages) {
        initialDates();
        this.messages = messages;
    }

    private void initialDates() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.serverDateTime = this.timestamp.toLocalDateTime();
    }
}
