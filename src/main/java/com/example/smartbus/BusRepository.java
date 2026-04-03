package com.example.smartbus;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusRepository extends JpaRepository<Bus, Long> {

    List<Bus> findByRoute(String route);

    Bus findFirstByRoute(String route);

    Bus findTopByOrderByDelayMinutesAsc();
}