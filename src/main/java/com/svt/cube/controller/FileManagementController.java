package com.svt.cube.controller;

import java.util.Optional;
import com.svt.cube.entity.Topic;
import com.svt.cube.repository.TopicRepository;
import com.svt.cube.service.FileManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/fileManagement")
public class FileManagementController {

    private final FileManagementService fileManagementService;
    private final TopicRepository topicRepository;
    String folderPath = "./src/main/resources/images/";

    @Autowired
    public FileManagementController(FileManagementService fileManagementService, TopicRepository topicRepository) {
        this.fileManagementService = fileManagementService;
        this.topicRepository = topicRepository;
    }

    // API Post : upload un fichier image
    @CrossOrigin
    @PostMapping("/upload")
    public Void uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
        // replace by this line when front is integrated
        // public RedirectView uploadImage(Integer topicId,, @RequestParam("imageFile")
        // MultipartFile imageFile) {
        try {
            Optional<Topic> topic = topicRepository.findById(1);
            // replace by this line when front is integrated
            // Optional<Topic> topic = topicRepository.findById(topicId);
            if (topic.isPresent()) {
                String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
                topic.get().setPicture(fileName);
                topicRepository.save(topic.get());

                fileManagementService.saveFile(folderPath, fileName, imageFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
