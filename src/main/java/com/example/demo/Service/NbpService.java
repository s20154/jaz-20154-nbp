package com.example.demo.service;

import com.example.demo.Model.Root;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NbpService {
    private RestTemplate restTemplate;

    public NbpService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    public Double getAvgRateDate(String currency, String from, String to){
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/" + from + "/" + to + "/?format=json";
        Root root = restTemplate.getForObject(url, Root.class);
        return root.getRates()
                .stream()
                .mapToDouble(x-> x.getMid())
                .average().orElse(0.0);
    }

}