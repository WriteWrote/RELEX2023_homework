CREATE SCHEMA SSR2023_HOMETASK;

CREATE TABLE ssr2023_hometask.users
(
    id        SERIAL PRIMARY KEY,
    user_name VARCHAR(25),
    password  VARCHAR(200)
);

INSERT INTO ssr2023_hometask.users
VALUES (1, 'admin',
        'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbjIiLCJpYXQiOjE2ODg5MDM4NzcsImV4cCI6MTY4ODkwMzk0N30.grCTg_3SAAl_yJ1AfPiXIJKrw50V91fJeFcD6bKkION8F2p-IUFQ1g-bmQwCPALt8Mi8U6erYqoIc86CzkLsrg');

CREATE TABLE ssr2023_hometask.roles
(
    id        SERIAL PRIMARY KEY,
    role_name VARCHAR(10)
);

INSERT INTO SSR2023_HOMETASK.roles
VALUES (0, 'ADMIN');
INSERT INTO SSR2023_HOMETASK.roles
VALUES (1, 'USER');

CREATE TABLE ssr2023_hometask.userroles
(
    user_id INTEGER REFERENCES ssr2023_hometask.users (id),
    role_id INTEGER REFERENCES ssr2023_hometask.roles (id)
);

INSERT INTO ssr2023_hometask.userroles
VALUES (1, 0);

CREATE TABLE SSR2023_HOMETASK.messages
(
    id        SERIAL PRIMARY KEY,
    text      VARCHAR(1000) NOT NULL,
    sender_id INTEGER REFERENCES ssr2023_hometask.users (id)
);

INSERT INTO ssr2023_hometask.messages
VALUES (1, 'hELLO wORLD!', 1);