package org.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator routeLocator (RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        return routes.build();
    }
}
