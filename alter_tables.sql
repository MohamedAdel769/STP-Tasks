alter table employees
add role_ID int NOT NULL default 1;

alter table employees
add foreign key (role_ID) references roles(roles_ID);
