package com.mordas.monitorsensors.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class SensorStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalSensors;
    private int pressureSensors;
    private int voltageSensors;
    private int temperatureSensors;
    private int humiditySensors;

    private LocalDateTime createdAt;
}
