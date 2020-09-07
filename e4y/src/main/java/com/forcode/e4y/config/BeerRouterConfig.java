package com.forcode.e4y.config;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.forcode.e4y.handler.BeerHandler;

@Configuration
@EnableWebFlux
public class BeerRouterConfig {

    @Bean
    public RouterFunction<ServerResponse> routerBeer(BeerHandler beerHandler){
        return RouterFunctions.route()
                .path("/beer", builder -> builder
                		.GET("/{name}" ,accept(MediaType.APPLICATION_JSON), beerHandler::getBeerByName)
                		.POST("/favorite", beerHandler::createFavorite)
                		.GET("/",accept(MediaType.APPLICATION_JSON), beerHandler::getFavorites)
                        
                )
                .build();
    }




}
