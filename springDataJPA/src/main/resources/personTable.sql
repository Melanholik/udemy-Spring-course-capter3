delete
from person
where id > 0;

SELECT *
FROM person;

DROP TABLE person;

CREATE TABLE person
(
    id    INT GENERATED BY DEFAULT AS IDENTITY,
    name  VARCHAR(200),
    age   INT CHECK ( age > 0 and  age < 130),
    email VARCHAR UNIQUE ,
    address VARCHAR
);

CREATE TABLE person
(
    id    int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name  varchar NOT NULL,
    age   int check ( age > 0),
    email varchar UNIQUE
);

INSERT INTO person(name, age, email, address)
VALUES ('Tom', 33, 'tom@gmail.com', 'Belarus, Baranovichy, 123456'),
        ('Kate', 18, 'Kate@ya.ru', 'Belarus, Minsk, 222222'),
        ('Sergey', 34, 'Sergey@ya.ru', 'Russia, Moscow, 333333');



SELECT *
FROM item;

-- Просто дата без точного времени (03/04/2000)
ALTER TABLE person ADD COLUMN data_of_birth DATE;


--Точное время
--Значение timestamp сохраняются в секундах до или после 1 января 2000г
ALTER TABLE person ADD COLUMN created_at TIMESTAMP;

ALTER TABLE person DROP COLUMN created_at;

DELETE FROM person WHERE id = 7;

ALTER TABLE person ADD COLUMN mood VARCHAR;