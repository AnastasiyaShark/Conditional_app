package ru.netology.conditionalApp;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    @ConditionalOnProperty(prefix = "netology",name = "profile.dev",havingValue = "true", matchIfMissing = true)
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(prefix = "netology",name = "profile.dev",havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
