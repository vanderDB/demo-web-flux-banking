INSERT INTO "user" (first_name, last_name, email)
VALUES
    ('John', 'Doe', 'john@example.com'),
    ('Jane', 'Smith', 'jane@example.com');

INSERT INTO "account" (user_id, account_type, account_number, balance, status)
VALUES
    (1, 'Savings', 123456, 1000.00, 'Active'),
    (2, 'Checking', 789012, 2500.00, 'Active');

INSERT INTO "transaction" (account_id, transaction_type, amount, transaction_date)
VALUES
    (1, 'Deposit', 500.00, '2023-11-01'),
    (1, 'Withdrawal', 200.00, '2023-11-02'),
    (2, 'Deposit', 1000.00, '2023-11-03');