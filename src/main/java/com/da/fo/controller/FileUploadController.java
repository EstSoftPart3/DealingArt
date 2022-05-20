package com.da.fo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.da.common.AwsS3Service;
import com.da.vo.FileVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileUploadController {
	
	@Autowired
	private AwsS3Service awsS3Service;
	
    @PostMapping("/upload")
    public FileVo upload(@RequestPart("file") MultipartFile multipartFile) throws IOException {
    	System.out.println("######### file : " + multipartFile.getName());
        return awsS3Service.upload(multipartFile, "upload");
    }
    
    
    @PostMapping("/ckUpload")
    public FileVo ckUpload(@RequestPart("upload") MultipartFile multipartFile) throws IOException {
    	System.out.println("######### file : " + multipartFile.getName());
        return awsS3Service.upload(multipartFile, "upload");
    }

    @DeleteMapping("/delete")
    public void remove(FileVo fileVo) {
    	System.out.println("##################### Delete File : "+fileVo);
        awsS3Service.remove(fileVo);
    }

}
