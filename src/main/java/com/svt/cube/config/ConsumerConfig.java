package com.svt.cube.config;

import com.svt.cube.entity.Consumer;
import com.svt.cube.entity.Topic;
import com.svt.cube.repository.ConsumerRepository;
import com.svt.cube.repository.TopicRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.APRIL;
import static java.time.Month.MARCH;

@Configuration
public class ConsumerConfig {

        // ToDo: Split it for each Entity (Check GitHub Ticket)
        @Bean
        CommandLineRunner commandLineRunner(ConsumerRepository consumerRepository, TopicRepository topicRepository) {
                return args -> {
                        Consumer pierre = new Consumer(
                                        "Pierre",
                                        "Rocher",
                                        LocalDate.of(2000, APRIL, 12),
                                        "pierre.rocher@gmail.com",
                                        "1234");

                        Consumer jean = new Consumer(
                                        "Jean",
                                        "Flutte",
                                        LocalDate.of(1990, MARCH, 15),
                                        "jean.flutte@gmail.com",
                                        "1234");

                        Topic macron = new Topic(
                                        "Macron nous parle",
                                        "macron.jpg",
                                        3,
                                        400,
                                        "Comment");

                        Topic soap = new Topic(
                                        "Soupe le 14 Mars",
                                        "soap.jpg",
                                        3,
                                        400,
                                        "Comment");
                        consumerRepository.saveAll(
                                        List.of(pierre, jean));

                        topicRepository.saveAll(
                                        List.of(macron, soap));
                };
        }
}
