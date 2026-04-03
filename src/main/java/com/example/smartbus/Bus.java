package com.example.smartbus;

import jakarta.persistence.*;

@Entity
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String route;
    private String currentLocation;
    private String arrivalTime;
    private String status;
    private String driverName;
    private String driverNumber;
    private int delayMinutes;
    private double latitude;
    private double longitude;

    public Bus() {}

    public Bus(String route, String currentLocation, String arrivalTime,
               String status, String driverName, String driverNumber,
               int delayMinutes, double latitude, double longitude) {
        this.route = route;
        this.currentLocation = currentLocation;
        this.arrivalTime = arrivalTime;
        this.status = status;
        this.driverName = driverName;
        this.driverNumber = driverNumber;
        this.delayMinutes = delayMinutes;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public String getRoute() { return route; }
    public void setRoute(String route) { this.route = route; }

    public String getCurrentLocation() { return currentLocation; }
    public void setCurrentLocation(String currentLocation) { this.currentLocation = currentLocation; }

    public String getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDriverName() { return driverName; }
    public void setDriverName(String driverName) { this.driverName = driverName; }

    public String getDriverNumber() { return driverNumber; }
    public void setDriverNumber(String driverNumber) { this.driverNumber = driverNumber; }

    public int getDelayMinutes() { return delayMinutes; }
    public void setDelayMinutes(int delayMinutes) { this.delayMinutes = delayMinutes; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
}