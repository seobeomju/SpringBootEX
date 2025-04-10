package org.zerock.sb7.util;

import jakarta.annotation.PostConstruct;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Log4j2
public class FileUploadUtil {

    @Value("${org.zerock.upload}")
    private String uploadDir;

    @PostConstruct
    public void ready()throws Exception{
        log.info("---------------post construct---------------");
        log.info("uploadDir: " + uploadDir);

        File uploadDirFile = new File(uploadDir);

        log.info("uploadDirFile: " + uploadDirFile.getAbsolutePath());

        if(!uploadDirFile.exists()){
            uploadDirFile.mkdirs();
        }
    }

    public List<String> uploadFiles (List<MultipartFile> files) throws Exception{

        List<String> uploadedFileNames = new ArrayList<>();

        if(files != null && !files.isEmpty()){

            for(MultipartFile file : files){

                String saveFileName = UUID.randomUUID().toString()+"_" + file.getOriginalFilename();

                Path path = Paths.get(uploadDir, saveFileName);

                //FileCopyUtils.copy(file.getBytes(), path.toFile());
                Files.copy(file.getInputStream(), path);

                String contentType = file.getContentType();

                if(contentType != null && contentType.startsWith("image")){ //이미지여부 확인

                    Path thumbnailPath = Paths.get(uploadDir, "s_"+saveFileName);

                    Thumbnails.of(path.toFile())
                            .size(400,400)
                            .toFile(thumbnailPath.toFile());
                }

                uploadedFileNames.add(saveFileName);

            }//end for

        }//end if


        return uploadedFileNames;
    }

    public ResponseEntity<Resource> getFile(String fileName) {

        Resource resource = new FileSystemResource(uploadDir+ File.separator + fileName);

        if(!resource.exists()) {

            resource = new FileSystemResource(uploadDir+ File.separator + "default.jpeg");

        }

        HttpHeaders headers = new HttpHeaders();

        try{
            headers.add("Content-Type", Files.probeContentType( resource.getFile().toPath() ));
        } catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().headers(headers).body(resource);
    }


}