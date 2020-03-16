package uk.gov.ros.postcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.ros.postcode.domain.PostcodeInfo;
import uk.gov.ros.postcode.exception.InvalidPostcodeException;
import uk.gov.ros.postcode.service.PostcodeService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class PostcodeController {

    @Autowired
    private PostcodeService service;

    @ResponseBody
    @GetMapping("/{postcode}")
    public PostcodeInfo getPostcode(@PathVariable(value = "postcode") String postcode) {
        validatePostcode(postcode);
        return service.getPostcodeInfo(postcode.replaceAll("[^A-z0-9]", ""));
    }

    private void validatePostcode(String postcode) {
        String regex = "^([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9][A-Za-z]?))))\\s?[0-9][A-Za-z]{2})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(postcode.toLowerCase());
        if (!matcher.matches()) {
            throw new InvalidPostcodeException("Invalid postcode");
        }
    }
}
