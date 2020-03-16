package uk.gov.ros.postcode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PostcodeNotFoundException extends RuntimeException {
    public PostcodeNotFoundException(String message) {
        super(message);
    }
}
