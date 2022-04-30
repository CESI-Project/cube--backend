// package com.svt.cube.config;

// import com.svt.cube.entity.User;
// import com.svt.cube.entity.FamilyTag;
// import com.svt.cube.entity.Tag;
// import com.svt.cube.entity.Topic;
// import com.svt.cube.repository.UserRepository;
// import com.svt.cube.repository.FamilyTagRepository;
// import com.svt.cube.repository.TagRepository;
// import com.svt.cube.repository.TopicRepository;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import java.time.LocalDate;
// import java.util.List;

// import static java.time.Month.APRIL;
// import static java.time.Month.MARCH;

// @Configuration
// public class UserConfig {

// // ToDo: Split it for each Entity (Check GitHub Ticket)
// @Bean
// CommandLineRunner commandLineRunner(UserRepository userRepository,
// TopicRepository topicRepository,
// TagRepository tagRepository, FamilyTagRepository familyTagRepository) {
// return args -> {
// User pierre = new User(
// "Pierre",
// "Rocher",
// LocalDate.of(2000, APRIL, 12),
// "pierre.rocher@gmail.com",
// "1234");

// User jean = new User(
// "Jean",
// "Flutte",
// LocalDate.of(1990, MARCH, 15),
// "jean.flutte@gmail.com",
// "1234");

// Topic macron = new Topic(
// "Macron nous parle",
// "Bonjour Bla, blablba oui blablabla",
// "macron.jpg",
// 3,
// 400,
// "Comment");

// Topic soap = new Topic(
// "Soupe le 14 Mars",
// "Bonjour Blo, blobloblo oui blobloblo",
// "soap.jpg",
// 3,
// 400,
// "Comment");
// // Tag tag = new Tag(
// // "Fishes", "Poissons");
// FamilyTag familyTag = new FamilyTag(
// "familytag",
// "famille de tag");
// userRepository.saveAll(
// List.of(pierre, jean));

// topicRepository.saveAll(
// List.of(macron, soap));
// // tagRepository.save(tag);
// familyTagRepository.save(familyTag);
// };
// }
// }
