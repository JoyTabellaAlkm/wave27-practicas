#EJERCICIO 3
DROP DATABASE IF EXISTS empresa_internet;
CREATE DATABASE empresa_internet;
USE empresa_internet;

CREATE TABLE clientes(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
dni VARCHAR(15) NOT NULL,
nombre VARCHAR(15) NOT NULL,
apellido VARCHAR(15) NOT NULL,
fecha_nac DATE NOT NULL,
provincia VARCHAR(20) NOT NULL,
ciudad VARCHAR(20) NOT NULL
);

CREATE TABLE planes(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
velocidad INT NOT NULL,
precio DECIMAL(10,2) NOT NULL
);

CREATE TABLE contrataciones(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
id_cliente INT NOT NULL,
id_plan INT NOT NULL,
precio_total DECIMAL (10,2),
descuento DECIMAL(4,1),
FOREIGN KEY (id_cliente) REFERENCES clientes(id),
FOREIGN KEY (id_plan) REFERENCES planes(id)
);

# REGISTROS
# CLIENTES
INSERT INTO clientes(dni, nombre, apellido, fecha_nac, provincia, ciudad) VALUES('10293849284', 'Carlos', 'García', '1995-05-15', 'Cundinamarca', 'Bogotá');
INSERT INTO clientes(dni, nombre, apellido, fecha_nac, provincia, ciudad) VALUES('10293849285', 'Laura', 'Martínez', '1988-11-20', 'Valle del Cauca', 'Cali');
INSERT INTO clientes(dni, nombre, apellido, fecha_nac, provincia, ciudad) VALUES('10293849286', 'Juan', 'Pérez', '1990-02-28', 'Antioquia', 'Medellín');
INSERT INTO clientes(dni, nombre, apellido, fecha_nac, provincia, ciudad) VALUES('10293849287', 'Sofía', 'Rodríguez', '1997-03-30', 'Jalisco', 'Guadalajara');
INSERT INTO clientes(dni, nombre, apellido, fecha_nac, provincia, ciudad) VALUES('10293849288', 'Andrés', 'Hernández', '1985-06-10', 'San Cristóbal', 'Táchira');
INSERT INTO clientes(dni, nombre, apellido, fecha_nac, provincia, ciudad) VALUES('10293849289', 'Isabel', 'Gómez', '1992-08-05', 'Buenos Aires', 'Buenos Aires');
INSERT INTO clientes(dni, nombre, apellido, fecha_nac, provincia, ciudad) VALUES('10293849290', 'Luis', 'Sánchez', '1983-09-14', 'Santiago', 'Santiago de Chile');
INSERT INTO clientes(dni, nombre, apellido, fecha_nac, provincia, ciudad) VALUES('10293849291', 'Clara', 'Castro', '1991-12-01', 'Cundinamarca', 'Bogotá');
INSERT INTO clientes(dni, nombre, apellido, fecha_nac, provincia, ciudad) VALUES('10293849292', 'Felipe', 'Morales', '1980-07-07', 'Cartagena', 'Cartagena');
INSERT INTO clientes(dni, nombre, apellido, fecha_nac, provincia, ciudad) VALUES('10293849293', 'Nina', 'Vásquez', '1996-04-22', 'Córdoba', 'Córdoba');

# PLANES
INSERT INTO planes(velocidad, precio) VALUES(100, 59900);
INSERT INTO planes(velocidad, precio) VALUES(150, 69900);
INSERT INTO planes(velocidad, precio) VALUES(300, 79900);
INSERT INTO planes(velocidad, precio) VALUES(500, 89900);
INSERT INTO planes(velocidad, precio) VALUES(1000, 99900);

#CONTRATACIÓN
INSERT INTO contrataciones(id_cliente, id_plan, precio_total, descuento) VALUES(1,5,84915,15.0);
INSERT INTO contrataciones(id_cliente, id_plan, precio_total, descuento) VALUES(2,1,59900,null);
INSERT INTO contrataciones(id_cliente, id_plan, precio_total, descuento) VALUES(3,1,59900,null);
INSERT INTO contrataciones(id_cliente, id_plan, precio_total, descuento) VALUES(4,4,80910,10.0);
INSERT INTO contrataciones(id_cliente, id_plan, precio_total, descuento) VALUES(5,3,75905,5.0);
INSERT INTO contrataciones(id_cliente, id_plan, precio_total, descuento) VALUES(5,1,56905,5.0);
INSERT INTO contrataciones(id_cliente, id_plan, precio_total, descuento) VALUES(6,2,69900,null);
INSERT INTO contrataciones(id_cliente, id_plan, precio_total, descuento) VALUES(7,2,69900,null);
INSERT INTO contrataciones(id_cliente, id_plan, precio_total, descuento) VALUES(8,3,75905,5.0);
INSERT INTO contrataciones(id_cliente, id_plan, precio_total, descuento) VALUES(9,4,80910,10.0);
INSERT INTO contrataciones(id_cliente, id_plan, precio_total, descuento) VALUES(10,3,75905,5.0);

# EJERCICIO 4
USE empresa_internet;
# CONSULTAS SQL
# 1. CLIENTES QUE TENGAN EL PLAN CON EL ID 1
SELECT c.*,co.id_plan FROM clientes c INNER JOIN contrataciones co ON c.id = co.id_cliente WHERE co.id_plan = 1;

# 2. MOSTRAR PLANES CON VELOCIDAD MAYOR O IGUAL A 300 MB
SELECT * FROM planes WHERE velocidad >= 300;

# 3. MOSTRAR CLIENTES QUE SU NOMBRE EMPIECE POR 'L'
SELECT * FROM clientes WHERE nombre LIKE 'L%';

# 4. MOSTRAR EL NOMBRE COMPLETO DE CLIENTES QUE SU PROVINCIA SEA CUNDINAMARCA
SELECT CONCAT(nombre, ' ', apellido) AS nombre_completo FROM clientes WHERE provincia = 'Cundinamarca';

# 5. MOSTRAR CLIENTES QUE TENGAN MAS DE UN PLAN
SELECT c.*, COUNT(co.id_plan) AS num_planes FROM clientes c  INNER JOIN contrataciones co ON c.id = co.id_cliente GROUP BY c.id HAVING num_planes > 1;

# 6. MOSTRAR CLIENTES QUE HAYAN NACIDO ENTRE 1985 Y 1999
SELECT * FROM clientes WHERE YEAR(fecha_nac) BETWEEN 1985 AND 1999;

# 7. MOSTRAR CUANTOS CLIENTES HAY EN CADA CIUDAD ORDENADOS DESC
SELECT ciudad, COUNT(ciudad) AS numero_clientes from clientes GROUP BY ciudad ORDER BY numero_clientes DESC; 

# 8. MOSTRAR CONTRATACIONES SIN DESCUENTO
SELECT * from contrataciones WHERE descuento IS null;

# 9. MOSTRAR TOP 3 PLANES MAS COMPRADOS
SELECT p.id, COUNT(co.id_plan) AS numero_clientes from planes p INNER JOIN contrataciones co ON p.id = co.id_plan GROUP BY p.id ORDER BY numero_clientes DESC LIMIT 3;

# 10. MOSTRAR TOP 5 PERSONAS MAS JOVENES CON PLANES ACTIVOS
SELECT c.* from clientes c INNER JOIN contrataciones co ON c.id = co.id_cliente GROUP BY c.id ORDER BY fecha_nac DESC LIMIT 5;