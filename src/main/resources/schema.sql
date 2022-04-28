DROP TABLE IF EXISTS hardware;

CREATE TABLE hardware(
    id INT IDENTITY PRIMARY KEY,
    code VARCHAR(255) NOT NULL unique ,
    name VARCHAR(255) NOT NULL,
    price FLOAT,
    type VARCHAR(50) NOT NULL,
    on_storage INT
);