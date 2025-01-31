package com.mordas.monitorsensors.repository;

import com.mordas.monitorsensors.entity.SensorStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface SensorStatisticsRepository extends JpaRepository<SensorStatistics, Long> {
    List<SensorStatistics> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);
}