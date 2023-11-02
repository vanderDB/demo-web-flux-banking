CREATE TABLE IF NOT EXISTS "user" (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS "account" (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT,
    account_type VARCHAR(255),
    account_number BIGINT,
    balance DOUBLE PRECISION,
    status VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES "user" (id)
);

CREATE TABLE IF NOT EXISTS "transaction" (
    id SERIAL PRIMARY KEY,
    account_id BIGINT,
    transaction_type VARCHAR(255),
    amount DOUBLE PRECISION,
    transaction_date DATE,
    FOREIGN KEY (account_id) REFERENCES "account" (id)
);