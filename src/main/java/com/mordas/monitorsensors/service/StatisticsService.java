package com.mordas.monitorsensors.service;

import com.mordas.monitorsensors.entity.SensorStatistics;
import com.mordas.monitorsensors.entity.SensorType;
import com.mordas.monitorsensors.repository.SensorRepository;
import com.mordas.monitorsensors.repository.SensorStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class StatisticsService {
    private final SensorRepository sensorRepository;
    private final SensorStatisticsRepository statisticsRepository;

    public StatisticsService(SensorRepository sensorRepository, SensorStatisticsRepository statisticsRepository) {
        this.sensorRepository = sensorRepository;
        this.statisticsRepository = statisticsRepository;
    }

    @Scheduled(cron = "0 0 2 * * ?") //02:00
    public void collectStatistics() {
        int totalSensors = sensorRepository.findAll().size();
        int pressureSensors = sensorRepository.countByType(SensorType.PRESSURE);
        int voltageSensors = sensorRepository.countByType(SensorType.VOLTAGE);
        int temperatureSensors = sensorRepository.countByType(SensorType.TEMPERATURE);
        int humiditySensors = sensorRepository.countByType(SensorType.HUMIDITY);

        SensorStatistics statistics = new SensorStatistics();
        statistics.setTotalSensors(totalSensors);
        statistics.setPressureSensors(pressureSensors);
        statistics.setVoltageSensors(voltageSensors);
        statistics.setTemperatureSensors(temperatureSensors);
        statistics.setHumiditySensors(humiditySensors);
        statistics.setCreatedAt(LocalDateTime.now());

        statisticsRepository.save(statistics);
    }
}