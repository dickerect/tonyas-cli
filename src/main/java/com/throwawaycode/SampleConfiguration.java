package com.throwawaycode;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleConfiguration {

    @Bean
    public Map forDemonstratingImportOfSpringConfigClass() {
        return new HashMap<>();
    }

}
