\connect educore_student;
CREATE SCHEMA IF NOT EXISTS app;
CREATE SCHEMA IF NOT EXISTS liquibase;
GRANT ALL ON SCHEMA app TO maathan;
GRANT ALL ON SCHEMA liquibase TO maathan;