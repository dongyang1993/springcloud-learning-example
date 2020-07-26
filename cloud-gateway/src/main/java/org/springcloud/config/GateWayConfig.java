package org.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                //指定ID就用指定的
                .route("guonei", r -> r.path("/guonei").uri("http://news.baidu.com/"))
                //不指定ID就是RadomId ==> UUID
                .route(r -> r.path("/guoji").uri("http://news.baidu.com/"))
                .build();
    }
}
