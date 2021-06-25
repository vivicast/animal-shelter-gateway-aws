package es.animal.protection.animalsheltergateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {
    @Value("${animal.shelter.adopter}")
    String uriAdopter;
    @Value("${animal.shelter.cat}")
    String uriCat;
    @Value("${animal.shelter.colony}")
    String uriColony;


    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {

        return builder.routes()
                .route(r -> r.path("/adopters/**")
                        .uri(uriAdopter)
                        .id("adopterModule"))

                .route(r -> r.path("/cats/**")
                        .uri(uriCat)
                        .id("catModule"))

                .route(r -> r.path("/colonies/**")
                        .uri(uriColony)
                        .id("colonyModule"))
                .build();
    }
}
