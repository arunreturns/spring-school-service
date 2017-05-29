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

DROP TABLE students CASCADE;
CREATE TABLE students (
  studentId SERIAL UNIQUE,
  studentName VARCHAR(25),
  studentEmail VARCHAR(25),
  parentEmail VARCHAR(25),
  dateOfBirth DATE, 
  PRIMARY KEY (studentName, dateOfBirth),
  ADDED_BY VARCHAR(25),
  ADD_DATE TIMESTAMP,
  UPD_BY VARCHAR(25),
  UPD_DATE TIMESTAMP NOT NULL DEFAULT now()
);

DROP TABLE teachers CASCADE;
CREATE TABLE teachers (
  teacherId SERIAL UNIQUE,
  teacherName VARCHAR(25),
  teacherSubject VARCHAR(45),
  yearsOfExperience INT,
  dateOfBirth DATE, 
  PRIMARY KEY (teacherName, dateOfBirth),
  ADDED_BY VARCHAR(25),
  ADD_DATE TIMESTAMP,
  UPD_BY VARCHAR(25),
  UPD_DATE TIMESTAMP NOT NULL DEFAULT now()
);

DROP TABLE marks CASCADE;
CREATE TABLE marks (
  markId SERIAL UNIQUE,
  subjectName VARCHAR(25), 
  marks INT, 
  studentId SERIAL REFERENCES students(studentId),
  studentName VARCHAR(25),
  teacherId SERIAL REFERENCES teachers(teacherId),
  awardedBy VARCHAR(25),
  ADDED_BY VARCHAR(25),
  ADD_DATE TIMESTAMP,
  UPD_BY VARCHAR(25),
  UPD_DATE TIMESTAMP NOT NULL DEFAULT now(),
  PRIMARY KEY (subjectName, studentName, marks)
);

DROP TABLE classes CASCADE;
CREATE TABLE classes (
  classId SERIAL UNIQUE,
  className VARCHAR(25),
  teacherInCharge VARCHAR(25),
  studentsInClass INT, 
  ADDED_BY VARCHAR(25),
  ADD_DATE TIMESTAMP,
  UPD_BY VARCHAR(25),
  UPD_DATE TIMESTAMP NOT NULL DEFAULT now(),
  PRIMARY KEY (className)
);