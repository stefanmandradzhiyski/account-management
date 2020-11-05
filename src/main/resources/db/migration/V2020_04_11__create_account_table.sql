CREATE TABLE IF NOT EXISTS account (
    id BIGSERIAL,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    email VARCHAR(320) UNIQUE NOT NULL,
    date_of_birth DATE NOT NULL,
    CONSTRAINT account_pk PRIMARY KEY (id)
);

CREATE UNIQUE INDEX IF NOT EXISTS account_email_idx ON account (email);