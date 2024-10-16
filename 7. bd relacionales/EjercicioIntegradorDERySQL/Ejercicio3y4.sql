-- Se solicita crear una nueva base de datos llamada “empresa_internet”.
CREATE DATABASE empresa_internet;
USE empresa_internet;

CREATE TABLE cliente(
id_cliente INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(50),
apellidos VARCHAR(100),
dni VARCHAR(15),
fecha_nacimiento DATE,
provincia VARCHAR(50),
ciudad VARCHAR(50)
);

CREATE TABLE plan(
id_plan INT PRIMARY KEY AUTO_INCREMENT,
velocidad INT,
precio DECIMAL,
descuento DECIMAL
);

CREATE TABLE contrato(
id_contrato INT PRIMARY KEY AUTO_INCREMENT,
id_cliente INT,
id_plan INT,
FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
FOREIGN KEY (id_plan) REFERENCES plan(id_plan)
);

-- Incorporar 10 registros en la tabla de clientes y 5 en la tabla de planes de internet.
INSERT INTO cliente(nombre, apellidos, dni, fecha_nacimiento, provincia, ciudad) VALUES("Jane", "Doe", "123456", "1988-12-30", "Antioquia", "Medellín");
INSERT INTO cliente(nombre, apellidos, dni, fecha_nacimiento, provincia, ciudad) VALUES("Sofia", "Montoya", "1000868300", "2001-09-26", "Antioquia", "Itagüí");
INSERT INTO cliente(nombre, apellidos, dni, fecha_nacimiento, provincia, ciudad) VALUES("Martina", "Gomez", "456435645", "1990-12-30", "Antioquia", "Medellín");
INSERT INTO cliente(nombre, apellidos, dni, fecha_nacimiento, provincia, ciudad) VALUES("Carla", "Perez", "123456", "1995-12-30", "Antioquia", "Medellín");
INSERT INTO cliente(nombre, apellidos, dni, fecha_nacimiento, provincia, ciudad) VALUES("Carolina", "Rodas", "123456", "2002-12-30", "Antioquia", "Medellín");
INSERT INTO cliente(nombre, apellidos, dni, fecha_nacimiento, provincia, ciudad) VALUES("Carlos", "Sanchez", "123456", "1985-12-30", "Antioquia", "Medellín");
INSERT INTO cliente(nombre, apellidos, dni, fecha_nacimiento, provincia, ciudad) VALUES("Camilo", "Bolivar", "123456", "1988-12-30", "Antioquia", "Medellín");
INSERT INTO cliente(nombre, apellidos, dni, fecha_nacimiento, provincia, ciudad) VALUES("Rodrigo", "Zapata", "123456", "1986-12-30", "Antioquia", "Medellín");
INSERT INTO cliente(nombre, apellidos, dni, fecha_nacimiento, provincia, ciudad) VALUES("Diomedes", "Diaz", "123456", "1989-12-30", "Antioquia", "Medellín");
INSERT INTO cliente(nombre, apellidos, dni, fecha_nacimiento, provincia, ciudad) VALUES("Amparo", "Grisales", "123456", "1988-12-30", "Antioquia", "Medellín");

INSERT INTO plan(velocidad, precio, descuento) VALUES(50, 80000, 15);
INSERT INTO plan(velocidad, precio, descuento) VALUES(100, 110000, 5);
INSERT INTO plan(velocidad, precio, descuento) VALUES(200, 120000, 2);
INSERT INTO plan(velocidad, precio, descuento) VALUES(500, 160000, 8);
INSERT INTO plan(velocidad, precio, descuento) VALUES(10, 50000, 0);

-- Realizar las asociaciones/relaciones correspondientes entre estos registros.
INSERT INTO contrato(id_cliente, id_plan) VALUES(1, 3);
INSERT INTO contrato(id_cliente, id_plan) VALUES(2, 3);
INSERT INTO contrato(id_cliente, id_plan) VALUES(3, 1);
INSERT INTO contrato(id_cliente, id_plan) VALUES(4, 2);
INSERT INTO contrato(id_cliente, id_plan) VALUES(5, 5);
INSERT INTO contrato(id_cliente, id_plan) VALUES(6, 2);
INSERT INTO contrato(id_cliente, id_plan) VALUES(7, 4);
INSERT INTO contrato(id_cliente, id_plan) VALUES(8, 1);
INSERT INTO contrato(id_cliente, id_plan) VALUES(9, 3);
INSERT INTO contrato(id_cliente, id_plan) VALUES(10, 4);


-- Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias.

-- Ordenar planes de mas barato a mas caro
SELECT * FROM plan ORDER BY precio;
-- Mostrar el plan con mayor velocidad
SELECT * FROM plan ORDER BY velocidad DESC LIMIT 1;
-- Mostrar el plan con menor velocidad
SELECT * FROM plan ORDER BY velocidad LIMIT 1;
-- Mostrar el nombre, apellido y fecha de naciemiento de los clientes que se encuentran en la ciudad de Itagüí
SELECT nombre, apellidos, fecha_nacimiento FROM cliente WHERE ciudad = "Itagüí";
-- Mostrar el nombre, apellido, ciudad y provincia de los clientes que hallan nacido despues del año 1990
SELECT nombre, apellidos, ciudad, provincia FROM cliente WHERE YEAR(fecha_nacimiento) > 1990;
-- Ordenar los clientes por fecha de más antigua a mas reciente
SELECT * FROM cliente ORDER BY fecha_nacimiento;
-- Ordenar los planes por descuento de más alto a mas bajo
SELECT * FROM plan ORDER BY descuento DESC;