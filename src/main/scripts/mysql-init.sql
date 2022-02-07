DROP DATABASE IF EXISTS personservice;
DROP USER IF EXISTS `person_service`@`%`;
CREATE DATABASE IF NOT EXISTS personservice CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `person_service`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,
CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `personservice`.* TO `person_service`@`%`;
FLUSH PRIVILEGES;

