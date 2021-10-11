CREATE TABLE IF NOT EXISTS Employees 
(
	ID INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(50) NOT NULL,
    email VARCHAR(250) NOT NULL UNIQUE,
    phone CHAR(10) NOT NULL,
    age TINYINT NOT NULL,
    national_ID CHAR(14) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS Projects
(
	ID INT AUTO_INCREMENT PRIMARY KEY,
    project_name VARCHAR(50) NOT NULL UNIQUE,
    start_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS Roles
(
	ID INT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(100) NOT NULL,
    department VARCHAR(50) NOT NULL
);