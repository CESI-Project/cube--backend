package com.svt.cube.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// import com.svt.cube.entity.Topic;
import com.svt.cube.service.FileManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedInputStream;

@RestController
@RequestMapping(path = "api/v1/fileManagement")
public class FileManagementController {

    private final FileManagementService fileManagementService;
    String folderPath = "../../../../../resources/images/";

    @Autowired
    public FileManagementController(FileManagementService fileManagementService) {
        this.fileManagementService = fileManagementService;
    }

    // API Post : upload un fichier image
    @CrossOrigin
    @PostMapping("/upload")
    public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
        String returnValue = "";
        try {
            fileManagementService.saveImage(imageFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnValue;
    }

    // API Get : dowload un fichier
    @CrossOrigin
    @GetMapping("/download/{fileName:.+}")
    public void downloadPDFResource(HttpServletRequest request, HttpServletResponse response,
            @PathVariable("fileName") String fileName) throws IOException {

        File file = new File(folderPath + fileName);
        if (file.exists()) {

            // get the mimetype
            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            if (mimeType == null) {
                // unknown mimetype so set the mimetype to application/octet-stream
                mimeType = "application/octet-stream";
            }

            response.setContentType(mimeType);

            response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

            // Here we have mentioned it to show as attachment
            // response.setHeader("Content-Disposition", String.format("attachment;
            // filename=\"" + file.getName() + "\""));

            response.setContentLength((int) file.length());

            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

            FileCopyUtils.copy(inputStream, response.getOutputStream());

        }
    }
}
