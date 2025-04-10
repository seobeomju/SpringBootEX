package org.zerock.sb7.util;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Log4j2
@RequiredArgsConstructor
public class FileUploadUtil  {

    @Value("${org.zerock.upload}")
    private String uploadDir;

    @PostConstruct
    public void ready()throws IOException {
        log.info("-------post construct-------------");
        log.info("uploadDir:" + uploadDir);

        File uploadDirFile = new File(uploadDir);
        if(!uploadDirFile.exists()){
            uploadDirFile.mkdirs();
        }
    }

    public List<String> uploadFiles(List<MultipartFile> files) throws IOException {

        List<String> uploadedFiles = new ArrayList<>();
        return uploadedFiles;
    }

}
