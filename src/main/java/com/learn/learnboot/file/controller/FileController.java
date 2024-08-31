package com.learn.learnboot.file.controller;

import com.learn.learnboot.file.helper.FileHandler;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileController {

    @Autowired
    private FileHandler handler;

    @PostMapping("/file-upload")
    public ResponseEntity<String> saveFile(@RequestParam("file") MultipartFile file )
    {

        boolean rtn=handler.save(file);
        if(rtn)
            return ResponseEntity.ok().body(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString()) ;
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File Is Not Uploaded...") ;
    }
}
