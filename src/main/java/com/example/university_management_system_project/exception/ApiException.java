package com.example.university_management_system_project.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ApiException {
    private final HttpStatus status;
    private final String message;
    private final LocalDateTime timestamp;
}
