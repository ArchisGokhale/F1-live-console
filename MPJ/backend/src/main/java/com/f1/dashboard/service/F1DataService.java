package com.f1.dashboard.service;

import com.f1.dashboard.model.CarData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class F1DataService {
    private final RestTemplate restTemplate = new RestTemplate();

    public List<CarData> fetchCarData(int driverNumber, int sessionKey) {
        String url = "https://api.openf1.org/v1/car_data?driver_number=" + driverNumber + "&session_key=" + sessionKey;
        CarData[] response = restTemplate.getForObject(url, CarData[].class);
        return Arrays.asList(response != null ? response : new CarData[0]);
    }
}