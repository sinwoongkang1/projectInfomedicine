package com.example.informedicine.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Slf4j
@Service
public class OpenAPIRequestService {
    @Value("${OPEN_API_DATA_ENCODING_KEY}")
    String serviceKey ;
    @Value("${OPEN_API_ENDPOINT}")
    String endPoint;
    Integer pageNo = 1 ;
    Integer numOfRows = 3;
    String type = "xml";

    public String requestAPI(String foodName) throws UnsupportedEncodingException {
    String encodedFoodName = URLEncoder.encode(foodName,"UTF-8");
    String body = endPoint+serviceKey+"&pageNo="+pageNo
                                                +"&numOfRows="+numOfRows
                                                +"&type="+type
                                                +"&FOOD_NM_KR="+encodedFoodName;
    return body;
    }
}

