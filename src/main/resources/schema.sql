DROP TABLE IF EXISTS student;
CREATE TABLE IF NOT EXISTS student (
	id INT PRIMARY KEY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	gender VARCHAR(50),
	cityOfBirth VARCHAR(50),
	email VARCHAR(50),
	university VARCHAR(200),
	dob DATE
);