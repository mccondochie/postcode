package uk.gov.ros.postcode.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostcodeInfo {

    private String authority;
    private String constituency;
    private String titleLink;

    public PostcodeInfo(String postcode, String authority, String constituency) {
        this.authority = authority;
        this.constituency = constituency;
        this.titleLink = "https://scotlis.ros.gov.uk/results?searchType=titles&postcode=" + postcode;
    }
}
