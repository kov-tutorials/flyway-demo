-- Address Table
CREATE TABLE flyway_demo_db.address
(
    id NUMERIC(19,0) PRIMARY KEY,
    address_1 VARCHAR(250),
    city VARCHAR(50),
    state VARCHAR(50),
    zip VARCHAR(50),
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);