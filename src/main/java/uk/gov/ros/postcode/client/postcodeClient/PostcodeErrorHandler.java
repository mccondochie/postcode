package uk.gov.ros.postcode.client.postcodeClient;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

@Component
public class PostcodeErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
        HttpStatus.Series series = httpResponse.getStatusCode().series();
        return (series == CLIENT_ERROR || series == SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse) { }
}
