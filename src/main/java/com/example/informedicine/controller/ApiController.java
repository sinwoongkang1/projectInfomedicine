package com.example.informedicine.controller;

import com.example.informedicine.service.OpenAPIRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ApiController {
    private final OpenAPIRequestService openAPIRequestService;
    private final RestTemplate restTemplate;

    @GetMapping("/getAPI")
    public ResponseEntity<String> requestOpenAPI() throws UnsupportedEncodingException {
        String requestURL =  openAPIRequestService.requestAPI("소머리국밥");
        String response = restTemplate.getForObject(requestURL, String.class);
        log.info(requestURL);
        log.info(response);
        return ResponseEntity.ok(response);
    }
}
