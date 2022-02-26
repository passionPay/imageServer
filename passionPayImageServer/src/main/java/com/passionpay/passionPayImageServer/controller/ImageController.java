package com.passionpay.passionPayImageServer.controller;

import com.passionpay.passionPayImageServer.service.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageController {

    private final S3Uploader s3Uploader;

    @Autowired
    public ImageController(S3Uploader s3Uploader) {
        this.s3Uploader = s3Uploader;
    }

    @PostMapping("/images")
    public String upload(@RequestParam("images") MultipartFile multipartFile) throws IOException {
        return s3Uploader.upload(multipartFile, "static");
    }

    @DeleteMapping("/images/{filename}")
    public ResponseEntity<String> deleteFile(@PathVariable("filename") String filename) {
        return new ResponseEntity<>(s3Uploader.deleteFile(filename), HttpStatus.OK);
    }

    @GetMapping("/test")
    public String test() {
        return "Hello, World!";
    }


}
