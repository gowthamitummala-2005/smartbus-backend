package com.example.smartbus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checkin")
@CrossOrigin(origins = "http://localhost:5173")
public class CheckInController {

    @Autowired
    private CheckInRepository repo;

    @PostMapping
    public CheckIn saveCheckIn(@RequestBody CheckIn checkIn) {
        return repo.save(checkIn);
    }

    @GetMapping
    public List<CheckIn> getAllCheckIns() {
        return repo.findAll();
    }
}