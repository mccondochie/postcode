package uk.gov.ros.postcode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class PostcodeClientException extends RuntimeException {
    public PostcodeClientException(String message) {
        super(message);
    }
}
