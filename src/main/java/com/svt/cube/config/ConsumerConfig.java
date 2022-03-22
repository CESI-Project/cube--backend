package com.svt.cube.config;

import com.svt.cube.entity.Consumer;
import com.svt.cube.repository.ConsumerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.APRIL;
import static java.time.Month.MARCH;

@Configuration
public class ConsumerConfig {

    @Bean
    CommandLineRunner commandLineRunner(ConsumerRepository repository) {
        return args -> {
            Consumer pierre = new Consumer(
                    "Pierre",
                    "Rocher",
                    LocalDate.of(2000, APRIL, 12),
                    "pierre.rocher@gmail.com",
                    "1234"
            );

            Consumer jean = new Consumer(
                    "jean",
                    "flutte",
                    LocalDate.of(1990, MARCH, 15),
                    "jean.flutte@gmail.com",
                    "1234"
            );

            repository.saveAll(
                    List.of(pierre, jean)
            );
        };
    }
}
