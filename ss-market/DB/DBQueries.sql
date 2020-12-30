
create table t_user(
user_id_seq serial PRIMARY KEY,
user_id VARCHAR(30) UNIQUE NOT NULL,
name CHARACTER(30),
dob DATE ,
department VARCHAR(50) ,
designation VARCHAR(50) ,
email VARCHAR(50) UNIQUE ,
mobile NUMERIC(20,0) ,
location VARCHAR(50),
password1 VARCHAR(50),
role CHARACTER(20) 
);

