create table employee(
	id serial primary key,
	first_name varchar(45) default null,
	last_name varchar(45) default null,
	email varchar(45) default null
);

INSERT INTO employee (first_name, last_name, email) VALUES
	('Leslie','Andrews','leslie@luv2code.com'),
	('Emma','Baumgarten','emma@luv2code.com'),
	('Avani','Gupta','avani@luv2code.com'),
	('Yuri','Petrov','yuri@luv2code.com'),
	('Juan','Vega','juan@luv2code.com');

