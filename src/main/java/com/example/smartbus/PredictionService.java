package com.example.smartbus;

import org.springframework.stereotype.Service;

@Service
public class PredictionService {

    // AI Arrival Time Prediction
    public String predictArrival(double distance, double speed, int delay) {

        if (speed == 0) return "Speed cannot be zero";

        double time = distance / speed;
        time = time * 60; // convert to minutes
        time = time + delay;

        return "Predicted Arrival Time: " + Math.round(time) + " minutes";
    }

    // Weather Delay Prediction
    public String weatherDelay(String weather) {

        if (weather.equalsIgnoreCase("Rain")) {
            return "Delay 10 mins due to rain";
        }
        else if (weather.equalsIgnoreCase("Cloudy")) {
            return "Delay 5 mins due to traffic";
        }
        else if (weather.equalsIgnoreCase("Storm")) {
            return "Delay 20 mins due to storm";
        }
        else {
            return "Bus On Time";
        }
    }
}