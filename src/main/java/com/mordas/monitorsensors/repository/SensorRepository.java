package com.mordas.monitorsensors.repository;

import com.mordas.monitorsensors.entity.Sensor;
import com.mordas.monitorsensors.entity.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor> findByNameContainingOrModelContaining(String name, String model);

    @Query("SELECT COUNT(s) FROM Sensor s WHERE s.type = :type")
    int countByType(@Param("type") SensorType type);
}