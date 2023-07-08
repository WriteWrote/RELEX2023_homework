ALTER TABLE ssr2023_hometask.users
    ADD COLUMN IF NOT EXISTS password   VARCHAR(100);