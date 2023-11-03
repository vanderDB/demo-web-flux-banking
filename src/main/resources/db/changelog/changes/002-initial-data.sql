INSERT INTO "client" (first_name, last_name, email)
VALUES
    ('John', 'Doe', 'john@example.com'),
    ('Jane', 'Smith', 'jane@example.com'),
    ('Den', 'Show', 'den@example.com');

INSERT INTO "account" (client_id, account_type, account_number, balance, status)
VALUES
    (1, 'Savings', 123456, 1000.00, 'Active'),
    (1, 'Checking', 789011, 1530.00, 'Active'),
    (2, 'Checking', 789012, 2500.00, 'Active'),
    (2, 'Savings', 789013, 0.00, 'Active');

INSERT INTO "transaction" (account_id, transaction_type, amount, transaction_date)
VALUES
    (1, 'Deposit', 500.00, '2023-11-01 00:00:00'),
    (1, 'Withdrawal', 200.00, '2023-11-02 00:00:00'),
    (2, 'Deposit', 1000.00, '2023-11-03 00:00:00');