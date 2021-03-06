drop table if exists clients;
create table clients (
    client_id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) PRIMARY KEY,
    client_name varchar(50) not null,
    email varchar(50) UNIQUE not null
);

drop table if exists currency;
create table currency (
    currency_id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) PRIMARY KEY,
    code varchar(5) UNIQUE not null
);

drop table if exists accounts;
create table accounts (
    account_id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) PRIMARY KEY,
    client_id INTEGER not null,
    currency_id INTEGER not null,
    balance DECIMAL(10,2) DEFAULT 0.00,
    CONSTRAINT CL_CURR_CONSTR UNIQUE (client_id, currency_id),
    FOREIGN KEY (client_id) REFERENCES clients(client_id),
    FOREIGN KEY (currency_id) REFERENCES currency(currency_id)
);

drop table if exists transfers;
create table transfers (
    transfer_id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) PRIMARY KEY,
    account_from_id INTEGER not null,
    account_to_id INTEGER not null,
    amount DECIMAL(10,2) DEFAULT 0.00,
    transfer_date TIMESTAMP,
    is_finished BIT,
    FOREIGN KEY (account_from_id) REFERENCES accounts(account_id),
    FOREIGN KEY (account_to_id) REFERENCES accounts(account_id)
);
