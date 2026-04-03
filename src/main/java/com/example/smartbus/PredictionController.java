package com.example.smartbus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "http://localhost:5173")
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

    // AI Arrival Time Prediction
    @GetMapping("/predict")
    public String predict(
            @RequestParam double distance,
            @RequestParam double speed,
            @RequestParam int delay) {

        return predictionService.predictArrival(distance, speed, delay);
    }

    // Weather Delay Prediction
    @GetMapping("/weather")
    public String weather(@RequestParam String weather) {
        return predictionService.weatherDelay(weather);
    }
}