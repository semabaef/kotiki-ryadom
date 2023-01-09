package com.semabaef.kotikiryadom.common.converters;

import com.semabaef.kotikiryadom.components.cat.dto.CatDtoRequest;
import com.semabaef.kotikiryadom.components.cat.entity.Cat;
import com.semabaef.kotikiryadom.components.coordinates.dto.CoordinatesDto;
import com.semabaef.kotikiryadom.components.coordinates.entity.Coordinates;
import org.springframework.stereotype.Component;

@Component
public class DtoConverter {

    public Coordinates convertCoorDtoToEntity(CoordinatesDto dto){
        Coordinates coordinates = new Coordinates();
        coordinates.setLatitude(dto.getLatitude());
        coordinates.setLongitude(dto.getLongitude());
        return coordinates;
    }

    public Cat convertCatDtoToEntity(CatDtoRequest dto){
        Cat cat = new Cat();
        cat.setName(dto.getName());
        cat.setDescription(dto.getDescription());
        return cat;
    }
}
