-- Database Creatioon
CREATE DATABASE java_mysql;

-- Table Structure
CREATE TABLE people (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  gender VARCHAR(6) NOT NULL,
  PRIMARY KEY (id),
  KEY idx_people_id (id)
);

-- Mock Data
INSERT INTO people (name, email, gender) 
VALUES ('Pilmore', 'kpilmore0@gizmodo.com', 'Male'),  
       ('Garber', 'rgarber1@myspace.com', 'Female'),  
       ('Clingoe', 'mclingoe2@weebly.com', 'Female'),  
       ('Cromb', 'acromb3@webeden.co.uk', 'Male'),  
       ('Ragles', 'sragles4@yolasite.com', 'Male'),  
       ('Leasor', 'cleasor5@icio.us', 'Female'),  
       ('Ugo', 'cugo6@wordpress.org', 'Male'),  
       ('Raveau', 'rraveau7@admin.ch', 'Female'),  
       ('McCrow', 'bmccrow8@latimes.com', 'Female'),  
       ('Toppes', 'ftoppes9@economist.com', 'Female');
