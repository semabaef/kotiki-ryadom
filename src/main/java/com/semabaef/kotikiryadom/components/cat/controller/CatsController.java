package com.semabaef.kotikiryadom.components.cat.controller;

import com.semabaef.kotikiryadom.components.cat.dto.CatDtoRequest;
import com.semabaef.kotikiryadom.components.cat.services.CatService;
import com.semabaef.kotikiryadom.components.coordinates.dto.CoordinatesDto;
import com.semabaef.kotikiryadom.components.photo.dto.PhotoDtoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.semabaef.kotikiryadom.common.endpoints.KotikyRyadomEndpoints.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = MAIN_URL)
public class CatsController {

    private final CatService catService;

    @PostMapping(value = CATS, consumes = "multipart/form-data")
    public ResponseEntity<String> addCat(@RequestParam("file") MultipartFile file, Double x, Double y, Long conditionId, String name, String description) {
        CatDtoRequest cat = CatDtoRequest.builder()
                .coordinates(CoordinatesDto.builder().latitude(x).longitude(y).build())
                .conditionId(conditionId)
                .name(name)
                .description(description)
                .build();
        catService.addNewCat(file, cat);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = CATS_PHOTO, produces = "multipart/form-data")
    public ResponseEntity<?> getCatsPhoto(@PathVariable Long id) {
        PhotoDtoResponse photo = catService.getCatsPhoto(id);
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(photo.getContentType()))
                .contentLength(photo.getLength())
                .body(photo.getPhoto());
    }
}
