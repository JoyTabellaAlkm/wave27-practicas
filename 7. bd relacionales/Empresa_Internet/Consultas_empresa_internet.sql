SELECT * FROM clientes;

SELECT nombre, apellido FROM clientes WHERE fecha_nacimiento BETWEEN '1992-01-01' AND '2005-12-31';

SELECT nombre, apellido, dni FROM clientes WHERE apellido LIKE '%ez';

SELECT nombre, apellido FROM clientes WHERE nombre LIKE '%a';

SELECT nombre, apellido, ciudad FROM clientes WHERE ciudad = 'Bogotá' OR ciudad = 'Medellin';

SELECT * FROM planes;

SELECT id_plan, precio FROM planes WHERE velocidad >100;

SELECT id_plan, velocidad, precio FROM planes WHERE precio BETWEEN 150000 AND 350000;

SELECT * FROM clientes_planes;

SELECT id_cliente, fecha_contratacion FROM clientes_planes WHERE id_plan = 004;

SELECT id_cliente, id_plan FROM clientes_planes WHERE fecha_contratacion BETWEEN '2020-01-01' AND '2024-12-31';