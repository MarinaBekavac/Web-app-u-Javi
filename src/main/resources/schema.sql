DROP TABLE IF EXISTS hardware;

CREATE TABLE hardware(
    id INT IDENTITY PRIMARY KEY,
    code VARCHAR(255) NOT NULL unique ,
    name VARCHAR(255) NOT NULL,
    price FLOAT,
    type VARCHAR(50) NOT NULL,
    on_storage INT
);

DROP TABLE IF EXISTS review;

create table review(
    id int identity primary key,
    hardware_id int not null,
    title varchar(100) not null,
    description varchar(255) not null,
    rating varchar(50) not null,
    foreign key (hardware_id) references hardware(id)
);