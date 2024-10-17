create database empresa_internet;
use empresa_internet;
create table plan
(
id_plan INT PRIMARY KEY AUTO_INCREMENT, 
precio DOUBLE, 
descuento DOUBLE, 
velocidad_megas INT
);

create table cliente (
id_cliente INT PRIMARY KEY AUTO_INCREMENT,
 provincia  VARCHAR(45),
 ciudad VARCHAR(45), 
 dni INT,
 nombre VARCHAR(45),
 apellido VARCHAR(45),
 fecha_nacimiento DATE,
 id_plan INT,
 FOREIGN KEY(id_plan) REFERENCES plan(id_plan)
);


insert into plan(id_plan, precio, descuento, velocidad_megas) values (1, 20000, 0, 100);
insert into plan(id_plan, precio, descuento, velocidad_megas) values (2, 70000, 0, 300);
insert into plan(id_plan, precio, descuento, velocidad_megas) values (3, 30000, 0, 110);
insert into plan(id_plan, precio, descuento, velocidad_megas) values (4, 40000, 10, 120);
insert into plan(id_plan, precio, descuento, velocidad_megas) values (5, 80000, 25, 500);

insert into cliente(id_cliente, provincia, ciudad, dni,nombre, apellido, fecha_nacimiento,id_plan) values (1,'Antioquia','Medellin',1234, 'laura','lopez', '2000-07-25',1);
insert into cliente(id_cliente, provincia, ciudad, dni,nombre, apellido, fecha_nacimiento,id_plan) values (2,'Antioquia','Medellin',123, 'luis','velez', '2001-07-24',2);
insert into cliente(id_cliente, provincia, ciudad, dni,nombre, apellido, fecha_nacimiento,id_plan) values (3,'Bogota','Bogota',12345, 'jorge','muñoz', '1998-05-24',1);
insert into cliente(id_cliente, provincia, ciudad, dni,nombre, apellido, fecha_nacimiento,id_plan) values (4,'Bogota','Bogota',12346, 'mauricio','lopez', '1999-06-23',2);
insert into cliente(id_cliente, provincia, ciudad, dni,nombre, apellido, fecha_nacimiento,id_plan) values (5,'Antioquia','Medellin',12347, 'luisa','rojas', '1999-08-22',1);
insert into cliente(id_cliente, provincia, ciudad, dni,nombre, apellido, fecha_nacimiento,id_plan) values (6,'Bogota','Bogota',12348, 'esteban','martinez', '2000-09-24',3);
insert into cliente(id_cliente, provincia, ciudad, dni,nombre, apellido, fecha_nacimiento,id_plan) values (7,'Bogota','Bogota',12349, 'david','loaiza', '1964-10-01',1);
insert into cliente(id_cliente, provincia, ciudad, dni,nombre, apellido, fecha_nacimiento,id_plan) values (8,'Antioquia','Medellin',12310, 'viviana','roa', '2003-11-22',4);
insert into cliente(id_cliente, provincia, ciudad, dni,nombre, apellido, fecha_nacimiento,id_plan) values (9,'Atlantico','Barranquilla',12311, 'rodolfo','ospina', '2001-12-24',4);
insert into cliente(id_cliente, provincia, ciudad, dni,nombre, apellido, fecha_nacimiento,id_plan) values (10,'Antioquia','Medellin',12312, 'manuela','ospina', '2001-02-24',5);

select nombre, apellido from cliente where apellido like'lo%';
select * from cliente where fecha_nacimiento BETWEEN("1998-01-01") AND ("1999-12-31");
select * from plan where precio >=50000;
select nombre, apellido  from  cliente where id_plan  order by  id_plan desc limit 1 ;
select count(id_plan) as 'total de id plan2' from cliente where id_plan = 2;
select * from plan where precio order by precio asc limit 3;
select id_plan, precio from plan where velocidad_megas<200;
select id_plan, precio-(precio*(descuento/100)) as 'plan con descuento' from plan order by id_plan asc;
select nombre, apellido,ciudad from cliente where ciudad like "medellin";
select count(ciudad) as 'total que viven en bogota' from cliente where ciudad like 'bogota%' AND fecha_nacimiento BETWEEN("1998-01-01") AND ("2000-12-31");



