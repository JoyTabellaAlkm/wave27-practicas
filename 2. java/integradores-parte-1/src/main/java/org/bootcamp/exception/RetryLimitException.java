package org.bootcamp.exception;

public class RetryLimitException extends RuntimeException {
    public RetryLimitException(String message) {
        super(message);
    }
}
