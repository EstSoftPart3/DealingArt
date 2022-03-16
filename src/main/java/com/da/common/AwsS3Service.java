package com.da.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.da.vo.FileVo;

import lombok.RequiredArgsConstructor;




@Service
@RequiredArgsConstructor
public class AwsS3Service {


    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public FileVo upload(MultipartFile multipartFile, String dirName) throws IOException {
		File file = convertMultipartFileToFile(multipartFile) .orElseThrow(() -> new
		IllegalArgumentException("MultipartFile -> File convert fail"));
        return upload(file, dirName);
    }

    private FileVo upload(File file, String dirName) {
        String fileNm = randomFileName(file, dirName);
        String fileUrl = putFile(file, fileNm);
        removeFile(file);

        return FileVo.builder().fileNm(fileNm).fileUrl(fileUrl).build();
    }

    private String randomFileName(File file, String dirName) {
        return dirName + "/" + UUID.randomUUID() + file.getName();
    }

    private String putFile(File uploadFile, String fileNm) {
        amazonS3.putObject(new PutObjectRequest(bucket, fileNm, uploadFile)
                .withCannedAcl(CannedAccessControlList.PublicRead));
        return getFile(bucket, fileNm);
    }

    private String getFile(String bucket, String fileNm) {
        return amazonS3.getUrl(bucket, fileNm).toString();
    }

    private void removeFile(File file) {
        file.delete();
    }

    public Optional<File> convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(System.getProperty("user.dir") + "/" + multipartFile.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(file)){
            fos.write(multipartFile.getBytes());
            return Optional.of(file);
        }catch (Exception e) {
        	return Optional.empty();
		}
    }

    public void remove(FileVo fileVo) {
    	System.out.println("####### Delete File : "+fileVo);
        if (!amazonS3.doesObjectExist(bucket, fileVo.getFileNm())) {
            throw new AmazonS3Exception("Object " +fileVo.getFileNm()+ " does not exist!");
        }
        amazonS3.deleteObject(bucket, fileVo.getFileNm());
    }
}

