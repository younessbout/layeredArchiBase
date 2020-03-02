package com.cdgk.infra.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "service", ignoreUnknownFields = false)
@Getter
@Setter
public class ServiceProperties {

    private Params params = new Params();
    private Logs logs = new Logs();
    private Dates dates = new Dates();

    @Getter
    @Setter
    public static class Logs {
        private String folder;
    }

    @Getter
    @Setter
    public static class Dates {
        private String defaultDateFormat;
        private String defaultDateTimeFormat;
    }

    @Getter
    @Setter
    public static class Params {

    }
}
