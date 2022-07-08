package com.da.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.da.vo.FileVo;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AwsS3Service {
	
	private AmazonS3 s3Client;

    @Value("${cloud.aws.credentials.accessKey}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secretKey}")
    private String secretKey;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.region.static}")
    private String region;

    @PostConstruct
    public void setS3Client() {
        AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);

        s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(this.region)
                .build();
    }
    
    public List<FileVo> uploadFiles(List<MultipartFile> multipartFile, String dirName) {
        List<FileVo> fileList = new ArrayList<>();

        // forEach 구문을 통해 multipartFile로 넘어온 파일들 하나씩 fileNameList에 추가
        multipartFile.forEach(file -> {
            String fileName = createFileName(file.getOriginalFilename(), dirName);
            String fileUrl = "";
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(file.getSize());
            objectMetadata.setContentType(file.getContentType());

            try(InputStream inputStream = file.getInputStream()) {
            	s3Client.putObject(new PutObjectRequest(bucket, fileName, inputStream, objectMetadata)
                        .withCannedAcl(CannedAccessControlList.PublicRead));
            	fileUrl = getFile(bucket, fileName);
            } catch(IOException e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "파일 업로드에 실패했습니다.");
            }
            FileVo fileVo = FileVo.builder().fileNm(fileName).fileUrl(fileUrl).build();

            fileList.add(fileVo);
        });

        return fileList;
    }
    
    private String createFileName(String fileName, String dirName) { // 먼저 파일 업로드 시, 파일명을 난수화하기 위해 random으로 돌립니다.
        return dirName + "/" + UUID.randomUUID().toString().concat(fileName);
    }


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
    	s3Client.putObject(new PutObjectRequest(bucket, fileNm, uploadFile)
                .withCannedAcl(CannedAccessControlList.PublicRead));
        return getFile(bucket, fileNm);
    }

    private String getFile(String bucket, String fileNm) {
        return s3Client.getUrl(bucket, fileNm).toString();
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
        if (!s3Client.doesObjectExist(bucket, fileVo.getFileNm())) {
            throw new AmazonS3Exception("Object " +fileVo.getFileNm()+ " does not exist!");
        }
        s3Client.deleteObject(bucket, fileVo.getFileNm());
    }

	/**
	 * file 다운로드
	 *
	 * @param fileKey  파일 key 로 해당 버킷에서 파일 찾아서 들고옴
	 * @param downloadFileName 다운로드 파일명
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public boolean download(String fileKey, String downloadFileName, HttpServletRequest request, HttpServletResponse response){
	    if (fileKey == null) {
	        return false;
	    }
	    S3Object fullObject = null;
	    try {
	        fullObject = s3Client.getObject(bucket, fileKey);
	        if (fullObject == null) {
	            return false;
	        }
	    } catch (AmazonS3Exception e) {
	        throw new AmazonS3Exception("다운로드 파일이 존재하지 않습니다.");
	    }
	
	    OutputStream os = null;
	    FileInputStream fis = null;
	    boolean success = false;
	    try {
	        S3ObjectInputStream objectInputStream = fullObject.getObjectContent();
	        byte[] bytes = IOUtils.toByteArray(objectInputStream);
	
	        String fileName = null;
	        if(downloadFileName != null) {
	            //fileName= URLEncoder.encode(downloadFileName, "UTF-8").replaceAll("\\+", "%20");
	            fileName=  getEncodedFilename(request, downloadFileName);
	        } else {
	            fileName=  getEncodedFilename(request, fileKey); // URLEncoder.encode(fileKey, "UTF-8").replaceAll("\\+", "%20");
	        }
	
	        response.setContentType("application/octet-stream;charset=UTF-8");
	        response.setHeader("Content-Transfer-Encoding", "binary");
	        response.setHeader( "Content-Disposition", "attachment; filename=\"" + fileName + "\";" );
	        response.setHeader("Content-Length", String.valueOf(fullObject.getObjectMetadata().getContentLength()));
	        response.setHeader("Set-Cookie", "fileDownload=true; path=/");
	        FileCopyUtils.copy(bytes, response.getOutputStream());
	        success = true;
	    } catch (IOException e) {
	    	throw new AmazonS3Exception(e.getMessage(), e);
	    } finally {
	        try {
	            if (fis != null) {
	                fis.close();
	            }
	        } catch (IOException e) {
	        	throw new AmazonS3Exception(e.getMessage(), e);
	        }
	        try {
	            if (os != null) {
	                os.close();
	            }
	        } catch (IOException e) {
	        	throw new AmazonS3Exception(e.getMessage(), e);
	        }
	    }
	    return success;
	}

	private String getEncodedFilename(HttpServletRequest request, String displayFileName) throws UnsupportedEncodingException {
	    String header = request.getHeader("User-Agent");
	
	    String encodedFilename = null;
	    if (header.indexOf("MSIE") > -1) {
	        encodedFilename = URLEncoder.encode(displayFileName, "UTF-8").replaceAll("\\+", "%20");
	    } else if (header.indexOf("Trident") > -1) {
	        encodedFilename = URLEncoder.encode(displayFileName, "UTF-8").replaceAll("\\+", "%20");
	    } else if (header.indexOf("Chrome") > -1) {
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < displayFileName.length(); i++) {
	            char c = displayFileName.charAt(i);
	            if (c > '~') {
	                sb.append(URLEncoder.encode("" + c, "UTF-8"));
	            } else {
	                sb.append(c);
	            }
	        }
	        encodedFilename = sb.toString();
	    } else if (header.indexOf("Opera") > -1) {
	        encodedFilename = "\"" + new String(displayFileName.getBytes("UTF-8"), "8859_1") + "\"";
	    } else if (header.indexOf("Safari") > -1) {
	        encodedFilename = URLDecoder.decode("\"" + new String(displayFileName.getBytes("UTF-8"), "8859_1") + "\"", "UTF-8");
	    } else {
	        encodedFilename = URLDecoder.decode("\"" + new String(displayFileName.getBytes("UTF-8"), "8859_1") + "\"", "UTF-8");
	    }
	    return encodedFilename;
	
	}
}
