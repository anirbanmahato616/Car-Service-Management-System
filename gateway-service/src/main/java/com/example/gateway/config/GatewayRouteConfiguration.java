package com.example.gateway.config;

import org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions;
import org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.path;

@Configuration
public class GatewayRouteConfiguration {

    @Bean
    public RouterFunction<ServerResponse> auditDocsRoute() {
        return GatewayRouterFunctions.route("audit-docs-route")
                .route(path("/audit-service/v3/api-docs"),
                        HandlerFunctions.http())
                .filter(FilterFunctions.stripPrefix(1))
                .filter(LoadBalancerFilterFunctions.lb("audit-service"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> userProfileDocsRoute() {
        return GatewayRouterFunctions.route("user-profile-docs-route")
                .route(path("/user-profile-service/v3/api-docs"),
                        HandlerFunctions.http())
                .filter(FilterFunctions.stripPrefix(1))
                .filter(LoadBalancerFilterFunctions.lb("user-profile-service"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> carDocsRoute() {
        return GatewayRouterFunctions.route("car-docs-route")
                .route(path("/car-service-operations/v3/api-docs"),
                        HandlerFunctions.http())
                .filter(FilterFunctions.stripPrefix(1))
                .filter(LoadBalancerFilterFunctions.lb("car-service-operations"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> carValidationDocsRoute() {
        return GatewayRouterFunctions.route("car-validation-docs-route")
                .route(path("/car-details-validation-service/v3/api-docs"),
                        HandlerFunctions.http())
                .filter(FilterFunctions.stripPrefix(1))
                .filter(LoadBalancerFilterFunctions.lb("car-details-validation-service"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> authDocsRoute() {
        return GatewayRouterFunctions.route("auth-docs-route")
                .route(path("/auth-service/v3/api-docs"),
                        HandlerFunctions.http())
                .filter(FilterFunctions.stripPrefix(1))
                .filter(LoadBalancerFilterFunctions.lb("auth-service"))
                .build();
    }
    
    @Bean
    public RouterFunction<ServerResponse> auditActuatorRoute() {
        return GatewayRouterFunctions.route("audit-actuator-route")
                .route(path("/audit-service/actuator/**"),
                        HandlerFunctions.http())
                .filter(FilterFunctions.stripPrefix(1))
                .filter(LoadBalancerFilterFunctions.lb("audit-service"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> authActuatorRoute() {
        return GatewayRouterFunctions.route("auth-actuator-route")
                .route(path("/auth-service/actuator/**"),
                        HandlerFunctions.http())
                .filter(FilterFunctions.stripPrefix(1))
                .filter(LoadBalancerFilterFunctions.lb("auth-service"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> userProfileActuatorRoute() {
        return GatewayRouterFunctions.route("user-profile-actuator-route")
                .route(path("/user-profile-service/actuator/**"),
                        HandlerFunctions.http())
                .filter(FilterFunctions.stripPrefix(1))
                .filter(LoadBalancerFilterFunctions.lb("user-profile-service"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> carServiceActuatorRoute() {
        return GatewayRouterFunctions.route("car-service-actuator-route")
                .route(path("/car-service-operations/actuator/**"),
                        HandlerFunctions.http())
                .filter(FilterFunctions.stripPrefix(1))
                .filter(LoadBalancerFilterFunctions.lb("car-service-operations"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> carValidationActuatorRoute() {
        return GatewayRouterFunctions.route("car-validation-actuator-route")
                .route(path("/car-details-validation-service/actuator/**"),
                        HandlerFunctions.http())
                .filter(FilterFunctions.stripPrefix(1))
                .filter(LoadBalancerFilterFunctions.lb("car-details-validation-service"))
                .build();
    }
}