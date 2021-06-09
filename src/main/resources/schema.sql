DROP TABLE authority;
DROP TABLE accounts;

CREATE TABLE IF NOT EXISTS accounts (
id serial PRIMARY KEY,
username VARCHAR(45) NOT NULL,
password varchar(255) NOT NULL,
is_enabled BOOLEAN NOT NULL default true
);

CREATE TABLE IF NOT EXISTS authority (
  id serial PRIMARY KEY,
  name VARCHAR(45) NOT NULL,
  user_id bigint not null ,
  FOREIGN KEY (user_id)
    REFERENCES accounts (id)
  );

CREATE TABLE IF NOT EXISTS product
(
  id    serial PRIMARY KEY,
  name  VARCHAR(45)   NOT NULL,
  price NUMERIC(3, 2) NOT NULL
);