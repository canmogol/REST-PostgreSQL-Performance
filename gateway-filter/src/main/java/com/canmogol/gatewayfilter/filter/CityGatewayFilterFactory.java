package com.canmogol.gatewayfilter.filter;

import lombok.Data;
import lombok.NonNull;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
public class CityGatewayFilterFactory extends
        AbstractGatewayFilterFactory<CityGatewayFilterFactory.Config> {

    private final WebClient client;

    public CityGatewayFilterFactory() {
        super(Config.class);
        String backendRestURL = Optional.ofNullable(System.getenv("BACKEND_REST_URL"))
                .orElse("http://centos:3000");
        client = WebClient.create(backendRestURL);
    }

    public GatewayFilter apply(final @NonNull Config config) {
        return this::applyFilter;
    }

    final Mono<Void> applyFilter(final ServerWebExchange exchange, final GatewayFilterChain chain) {
        Flux<DataBuffer> cityFlux = client.get()
                .uri("/city")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(DataBuffer.class);
        return exchange.getResponse().writeWith(cityFlux);
    }

    @Data
    public static class Config {
    }

}
