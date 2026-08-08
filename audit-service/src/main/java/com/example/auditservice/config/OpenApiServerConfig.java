package com.example.auditservice.config;

import java.util.List;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.servers.Server;




@Configuration
public class OpenApiServerConfig {

    @Bean
    public OpenApiCustomizer globalServerCustomizer() {
        return openApi -> {
            openApi.setServers(
                    List.of(new Server().url("/"))
            );
        };
    }

}