package com.semabaef.kotikiryadom.components.cat.services;

import com.semabaef.kotikiryadom.components.cat.dto.CatDtoRequest;
import com.semabaef.kotikiryadom.components.photo.dto.PhotoDtoResponse;
import org.springframework.web.multipart.MultipartFile;

public interface CatService {

    public void addNewCat(MultipartFile file, CatDtoRequest cat);

    public PhotoDtoResponse getCatsPhoto(Long id);
}
