package com.ugovslima.catalog.exceptions;

import java.time.LocalDateTime;

public record ErrorResponse (
        int status,
        String message,
        String error,
        LocalDateTime timeStamp
)  {}
