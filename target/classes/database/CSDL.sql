CREATE DATABASE IF NOT EXISTS `qlnsavas`;

USE `qlnsavas`;


CREATE TABLE `login`
(
    `username` VARCHAR(255) PRIMARY KEY,
    `password` VARCHAR(255) NOT NULL
);
INSERT INTO `login`(username, password) VALUES ('admin', '123456');

CREATE TABLE department
(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    manager_id      INT,
    department_name VARCHAR(255),
    description     VARCHAR(255),
    is_deleted      TINYINT(2) DEFAULT 0
);

CREATE TABLE `employee`
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    fullName      VARCHAR(255),
    address       VARCHAR(555),
    phone         VARCHAR(20),
    gender        VARCHAR(20),
    position      VARCHAR(100),
    department_id INT,
    isDeleted     TINYINT(2) DEFAULT 0,
    CONSTRAINT fk_employee_department FOREIGN KEY (department_id) REFERENCES department (id)
);



CREATE TABLE reward
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    title       VARCHAR(255) NOT NULL,
    description VARCHAR(666),
    employee_id INT,
    CONSTRAINT fk_reward_employee FOREIGN KEY (employee_id) REFERENCES employee (id)
);

CREATE TABLE salary
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    employee_id   INT,
    salary_amount FLOAT,
    salary_date   VARCHAR(255),
    detail        VARCHAR(255),
    CONSTRAINT fk_salary_employee FOREIGN KEY (employee_id) REFERENCES employee (id)
);


ALTER TABLE department
    ADD FOREIGN KEY (manager_id) REFERENCES employee (id);