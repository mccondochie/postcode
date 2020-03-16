package uk.gov.ros.postcode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidPostcodeException extends RuntimeException {
    public InvalidPostcodeException(String message) {
        super(message);
    }
}
