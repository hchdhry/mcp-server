package com.example.mcpserver;

import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;

@Component
public class generalTools {
    @Value("${aviationstack.api-key}")
    private String apiKey;

    private WebClient client = WebClient.create("http://api.aviationstack.com/v1");


    @McpTool(name = "getCurrentTime", description = "return the current time")
    public LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }

    @McpTool(name = "getFlights", description = "get flights using api")
    public String getFlights() {
        return client.get().uri(uriBuilder -> uriBuilder
                .path("/flights")
                .queryParam("access_key", apiKey)
                .build()
        ).retrieve().bodyToMono(String.class).block();


    }

}
