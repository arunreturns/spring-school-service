DROP TABLE IF EXISTS users CASCADE;
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

DROP TABLE IF EXISTS students CASCADE;
CREATE TABLE students (
  studentId SERIAL UNIQUE,
  studentName VARCHAR(25),
  studentClass VARCHAR(10) REFERENCES classroom(classroomName),
  studentEmail VARCHAR(25),
  parentEmail VARCHAR(25),
  dateOfBirth DATE, 
  PRIMARY KEY (studentName, dateOfBirth),
  ADDED_BY VARCHAR(25),
  ADD_DATE TIMESTAMP,
  UPD_BY VARCHAR(25),
  UPD_DATE TIMESTAMP NOT NULL DEFAULT now()
);

DROP TABLE IF EXISTS staff CASCADE;
CREATE TABLE staff (
  staffId SERIAL UNIQUE,
  staffName VARCHAR(25),
  dateOfBirth DATE,
  staffRole VARCHAR(20),
  PRIMARY KEY (staffName, dateOfBirth),
  ADDED_BY VARCHAR(25),
  ADD_DATE TIMESTAMP,
  UPD_BY VARCHAR(25),
  UPD_DATE TIMESTAMP NOT NULL DEFAULT now()
);

DROP TABLE IF EXISTS teachers CASCADE;
CREATE TABLE teachers (
  teacherId SERIAL UNIQUE,
  teacherName VARCHAR(25),
  yearsOfExperience INT,
  dateOfBirth DATE,
  joiningDate DATE,
  PRIMARY KEY (teacherName, dateOfBirth),
  ADDED_BY VARCHAR(25),
  ADD_DATE TIMESTAMP,
  UPD_BY VARCHAR(25),
  UPD_DATE TIMESTAMP NOT NULL DEFAULT now()
);

DROP TABLE IF EXISTS subject CASCADE;
CREATE TABLE subject (
  subjectId SERIAL UNIQUE,
  subjectName VARCHAR(25) UNIQUE,
  ADDED_BY VARCHAR(25),
  ADD_DATE TIMESTAMP,
  UPD_BY VARCHAR(25),
  UPD_DATE TIMESTAMP NOT NULL DEFAULT now()
);

DROP TABLE IF EXISTS timetable CASCADE;
CREATE TABLE timetable (
  timetableId SERIAL UNIQUE,
  periods text[],
  ADDED_BY VARCHAR(25),
  ADD_DATE TIMESTAMP,
  UPD_BY VARCHAR(25),
  UPD_DATE TIMESTAMP NOT NULL DEFAULT now()
);

DROP TABLE IF EXISTS marks CASCADE;
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

DROP TABLE IF EXISTS classroom CASCADE;
CREATE TABLE classroom (
  classroomId SERIAL UNIQUE,
  classroomName VARCHAR(25) UNIQUE,
  teacherInCharge SERIAL REFERENCES teachers(teacherId),
  studentsInClass INT, 
  ADDED_BY VARCHAR(25),
  ADD_DATE TIMESTAMP,
  UPD_BY VARCHAR(25),
  UPD_DATE TIMESTAMP NOT NULL DEFAULT now(),
  PRIMARY KEY (classroomName)
);