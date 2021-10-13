# 1. Query to display all employees with their respective role and information
/*SELECT e.ID, full_name, email, phone, age, national_ID, roles.role_name FROM employees as e
join roles on e.role_id = roles.ID;*/

# 2.Query to display all employees within a specific project (referenced by project name)
/*SELECT full_name, email, age, role_id, project_employee.project_id FROM employees
JOIN project_employee ON employees.ID = project_employee.employee_id
where project_employee.project_id = (SELECT ID FROM projects WHERE project_name = "XYZ");*/

# 3.Query to add an employee to a certain project
/*INSERT INTO project_employee
VALUES 
(1,2,1);*/

# Bonus. Create a query that displays employees with a certain role who are currently not working on a project
/*select full_name, email, age, role_id from employees
left join project_employee as pe on employees.ID = pe.employee_id
where employees.role_id = 1 
and pe.project_id is null; */


