TRUNCATE TABLE ssr2023_hometask.users;
TRUNCATE TABLE ssr2023_hometask.userroles;
TRUNCATE TABLE ssr2023_hometask.messages;

INSERT INTO ssr2023_hometask.users
    VALUES (1, 'admin', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbjIiLCJpYXQiOjE2ODg5MDM4NzcsImV4cCI6MTY4ODkwMzk0N30.grCTg_3SAAl_yJ1AfPiXIJKrw50V91fJeFcD6bKkION8F2p-IUFQ1g-bmQwCPALt8Mi8U6erYqoIc86CzkLsrg');

INSERT INTO ssr2023_hometask.userroles
    VALUES (1,0);

INSERT INTO ssr2023_hometask.messages
    VALUES (1, 'hELLO wORLD!', 1);