CREATE SCHEMA IF NOT EXISTS app;
CREATE SCHEMA IF NOT EXISTS liquibase;

GRANT ALL ON SCHEMA app TO current_user;
GRANT ALL ON SCHEMA liquibase TO current_user;

ALTER ROLE current_user SET search_path TO app, liquibase, public;