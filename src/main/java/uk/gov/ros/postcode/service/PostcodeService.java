package uk.gov.ros.postcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.gov.ros.postcode.client.postcodeClient.PostcodeClient;
import uk.gov.ros.postcode.client.postcodeClient.domain.PostcodeResponse;
import uk.gov.ros.postcode.client.postcodeClient.domain.PostcodeResult;
import uk.gov.ros.postcode.domain.PostcodeInfo;

@Service
public class PostcodeService {

    @Autowired
    private PostcodeClient client;

    public PostcodeInfo getPostcodeInfo(String postcode) {
        PostcodeResponse response = client.getPostcodeInfo(postcode);
        PostcodeResult result = response.getResult();
        return new PostcodeInfo(postcode, result.getNhsHa(), result.getParliamentaryConstituency());
    }
}
