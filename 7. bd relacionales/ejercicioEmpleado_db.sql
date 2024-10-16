CREATE DATABASE empresa_db;
USE empresa_db;

CREATE TABLE departamento(
depto_nro VARCHAR(100) PRIMARY KEY NOT NULL,
nombre_depto VARCHAR(100),
localidad VARCHAR(250)
);

CREATE TABLE empleado(
cod_emp VARCHAR(100) PRIMARY KEY NOT NULL,
nombre VARCHAR(100),
apellido VARCHAR(100),
puesto VARCHAR(100),
fecha_alta DATE,
salario DECIMAL,
comision DECIMAL,
depto_nro VARCHAR(100),
FOREIGN KEY(depto_nro) REFERENCES departamento(depto_nro)
);

INSERT INTO departamento(depto_nro, nombre_depto, localidad) VALUES ("D-000-1", "Software", "Los Tigres");
INSERT INTO departamento(depto_nro, nombre_depto, localidad) VALUES ("D-000-2", "Sistemas", "Guadalupe");
INSERT INTO departamento(depto_nro, nombre_depto, localidad) VALUES ("D-000-3", "Contabilidad", "La Roca");
INSERT INTO departamento(depto_nro, nombre_depto, localidad) VALUES ("D-000-4", "Ventas", "Plata");

INSERT INTO empleado(cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES("E-0001", "César", "Piñero", "Vendedor", "2018-05-12", 80000, 15000, "D-000-4");
INSERT INTO empleado(cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES("E-0002", "Yosep", "Kowaleski", "Analista", "2015-07-14", 140000, 0, "D-000-2");
INSERT INTO empleado(cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES("E-0003", "Mariela", "Barrios", "Director", "2014-06-05", 185000, 0, "D-000-3");
INSERT INTO empleado(cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES("E-0004", "Jonathan", "Aguilera", "Vendedor", "2015-06-03", 85000, 10000, "D-000-4");
INSERT INTO empleado(cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES("E-0005", "Daniel", "Brezezicki", "Vendedor", "2018-03-03", 83000, 10000, "D-000-4");
INSERT INTO empleado(cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES("E-0006", "Mito", "Barchuk", "Presidente", "2014-06-05", 80000, 190000, "D-000-3");
INSERT INTO empleado(cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES("E-0007", "Emilio", "Galarza", "Desarrollador", "2014-08-02", 60000, 15000, "D-000-1");

-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT empleado.nombre AS "Nombre de empleado", empleado.puesto AS "Puesto", departamento.localidad AS "Localidad" FROM empleado INNER JOIN departamento ON empleado.depto_nro = departamento.depto_nro WHERE empleado.puesto = "Vendedor";

-- Visualizar los departamentos con más de cinco empleados.
SELECT * FROM departamento WHERE depto_nro IN (SELECT depto_nro FROM empleado GROUP BY depto_nro HAVING COUNT(*)>5);

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT empleado.nombre, empleado.apellido, empleado.salario, departamento.nombre_depto FROM empleado INNER JOIN departamento ON empleado.depto_nro = departamento.depto_nro WHERE empleado.puesto = (SELECT puesto FROM empleado WHERE empleado.nombre = "Mito" AND empleado.apellido = "Barchuk") AND NOT (empleado.nombre = "Mito" AND empleado.apellido = "Barchuk");

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT * FROM empleado WHERE depto_nro = (SELECT depto_nro FROM departamento WHERE nombre_depto = "Contabilidad") ORDER BY nombre; 

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre, apellido FROM empleado ORDER BY salario LIMIT 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT * FROM empleado WHERE depto_nro = (SELECT depto_nro FROM departamento WHERE nombre_depto = "Ventas") ORDER BY salario DESC LIMIT 1; 
