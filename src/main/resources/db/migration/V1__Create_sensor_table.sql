CREATE TABLE sensor
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(30) NOT NULL,
    model       VARCHAR(15) NOT NULL,
    range_from  INT         NOT NULL,
    range_to    INT         NOT NULL,
    type        VARCHAR(20) NOT NULL,
    unit        VARCHAR(20),
    location    VARCHAR(40),
    description VARCHAR(200)
);