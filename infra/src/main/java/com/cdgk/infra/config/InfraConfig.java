package com.cdgk.infra.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.cdgk"})
@EntityScan(basePackages = {"com.cdgk"})
@EnableConfigurationProperties({ServiceProperties.class})
@EnableCaching
@Configuration
public class InfraConfig {
}
