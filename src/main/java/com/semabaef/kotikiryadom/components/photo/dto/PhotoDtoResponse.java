package com.semabaef.kotikiryadom.components.photo.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.core.io.InputStreamResource;

@Data
@Builder
public class PhotoDtoResponse {
    String fileName;
    String contentType;
    long length;
    InputStreamResource photo;
}
