use projectstudy;
create database projectstudy;

create table users(
	USERS_ID int not null auto_increment,
    USERS_EMAIL varchar(255),
    USERS_NAME varchar(255),
    USERS_PASSWORD varchar(255),
    primary key(USERS_ID, USERS_EMAIL)
);

create table studies(
	USERS_EMAIL varchar(255),
    IMG_NAME varchar(500)
);

select *
from users;

select *
from studies;

delete 
from users
where users_id = 3;


insert into studies(users_email, img_name)
values ('model9960@baver.com','/s_a5066e74-39be-4dc2-a175-d55abcbdcc99_4.jpg');

drop table studies;