DROP TABLE IF EXISTS Person;

CREATE TABLE IF NOT EXISTS Person(
    id int PRIMARY KEY ,
    name VARCHAR,
    age INT
);

INSERT INTO Person(id, name, age) VALUES (1, 'Vitaliy', 35);

SELECT * FROM Person;
