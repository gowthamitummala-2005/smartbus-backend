package com.example.smartbus;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CHECK_IN")
public class CheckIn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "STUDENT_NAME")
    private String studentName;

    @Column(name = "BUS_ROUTE")
    private String busRoute;

    @Column(name = "TIME")
    private LocalDateTime time;

    public CheckIn() {
        this.time = LocalDateTime.now();
    }

    public Long getId() { return id; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getBusRoute() { return busRoute; }
    public void setBusRoute(String busRoute) { this.busRoute = busRoute; }

    public LocalDateTime getTime() { return time; }
    public void setTime(LocalDateTime time) { this.time = time; }
}