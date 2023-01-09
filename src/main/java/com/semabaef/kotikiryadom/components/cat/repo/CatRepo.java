package com.semabaef.kotikiryadom.components.cat.repo;

import com.semabaef.kotikiryadom.components.cat.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepo extends JpaRepository<Cat,Long> {

}
