package com.semabaef.kotikiryadom.components.photo.services;

import com.semabaef.kotikiryadom.components.photo.dto.PhotoDtoResponse;
import org.springframework.web.multipart.MultipartFile;

public interface PhotoService {
     String saveFile(MultipartFile file, int directory);
     void deleteFile(String fileName, int directory);
     PhotoDtoResponse getFile(String fileName, int directory);

}
