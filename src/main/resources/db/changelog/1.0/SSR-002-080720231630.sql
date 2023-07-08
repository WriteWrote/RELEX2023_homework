CREATE TABLE ssr2023_hometask.users
(
    id   SERIAL PRIMARY KEY,
    user_name VARCHAR(25)
);

CREATE TABLE ssr2023_hometask.roles
(
    id   SERIAL PRIMARY KEY,
    role_name VARCHAR(10)
);

CREATE TABLE ssr2023_hometask.userroles(
    user_id     INTEGER REFERENCES ssr2023_hometask.users(id),
    role_id     INTEGER REFERENCES ssr2023_hometask.roles(id)
);

ALTER TABLE ssr2023_hometask.messages
    ADD COLUMN IF NOT EXISTS
        sender_id INTEGER REFERENCES ssr2023_hometask.users(id);

ALTER TABLE ssr2023_hometask.messages
    DROP COLUMN sender;