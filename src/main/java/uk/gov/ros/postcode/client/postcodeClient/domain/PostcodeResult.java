package uk.gov.ros.postcode.client.postcodeClient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class PostcodeResult {

    private String postcode;
    @JsonProperty("nhs_ha")
    private String nhsHa;
    @JsonProperty("parliamentary_constituency")
    private String parliamentaryConstituency;
}
