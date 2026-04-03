package com.example.smartbus;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(BusRepository repo) {
        return args -> {

            if (repo.count() > 0) return;

            repo.save(new Bus("Route A","Tarnaka","09:00","On Time","Sai","9876543210",0,17.4239,78.5284));
            repo.save(new Bus("Route B","Uppal","09:10","On Time","Raju","9876543211",0,17.4050,78.5591));
            repo.save(new Bus("Route C","Secunderabad","09:20","Delayed","Mahesh","9876543212",5,17.4399,78.4983));
            repo.save(new Bus("Route D","Habsiguda","09:30","On Time","Ajay","9876543213",0,17.4146,78.5410));
            repo.save(new Bus("Route E","NGRI","09:40","Delayed","Kiran","9876543214",10,17.4120,78.5200));
            repo.save(new Bus("Route F","Mettuguda","09:50","On Time","Girish","9876543215",0,17.4365,78.5190));
            repo.save(new Bus("Route G","Begumpet","10:00","On Time","Naresh","9876543216",0,17.4440,78.4660));
            repo.save(new Bus("Route H","OU Campus","10:10","Delayed","Suresh","9876543217",8,17.4100,78.5280));

        };
    }
}