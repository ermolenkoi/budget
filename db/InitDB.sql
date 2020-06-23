DROP SCHEMA IF EXISTS budget CASCADE ;

CREATE SCHEMA budget
    AUTHORIZATION postgres;

CREATE TABLE budget.article
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    description VARCHAR(20)
);

INSERT INTO budget.article(
    name, description)
VALUES ('бензин', 'мой авто');

INSERT INTO budget.article(
    name, description)
VALUES ('продукты', 'магнит');