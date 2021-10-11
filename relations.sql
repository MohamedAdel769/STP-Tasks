ALTER TABLE projects
ADD project_manager int;

ALTER TABLE projects
ADD FOREIGN KEY (project_manager) REFERENCES employees(id);

CREATE TABLE IF NOT EXISTS project_employee
(
	employee_id int,
    project_id int,
    role_id int,
    PRIMARY KEY (employee_id, project_id),
    FOREIGN KEY (employee_id) REFERENCES employees(id),
    FOREIGN KEY (project_id) REFERENCES projects(id)
);