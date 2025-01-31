package com.mordas.monitorsensors.service;

import com.mordas.monitorsensors.entity.Sensor;
import com.mordas.monitorsensors.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {
    private final SensorRepository sensorRepository;

    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public Sensor createSensor(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    public Sensor getSensorById(Long id) {
        return sensorRepository.findById(id).orElseThrow(() -> new RuntimeException("Sensor not found"));
    }

    public Sensor updateSensor(Long id, Sensor sensor) {
        Sensor existingSensor = getSensorById(id);
        existingSensor.setName(sensor.getName());
        existingSensor.setModel(sensor.getModel());
        existingSensor.setRange(sensor.getRange());
        existingSensor.setType(sensor.getType());
        existingSensor.setUnit(sensor.getUnit());
        existingSensor.setLocation(sensor.getLocation());
        existingSensor.setDescription(sensor.getDescription());
        return sensorRepository.save(existingSensor);
    }

    public void deleteSensor(Long id) {
        sensorRepository.deleteById(id);
    }

    public List<Sensor> searchSensors(String query) {
        return sensorRepository.findByNameContainingOrModelContaining(query, query);
    }
}