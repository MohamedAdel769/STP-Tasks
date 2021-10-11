CREATE TABLE IF NOT EXISTS project_employee
(
    employee_id int,
    project_id int,
    PRIMARY KEY (employee_id, project_id),
    FOREIGN KEY (employee_id) REFERENCES employees(emp_ID),
    FOREIGN KEY (project_id) REFERENCES projects(proj_ID)
);
