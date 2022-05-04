package com.svt.cube.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import com.svt.cube.entity.FileInfo;
import com.svt.cube.payload.response.MessageResponse;
import com.svt.cube.service.FilesStorageService;
import com.svt.cube.service.TopicService;
import com.svt.cube.service.UserService;

@Controller
@RequestMapping(path = "api/v1/filesController")
public class FilesController {
    private final FilesStorageService storageService;
    private final TopicService topicService;
    private final UserService userService;

    @Autowired
    public FilesController(FilesStorageService storageService, TopicService topicService, UserService userService) {
        this.storageService = storageService;
        this.topicService = topicService;
        this.userService = userService;
    }

    @PostMapping("/{id}/upload")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODE') or hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
    public ResponseEntity<MessageResponse> uploadFile(@PathVariable Integer id,
            @RequestParam("file") MultipartFile file) {
        String message = "";
        String nameFile = "Topic_" + id.toString() + "_" + file.getOriginalFilename();
        try {
            topicService.addPicturePath(id, nameFile);
            storageService.saveTopic(file, nameFile);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
        }
    }

    @PostMapping("user/{id}/upload")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODE') or hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
    public ResponseEntity<MessageResponse> uploadFileUser(@PathVariable Long id,
            @RequestParam("file") MultipartFile file) {
        String message = "";
        String nameFile = "User_" + id.toString() + "_" + file.getOriginalFilename();
        try {
            userService.addPicturePath(id, nameFile);
            storageService.saveTopic(file, nameFile);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();
            return new FileInfo(filename, url);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
