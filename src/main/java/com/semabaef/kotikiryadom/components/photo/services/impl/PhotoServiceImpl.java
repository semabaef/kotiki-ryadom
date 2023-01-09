package com.semabaef.kotikiryadom.components.photo.services.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;
import com.semabaef.kotikiryadom.components.photo.dto.PhotoDtoResponse;
import com.semabaef.kotikiryadom.components.photo.services.PhotoService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {

    @Value("${aws.s3.bucket.name}")
    private String bucketName;

    private final AmazonS3 amazonS3;

    @Override
    public String saveFile(MultipartFile file, int directory) {
        String fileName = String.format("%s.%s", UUID.randomUUID(), getExtension(file.getOriginalFilename()));
        try {
            Map<String, String> metadata = new HashMap<>();

            metadata.put("Content-Type", file.getContentType());

            byte[] bytes = IOUtils.toByteArray(file.getInputStream());
            metadata.put("Content-Length", String.valueOf(bytes.length));

            ObjectMetadata objectMetadata = new ObjectMetadata();
            metadata.forEach(objectMetadata::addUserMetadata);

            PutObjectResult result = amazonS3.putObject(pathInBucket(directory), fileName, new ByteArrayInputStream(bytes), objectMetadata);
            return fileName;
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteFile(String fileName, int directory) {
        amazonS3.deleteObject(pathInBucket(directory), fileName);
    }

    @SneakyThrows
    public PhotoDtoResponse getFile(String fileName, int directory)  {
        S3Object object = amazonS3.getObject(new GetObjectRequest(pathInBucket(directory), fileName));
        InputStream objectData = object.getObjectContent();
        return PhotoDtoResponse.builder()
                .contentType(object.getObjectMetadata().getContentType())
                .length(object.getObjectMetadata().getContentLength())
                .photo(new InputStreamResource(new ByteArrayInputStream(objectData.readAllBytes())))
                .build();
    }

    private String getExtension(String fileName) {
        String[] slices = fileName.split("[.]");
        return slices[slices.length - 1];
    }

    //0 is directory for users avatar photo
    //1 is directory for cats photo
    private String pathInBucket(int i) {
        String[] dirNames = bucketName.split(";");
        return dirNames[i];
    }

}
