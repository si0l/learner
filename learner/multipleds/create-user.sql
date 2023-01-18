create table User (id integer not null, age integer not null, email varchar(255) not null, name varchar(255), primary key (id)) engine=InnoDB;
alter table User add constraint UK_e6gkqunxajvyxl5uctpl2vl2p unique (email);
create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values ( 1 );
