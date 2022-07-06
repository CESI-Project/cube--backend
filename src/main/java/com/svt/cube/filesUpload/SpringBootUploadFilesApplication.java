package com.svt.cube.filesUpload;

import com.svt.cube.service.FilesStorageService;
import javax.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

public class SpringBootUploadFilesApplication implements CommandLineRunner {

  @Resource
  FilesStorageService storageService;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootUploadFilesApplication.class, args);
  }

  @Override
  public void run(String... arg) throws Exception {
    storageService.deleteAll();
    storageService.init();
  }
}