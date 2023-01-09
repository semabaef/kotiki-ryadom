package com.semabaef.kotikiryadom.components.condition.repo;

import com.semabaef.kotikiryadom.components.condition.entity.Condition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConditionRepo extends JpaRepository<Condition, Long> {
}
