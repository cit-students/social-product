package com.cit.productsocial.controller;

import com.cit.productsocial.service.AWS3FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.cit.productsocial.controller.AbstractController.API_URL;

@RestController
@RequestMapping(API_URL  + "/aws3")
public class AWS3Controller {

    @Autowired
    private final AWS3FileStorageService aws3;

    @Autowired
    public AWS3Controller(AWS3FileStorageService aws3) {
        this.aws3 = aws3;
    }

    @GetMapping
    public List<String> getAllFileUrl() {
        return aws3.getAllFileUrl();
    }

    @GetMapping("/{key}")
    public List<String> getFileUrl(@PathVariable String key) {
        return aws3.getFileUrlByKey(key);
    }

    @PostMapping
    public void uploadFile(@RequestParam("key") String key, @RequestParam("file") MultipartFile file) {
        aws3.uploadFile(key, file);
    }

    @PostMapping("/{key}")
    public void updateFile(@PathVariable String key, @RequestParam("file") MultipartFile file) {
        aws3.updateFile(key, file);
    }

    @DeleteMapping("/{key}")
    public void deleteFile(@PathVariable String key) {
        aws3.deleteFile(key);
    }
}
