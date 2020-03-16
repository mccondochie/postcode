package uk.gov.ros.postcode.client.postcodeClient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class PostcodeResponse {

    private int status;
    private PostcodeResult result;
}
