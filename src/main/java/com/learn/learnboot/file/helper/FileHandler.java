package com.learn.learnboot.file.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.PathMappedEndpoints;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.concurrent.ExecutionException;

@Component
public class FileHandler {

//    private String DIR="C:\\Users\\shubh\\Developer\\springboot\\learnboot\\src\\main\\resources\\static\\storage\\";
    private String DIR=null;
    public FileHandler()
    {
        try {
            DIR=new ClassPathResource("static/storage").getFile().getAbsolutePath()+"\\";

        }catch ( Exception error)
        {
            error.printStackTrace();
        }
    }



    public boolean  save(MultipartFile part )
    {
        try {
            FileOutputStream file=new FileOutputStream(DIR+part.getOriginalFilename().toString());
            file.write(part.getBytes());
            file.close();
            return true;
        }catch ( Exception error ) {
            return false;
        }
    }
}
