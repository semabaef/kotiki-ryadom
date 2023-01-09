package com.semabaef.kotikiryadom.components.cat.services.impl;

import com.semabaef.kotikiryadom.common.converters.DtoConverter;
import com.semabaef.kotikiryadom.common.converters.EntityConverter;
import com.semabaef.kotikiryadom.components.cat.dto.CatDtoRequest;
import com.semabaef.kotikiryadom.components.cat.entity.Cat;
import com.semabaef.kotikiryadom.components.cat.repo.CatRepo;
import com.semabaef.kotikiryadom.components.cat.services.CatService;
import com.semabaef.kotikiryadom.components.condition.repo.ConditionRepo;
import com.semabaef.kotikiryadom.components.coordinates.entity.Coordinates;
import com.semabaef.kotikiryadom.components.coordinates.repo.CoordinatesRepo;
import com.semabaef.kotikiryadom.components.photo.dto.PhotoDtoResponse;
import com.semabaef.kotikiryadom.components.photo.services.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CatServiceImpl implements CatService {

    private final PhotoService photoService;

    private final CatRepo catRepo;
    private final CoordinatesRepo coordinatesRepo;

    private final ConditionRepo conditionRepo;
    private final DtoConverter dtoConverter;

    private final EntityConverter entityConverter;

    @Override
    @Transactional
    public void addNewCat(MultipartFile file, CatDtoRequest catDto) {
        //  if(imageProcessingService.detectiveCatInImage())
        String photoUrl = photoService.saveFile(file, 1);
        Coordinates coordinatesNew = dtoConverter.convertCoorDtoToEntity(catDto.getCoordinates());
        Coordinates coordinatesOld = coordinatesRepo.findByLatitudeAndAndLongitude(coordinatesNew.getLatitude(), coordinatesNew.getLongitude());
        if (coordinatesOld == null)
            coordinatesRepo.save(coordinatesNew);
        else
            coordinatesNew = coordinatesOld;
        Cat cat = dtoConverter.convertCatDtoToEntity(catDto);
        cat.setCoordinates(coordinatesNew);
        cat.setCondition(conditionRepo.getById(catDto.getConditionId()));
        cat.setPhotoUrl(photoUrl);
        catRepo.save(cat);


    }

    @Override
    public PhotoDtoResponse getCatsPhoto(Long id) {
        return photoService.getFile(catRepo.getById(id).getPhotoUrl(), 1);
    }
}
