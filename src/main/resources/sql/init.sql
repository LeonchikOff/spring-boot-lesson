create table if not exists company(
    id serial primary key,
    name varchar(128) unique not null
);

create table if not exists employee(
    id serial primary key,
    first_name varchar(128) not null,
    last_name varchar(128) not null,
    birth_day date,
    salary integer not null,
    company_id integer references company(id)
);