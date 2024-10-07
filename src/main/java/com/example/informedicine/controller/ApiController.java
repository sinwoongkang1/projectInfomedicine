package com.example.informedicine.controller;

import com.example.informedicine.service.OpenAPIRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ApiController {
    private final OpenAPIRequestService openAPIRequestService;
    private final RestTemplate restTemplate;

    @GetMapping("/getAPI")
    public ResponseEntity<String> requestOpenAPI() throws UnsupportedEncodingException, URISyntaxException {
        String requestURL =  openAPIRequestService.requestAPI("돼지고기");
        URI uri =  new URI(requestURL);
        String response = restTemplate.getForObject(uri, String.class);
        return ResponseEntity.ok(response);
    }
}
