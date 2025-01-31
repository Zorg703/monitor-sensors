CREATE TYPE sensor_type AS ENUM ('PRESSURE', 'VOLTAGE', 'TEMPERATURE', 'HUMIDITY');
CREATE TYPE unit_type AS ENUM ('BAR', 'VOLTAGE', 'CELSIUS', 'PERCENT');

ALTER TABLE sensor
    ALTER COLUMN type TYPE sensor_type USING type::sensor_type,
    ALTER COLUMN unit TYPE unit_type USING unit::unit_type;