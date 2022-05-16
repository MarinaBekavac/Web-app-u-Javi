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

create table if not exists user (
    id identity,
    username varchar(100) not null unique,
    password varchar(1000) not null
    );
create table if not exists authority (
     id identity,
     authority_name varchar(100) not null unique
    );
create table if not exists user_authority (
    user_id bigint not null,
    authority_id bigint not null,
    constraint fk_user foreign key (user_id) references user(id),
    constraint fk_authority foreign key (authority_id) references authority(id)
    );
