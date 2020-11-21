CREATE TABLE flyway_db.address
(
    id SERIAL PRIMARY KEY,
    address_1 VARCHAR(250),
    address_2 VARCHAR(250),
    city VARCHAR(50),
    state VARCHAR(50),
    zip VARCHAR(50),
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);