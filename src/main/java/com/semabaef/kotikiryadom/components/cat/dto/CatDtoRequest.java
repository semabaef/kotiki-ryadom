package com.semabaef.kotikiryadom.components.cat.dto;

import com.semabaef.kotikiryadom.components.coordinates.dto.CoordinatesDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CatDtoRequest {
    private CoordinatesDto coordinates;
    private Long conditionId;
    private String name;
    private String description;
}
