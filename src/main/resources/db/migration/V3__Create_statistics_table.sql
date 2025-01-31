CREATE TABLE sensor_statistics
(
    id                  SERIAL PRIMARY KEY,
    total_sensors       INT NOT NULL,
    pressure_sensors    INT NOT NULL,
    voltage_sensors     INT NOT NULL,
    temperature_sensors INT NOT NULL,
    humidity_sensors    INT NOT NULL,
    created_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);