package com.roben.portgateway.conf;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GatewayConf {
   private final String URL= "http://localhost:8081";
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("rot", r -> r.path("/user/email").and().method("GET").uri(URL))
                .route("rot", r -> r.path("/user/get").and().method("GET").uri(URL))
                .route("rot", r -> r.path("/user/login/").and().method("POST").uri(URL))
                .route("rot", r -> r.path("/user/register/").and().method("POST").uri(URL))
                .build();
    }
}

