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
@ConfigurationProperties("eyes")
public class EyesConfiguration {

    @NotBlank
    private String appName;

    @NotBlank
    private String batchInfo;

    @NotBlank
    private String branchName;

    @NotBlank
    private String apiKey;

    @NotNull
    private Integer concurrency;

    @NotNull
    private Integer viewportX;

    @NotNull
    private Integer viewportY;
}
