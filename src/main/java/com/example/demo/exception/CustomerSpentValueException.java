package com.example.demo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerSpentValueException extends RuntimeException {
    private static final long serialVersionUID = 5100608856338859739L;
	public CustomerSpentValueException() {
        super();
    }
    public CustomerSpentValueException(String message, Throwable cause) {
        super(message, cause);
    }
    public CustomerSpentValueException(String message) {
        super(message);
    }
    public CustomerSpentValueException(Throwable cause) {
        super(cause);
    }
}
