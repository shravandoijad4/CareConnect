CREATE TABLE patients (
                          id            BIGSERIAL PRIMARY KEY,
                          first_name    VARCHAR(100) NOT NULL,
                          last_name     VARCHAR(100) NOT NULL,
                          email         VARCHAR(255) NOT NULL UNIQUE,
                          phone         VARCHAR(20),
                          date_of_birth DATE,
                          gender        VARCHAR(20),
                          blood_group   VARCHAR(5),
                          created_at    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);