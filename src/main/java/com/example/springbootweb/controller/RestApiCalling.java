package com.example.springbootweb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequiredArgsConstructor
public class RestApiCalling {

    private static final String URL="https://restcountries.com/v3.1/independent?status=true";
    private final RestTemplate restTemplate;


    @GetMapping("/getApiData")
    public String get()
    {
        return "Employee Controller";
    }

    @Operation(summary = "get Countries")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "OK"),
            @ApiResponse(responseCode = "404",description = "NOT FOUND"),
            @ApiResponse(responseCode = "500",description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("/apicalling")
    public ResponseEntity<Object>  api()
    {
//        URI uri = UriComponentsBuilder.fromUriString(url)
//                .queryParam("param1", value1)
//                .queryParam("param2", value2)
//                .build()
//                .toUri();

        // Define request headers if needed
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("Authorization", "Bearer your_access_token");

        // Create HttpEntity with headers
//        HttpEntity<?> requestEntity = new HttpEntity<>(headers);

        // Make a GET request with headers and URI and get the response entity
//        ResponseEntity<String> responseEntity = restTemplate.exchange(
//                uri,
//                HttpMethod.GET,
//                requestEntity,
//                String.class);

        // Get response body from the entity
//        String responseBody = responseEntity.getBody();

        // Handle the response
//        System.out.println("Response: " + responseBody);

        ResponseEntity<String> response=restTemplate.getForEntity(URL,String.class);//call for GET Method only

        //ResponseEntity<String> response=restTemplate.exchange(url,HttpMethod.POST,entity,String.class);//exchange method use for any type of request like get,post,put
        //it sends HttpHeaders,QueryParam

        log.info(response.getBody());
        return ResponseEntity.ok(response);


    }

}
