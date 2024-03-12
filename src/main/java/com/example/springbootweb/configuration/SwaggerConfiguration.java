package com.example.springbootweb.configuration;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SwaggerConfiguration {

//    @Bean
//    public GroupedOpenApi customApi() {
//        return GroupedOpenApi.builder()
//                .group("api")
//                .pathsToMatch("/api/**")
//                .build();
//    }

    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

}
