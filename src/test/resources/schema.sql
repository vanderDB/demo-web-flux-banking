CREATE TABLE IF NOT EXISTS "client" (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255) UNIQUE
);

CREATE TABLE IF NOT EXISTS "account" (
    id BIGSERIAL PRIMARY KEY,
    client_id BIGINT,
    account_type VARCHAR(255),
    account_number BIGINT,
    balance DOUBLE PRECISION,
    status VARCHAR(255),
    FOREIGN KEY (client_id) REFERENCES "client" (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "transaction" (
    id BIGSERIAL PRIMARY KEY,
    account_id BIGINT,
    transaction_type VARCHAR(255),
    amount DOUBLE PRECISION,
    transaction_date TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES "account" (id) ON DELETE CASCADE
);