package io.github.matheusbeoulve.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Validated
@ConfigurationProperties("webdriver")
public class WebDriverConfiguration {

    @NotBlank
    private String url;

    @NotNull
    private Long implicitlyTimeout;
}
