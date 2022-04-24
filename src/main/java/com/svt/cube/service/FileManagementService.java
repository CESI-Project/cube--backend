package com.svt.cube.service;

import org.springframework.web.multipart.MultipartFile;
import java.lang.Exception;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManagementService {
    public void saveImage(MultipartFile imageFile) throws Exception {
        String folder = "../../../../../resources/images/";
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + imageFile.getOriginalFilename());
        Files.write(path, bytes);
    }
}
