create table users (
  id                    bigserial,
  username              varchar(30) not null,
  password              varchar(80) not null,
  primary key (id)
);

create table scores (
  id                     bigserial,
  user                   bigserial,
  value                  int not null default 0,
  primary key (id)
);

insert into users (username, password)
values
('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i');
