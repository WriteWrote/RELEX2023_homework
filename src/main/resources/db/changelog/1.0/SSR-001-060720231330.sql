CREATE SCHEMA SSR2023_HOMETASK;

CREATE TABLE SSR2023_HOMETASK.messages(
    id      SERIAL PRIMARY KEY ,
    sender  VARCHAR(25) NOT NULL ,
    text    VARCHAR(1000) NOT NULL
);

INSERT INTO SSR2023_HOMETASK.messages VALUES (0, 'AUTHOR 1', 'hELLO wORLD!');
INSERT INTO SSR2023_HOMETASK.messages VALUES (1, 'AUTHOR 2', 'Hello World!');
INSERT INTO SSR2023_HOMETASK.messages VALUES (2, 'AUTHOR 3', 'HELLO WORLD!');
INSERT INTO SSR2023_HOMETASK.messages VALUES (3, 'AUTHOR 1', 'BUE WORLD.');