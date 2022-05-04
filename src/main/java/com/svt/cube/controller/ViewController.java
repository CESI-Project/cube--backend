package com.svt.cube.controller;

import javax.validation.Valid;

import com.svt.cube.entity.View;
import com.svt.cube.payload.response.MessageResponse;
import com.svt.cube.service.ViewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/view")
public class ViewController {
    private final ViewService viewService;

    @Autowired
    public ViewController(ViewService viewService) {
        this.viewService = viewService;
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> createTopic(@Valid @RequestBody View view) {
        viewService.createViews(view);
        return ResponseEntity.ok(new MessageResponse("View registered successfully!"));
    }

    // Stats User
    @CrossOrigin
    @GetMapping("/{id}")
    public Integer getMyCountView(@Valid @PathVariable Integer id) {
        return viewService.getMyCountView(id);
    }

    // Stats Admin
    @CrossOrigin
    @GetMapping("/admin/count")
    public Integer getTotalViews() {
        return viewService.getTotalViews();
    }

    @CrossOrigin
    @GetMapping("/admin/countNotUsers")
    public Integer getTotalViewsNotUsers() {
        return viewService.getTotalViewsNotUsers();
    }
}
