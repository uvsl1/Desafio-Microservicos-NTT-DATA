package com.ugovslima.order_simulator.exceptions;

import java.time.LocalDateTime;

public record ErrorResponse (
        int status,
        String message,
        String error,
        LocalDateTime timeStamp
)  {}