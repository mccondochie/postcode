package uk.gov.ros.postcode.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import uk.gov.ros.postcode.client.postcodeClient.PostcodeClient;
import uk.gov.ros.postcode.client.postcodeClient.domain.PostcodeResponse;
import uk.gov.ros.postcode.client.postcodeClient.domain.PostcodeResult;
import uk.gov.ros.postcode.domain.PostcodeInfo;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PostcodeServiceTest {

    @Mock
    private PostcodeClient client;

    @InjectMocks
    private PostcodeService service;

    @Test
    public void getPostcodeInfo() {
        String postcode = "G689JE";
        String authority = "authority";
        String constituency = "constituency";
        String titleLink = "https://scotlis.ros.gov.uk/results?searchType=titles&postcode=G689JE";

        PostcodeResult postcodeResult = new PostcodeResult(postcode, authority, constituency);
        PostcodeResponse postcodeResponse = new PostcodeResponse(200, postcodeResult);
        when(client.getPostcodeInfo(anyString())).thenReturn(postcodeResponse);

        PostcodeInfo info = service.getPostcodeInfo("G689JE");
        assertEquals(authority, info.getAuthority());
        assertEquals(constituency, info.getConstituency());
        assertEquals(titleLink, info.getTitleLink());
    }
}