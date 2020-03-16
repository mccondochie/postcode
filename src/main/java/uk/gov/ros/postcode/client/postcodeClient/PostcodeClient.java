package uk.gov.ros.postcode.client.postcodeClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import uk.gov.ros.postcode.client.postcodeClient.domain.PostcodeResponse;
import uk.gov.ros.postcode.exception.PostcodeClientException;
import uk.gov.ros.postcode.exception.PostcodeNotFoundException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Component
public class PostcodeClient {

    private RestTemplate restTemplate;

    @Autowired
    public PostcodeClient(RestTemplateBuilder restTemplateBuilder, PostcodeClientConfig config) {
        this.restTemplate = restTemplateBuilder
                .errorHandler(new PostcodeErrorHandler())
                .rootUri(config.getBaseUrl())
                .setReadTimeout(config.getReadTimeout())
                .setConnectTimeout(config.getConnectTimeout())
                .build();
    }

    public PostcodeResponse getPostcodeInfo(String postcode) {
        ResponseEntity<PostcodeResponse> response = restTemplate
                .getForEntity("/" + postcode, PostcodeResponse.class);

        if (response.getStatusCode().isError()) {
            switch (response.getStatusCode()) {
                case NOT_FOUND: throw new PostcodeNotFoundException("Postcode Not Found");
                default: throw new PostcodeClientException(INTERNAL_SERVER_ERROR.getReasonPhrase());
            }
        }
        return response.getBody();
    }
}
