CREATE TABLE IF NOT EXISTS projects
(
	proj_ID INT AUTO_INCREMENT PRIMARY KEY,
    project_name VARCHAR(50) NOT NULL UNIQUE,
    start_date DATE NOT NULL,
    project_manager INT NOT NULL,
    FOREIGN KEY (project_manager) REFERENCES employees(emp_ID)
);
