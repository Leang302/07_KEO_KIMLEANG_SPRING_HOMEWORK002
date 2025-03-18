package com.leang.homework002.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.net.URI;
import java.time.LocalDateTime;

public interface HELPER {
    static ResponseEntity<?> notFoundMessage(Long id, String type, WebRequest webRequest){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setType(URI.create("about:blank"));
        problemDetail.setTitle("Not found");
        problemDetail.setStatus(HttpStatus.NOT_FOUND);
        problemDetail.setProperty("detail",String.format("%s with id: %d not found",type,id));
        problemDetail.setInstance(URI.create(webRequest.getDescription(false).replace("uri=", "")));
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problemDetail);
    }
}
