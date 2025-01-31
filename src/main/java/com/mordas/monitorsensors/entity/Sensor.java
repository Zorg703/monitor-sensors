package com.mordas.monitorsensors.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 30)
    private String name;

    @NotBlank
    @Size(max = 15)
    private String model;

    @Embedded
    private Range range;

    @Enumerated(EnumType.STRING)
    private SensorType type;

    @Enumerated(EnumType.STRING)
    private Unit unit;

    @Size(max = 40)
    private String location;

    @Size(max = 200)
    private String description;
    }