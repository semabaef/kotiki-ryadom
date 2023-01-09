package com.semabaef.kotikiryadom.components.coordinates.repo;

import com.semabaef.kotikiryadom.components.coordinates.entity.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinatesRepo extends JpaRepository<Coordinates,Long> {

        Coordinates findByLatitudeAndAndLongitude(double x, double y);

}
