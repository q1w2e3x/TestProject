CREATE USER 'test_project_user'@'localhost' IDENTIFIED BY '1234';
CREATE DATABASE test_project;
GRANT ALL ON test_project.* TO 'test_project_user'@'localhost';
