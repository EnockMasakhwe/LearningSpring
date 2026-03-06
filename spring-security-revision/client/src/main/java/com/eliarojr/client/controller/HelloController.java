package com.eliarojr.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.security.Principal;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

@RestController
public class HelloController {

    @Autowired
    private WebClient webClient;

    @GetMapping("/hello")
    public String helloWorld(Principal principal){
        return "Hello" + principal.getName() + ", Welcome to my SpringBoot App!";
    }

    //Use webclient to call the resource-server api
    @GetMapping("/api/users")
    public String [] users(@RegisteredOAuth2AuthorizedClient("api-client-authorization-code")
                           OAuth2AuthorizedClient client){
        return webClient
                .get()
                .uri("http://localhost:8090/api/users")
                .attributes(oauth2AuthorizedClient(client))
                .retrieve()
                .bodyToMono(String[].class)
                .block();
    }
}

