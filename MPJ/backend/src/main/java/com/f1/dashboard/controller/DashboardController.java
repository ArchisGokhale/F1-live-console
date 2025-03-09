package com.f1.dashboard.controller;

import com.f1.dashboard.model.CarData;
import com.f1.dashboard.service.F1DataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DashboardController {
    private final F1DataService dataService;

    public DashboardController(F1DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/car-data/{driverNumber}/{sessionKey}")
    public List<CarData> getCarData(
            @PathVariable int driverNumber,
            @PathVariable int sessionKey
    ) {
        return dataService.fetchCarData(driverNumber, sessionKey);
    }
}