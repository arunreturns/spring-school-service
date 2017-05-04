DROP TABLE users CASCADE;
CREATE TABLE users(
  userId SERIAL, 
  userName VARCHAR(25) UNIQUE,
  userRole VARCHAR(15), 
  isAdmin boolean,
  PRIMARY KEY (userId, userName),
  ADDED_BY VARCHAR(25),
  ADD_DATE TIMESTAMP,
  UPD_BY VARCHAR(25),
  UPD_DATE TIMESTAMP NOT NULL DEFAULT now()
);

INSERT INTO users (added_by, add_date, userName, userRole, isAdmin) VALUES ('adminuser', now(), 'adminuser', 'admin', true);
SELECT * FROM users;

DROP TABLE students CASCADE;
CREATE TABLE students (
  studentId SERIAL UNIQUE,
  studentName VARCHAR(25), 
  dateOfBirth DATE, 
  PRIMARY KEY (studentName, dateOfBirth),
  ADDED_BY VARCHAR(25),
  ADD_DATE TIMESTAMP,
  UPD_BY VARCHAR(25),
  UPD_DATE TIMESTAMP NOT NULL DEFAULT now()
);

DROP TABLE marks CASCADE;
CREATE TABLE marks (
  subjectName VARCHAR(25), 
  marks INT, 
  studentId SERIAL REFERENCES students(studentId),
  studentName VARCHAR(25),
  ADDED_BY VARCHAR(25),
  ADD_DATE TIMESTAMP,
  UPD_BY VARCHAR(25),
  UPD_DATE TIMESTAMP NOT NULL DEFAULT now(),
  PRIMARY KEY (subjectName, studentName, marks)
);