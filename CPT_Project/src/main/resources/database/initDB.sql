CREATE TABLE IF NOT EXISTS roles_users
    (id SERIAL primary key not null,
     name_role VARCHAR(15) not null);

CREATE TABLE IF NOT EXISTS faces
    (id SERIAL primary key not null,
     name_face VARCHAR(255));

CREATE TABLE IF NOT EXISTS users
    (id SERIAL primary key not null ,
     first_name VARCHAR(255) not null ,
     last_name VARCHAR(255) not null ,
     patronymic VARCHAR(255) ,
     email VARCHAR (255) not null ,
     login_user VARCHAR (15) not null ,
     password_user VARCHAR (30) not null ,
     id_role SERIAL references roles_users(id) not null ,
     id_face SERIAL references faces(id) not null );

CREATE TABLE IF NOT EXISTS query
    (id SERIAL primary key not null ,
     name_query VARCHAR(255) not null ,
     description VARCHAR(500) not null);

CREATE TABLE IF NOT EXISTS directions
    (id SERIAL primary key not null ,
     name_directions VARCHAR(255) not null);

CREATE TABLE IF NOT EXISTS offers
    (id SERIAL primary key not null ,
     id_user SERIAL references users(id) not null ,
     id_directions SERIAL references directions(id) not null ,
     file bytea not null,
     date_offers DATE DEFAULT CURRENT_DATE
         );

