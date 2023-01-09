package com.semabaef.kotikiryadom.components.coordinates.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoordinatesDto {
    private Double latitude;
    private Double longitude;
}
