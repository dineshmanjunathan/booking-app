
create table t_member(
id serial PRIMARY KEY,
member_id VARCHAR(10) UNIQUE NOT NULL,
name CHARACTER(50),
dob DATE ,
gender VARCHAR(20),
email VARCHAR(50),
phone_number numeric(10),
password VARCHAR(50),
wallet numeric(10),
reference_code VARCHAR(10),
create_on DATE,
updated_on DATE,
refered_by VARCHAR(10)references t_member(id) delete on cascade
);


create table t_purchase(
id serial PRIMARY KEY,
member_id VARCHAR(10) references t_member(id) delete on cascade,
prod_code numeric(10) references t_product(id) delete on cascade,
create_on DATE,
updated_on DATE,
price numeric(10),
prod_qty numeric(10)
);

create table t_product(
id serial PRIMARY KEY,
prod_desc VARCHAR(50),
prod_category numeric(10) references t_category(id) delete on cascade,
create_on DATE,
updated_on DATE,
prod_qty numeric(10)
);

create table t_category(
id serial PRIMARY KEY,
category_desc VARCHAR(50),
create_on DATE,
updated_on DATE
);
