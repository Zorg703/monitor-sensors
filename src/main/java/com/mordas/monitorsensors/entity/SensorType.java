package com.mordas.monitorsensors.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

public enum SensorType {
    PRESSURE, VOLTAGE, TEMPERATURE, HUMIDITY
}
