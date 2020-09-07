package com.forcode.e4y.handler;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.util.UriComponentsBuilder;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;


import com.forcode.e4y.data.Beer;
import com.forcode.e4y.dto.BeerDTO;
import com.forcode.e4y.mapper.BeerMapper;
import com.forcode.e4y.repository.BeerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public class BeerHandler {

    @Autowired
    private RestTemplate client;

    private final WebClient webClient;
    
    @Autowired
    private BeerRepository beerRepository;

    public BeerHandler(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://api.punkapi.com/v2/beers?beer_name={name}")
                .build();
    }

    public Mono<ServerResponse> getBeerByName(ServerRequest req) {

        final String name = req.pathVariable("name");
        /**
         * webclient action
         */
        Flux<BeerDTO> fluxWebClient = getBeerNameWebClient(name);
        Mono<List<BeerDTO>> collected = fluxWebClient.collectList();



        return ServerResponse.ok().contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(collected, BeerDTO.class);

        /**
         * RestTemplate action
         */
        //BeerDTO[] result = getBeerName(name);
        //Flux<BeerDTO> flux = Flux.fromArray(result);
        //return ServerResponse.ok().contentType(MediaType.APPLICATION_STREAM_JSON)
        //        .body(fromPublisher(flux, BeerDTO.class));
    }
    
    public Mono<ServerResponse> createFavorite(ServerRequest req){
    	
    	final Mono<Beer> beer = req.bodyToMono(Beer.class);
    	Mono<Beer> beerMono = beer.flatMap(beerRepository::save);
    	
        return ServerResponse.status(HttpStatus.CREATED).body(beerMono, Beer.class);
    	
    }

    /**
     * NON-FLUX CONSUMER
     * @param name
     * @return
     */
    private BeerDTO[] getBeerName(String name) {
        return client.getForEntity("https://api.punkapi.com/v2/beers?beer_name={name}", BeerDTO[].class, name).getBody();
    }
    
    public Mono<ServerResponse> getFavorites(ServerRequest req) {
    	
        Flux<BeerDTO>  beers = beerRepository.findAll().map(BeerMapper::toBeerDto);
    	return ServerResponse.ok().contentType(MediaType.APPLICATION_STREAM_JSON)
               .body(fromPublisher(beers, BeerDTO.class));
    }

    /**
     * FLUX CONSUMER
     * @param name
     * @return
     */
    private Flux<BeerDTO> getBeerNameWebClient(String name) {

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .
                                build(name))

                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(BeerDTO.class);
    }
}
