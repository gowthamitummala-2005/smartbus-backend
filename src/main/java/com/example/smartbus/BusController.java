package com.example.smartbus;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bus")
@CrossOrigin
public class BusController {

    private final BusRepository busRepository;

    public BusController(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    // Get all buses
    @GetMapping
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    // Add new bus
    @PostMapping
    public Bus addBus(@RequestBody Bus bus) {
        return busRepository.save(bus);
    }

    // Update bus
    @PutMapping("/{id}")
    public Bus updateBus(@PathVariable Long id, @RequestBody Bus busDetails) {
        Bus bus = busRepository.findById(id).orElseThrow();

        bus.setRoute(busDetails.getRoute());
        bus.setCurrentLocation(busDetails.getCurrentLocation());
        bus.setArrivalTime(busDetails.getArrivalTime());
        bus.setStatus(busDetails.getStatus());
        bus.setDriverName(busDetails.getDriverName());
        bus.setDriverNumber(busDetails.getDriverNumber());
        bus.setDelayMinutes(busDetails.getDelayMinutes());
        bus.setLatitude(busDetails.getLatitude());
        bus.setLongitude(busDetails.getLongitude());

        return busRepository.save(bus);
    }

    // Delete bus
    @DeleteMapping("/{id}")
    public void deleteBus(@PathVariable Long id) {
        busRepository.deleteById(id);
    }

    // Search bus
    @GetMapping("/search")
    public List<Bus> searchBus(@RequestParam String route) {
        return busRepository.findByRoute(route);
    }

    // Recommended bus
    @GetMapping("/recommended")
    public Bus getRecommendedBus() {
        return busRepository.findTopByOrderByDelayMinutesAsc();
    }
}