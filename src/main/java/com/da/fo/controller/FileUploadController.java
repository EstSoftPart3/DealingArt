package com.da.fo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public FileVo upload(@RequestPart(value = "file") MultipartFile multipartFile, @RequestPart(value = "url") String url) throws IOException {
    	System.out.println("######### file : " + multipartFile.getName());
        return awsS3Service.upload(multipartFile, url);
    }
    
    
    @PostMapping("/ckUpload")
    public FileVo ckUpload(@RequestPart("upload") MultipartFile multipartFile, HttpServletResponse res, HttpServletRequest req) throws IOException {
    	System.out.println("######### file : " + multipartFile.getName());
    	
    	PrintWriter printWriter = null;
    	
    	FileVo fUrl = awsS3Service.upload(multipartFile, "upload");
    	
    	String fileUrl = fUrl.getFileUrl();
    	
    	System.out.println("######### fileUrl : " + fileUrl);
    	

        
		return fUrl;
        
        
        //return awsS3Service.upload(multipartFile, "upload");
    }

    @DeleteMapping("/delete")
    public void remove(FileVo fileVo) {
    	System.out.println("##################### Delete File : "+fileVo);
        awsS3Service.remove(fileVo);
    }

}
