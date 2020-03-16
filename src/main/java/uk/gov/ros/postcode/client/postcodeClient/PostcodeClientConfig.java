package uk.gov.ros.postcode.client.postcodeClient;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Duration;

@Getter
@Setter
@Validated
@Configuration
@ConfigurationProperties("services.postcode-server")
public class PostcodeClientConfig {

    @NotNull
    private Duration connectTimeout;

    @NotNull
    private Duration readTimeout;

    @NotEmpty
    private String baseUrl;
}
