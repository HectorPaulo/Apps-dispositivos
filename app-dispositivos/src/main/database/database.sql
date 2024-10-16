CREATE TABLE device (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    modelo VARCHAR(255),
    so VARCHAR(255),
    ano INTEGER NOT NULL,
    es_root BOOLEAN NOT NULL,
    manufacturero VARCHAR(255)
);

CREATE TABLE app (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nombre VARCHAR(255),
    version VARCHAR(255),
    desarrollador VARCHAR(255),
    rating FLOAT NOT NULL,
    activo BOOLEAN NOT NULL
);

CREATE TABLE app_device (
    app_id BIGINT NOT NULL,
    device_id BIGINT NOT NULL,
    PRIMARY KEY (app_id, device_id),
    FOREIGN KEY (app_id) REFERENCES app(id),
    FOREIGN KEY (device_id) REFERENCES device(id)
);