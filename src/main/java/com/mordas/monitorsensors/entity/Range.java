package com.mordas.monitorsensors.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Range {
    private Integer from;
    private Integer to;
}