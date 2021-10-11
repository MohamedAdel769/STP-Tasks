/*alter table employees
add role_id int NOT NULL default 1;

alter table employees
add foreign key (role_id) references roles(id);

alter table project_employee
drop role_id;*/