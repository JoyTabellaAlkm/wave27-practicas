CREATE DATABASE empresa_internet;
USE empresa_internet;


CREATE TABLE planes_internet (
    id_plan INT AUTO_INCREMENT PRIMARY KEY,
    velocidad INT,
    precio DECIMAL(10, 2),
    descuento DECIMAL(5, 2)
);


CREATE TABLE clientes (
    dni VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    fecha_nacimiento DATE,
    provincia VARCHAR(50),
    ciudad VARCHAR(50),
    id_plan INT,
    FOREIGN KEY (id_plan) REFERENCES planes_internet(id_plan)
);


INSERT INTO planes_internet (velocidad, precio, descuento) VALUES
(10, 500.00, 5.00),
(20, 700.00, 10.00),
(50, 1200.00, 15.00),
(100, 2000.00, 20.00),
(200, 3500.00, 25.00);


INSERT INTO clientes (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES
('12345678', 'Juan', 'Pérez', '1985-06-15', 'Buenos Aires', 'La Plata', 1),
('23456789', 'María', 'Gómez', '1990-08-20', 'Córdoba', 'Córdoba', 2),
('34567890', 'Carlos', 'Sánchez', '1988-12-05', 'Santa Fe', 'Rosario', 1),
('45678901', 'Ana', 'López', '1995-03-10', 'Buenos Aires', 'Buenos Aires', 3),
('56789012', 'Javier', 'Martínez', '1992-04-25', 'CABA', 'Buenos Aires', 1),
('67890123', 'Lucía', 'Rodríguez', '1993-07-30', 'Mendoza', 'Mendoza', 2),
('78901234', 'Pedro', 'Fernández', '1987-09-15', 'Tucumán', 'San Miguel', 3),
('89012345', 'Sofía', 'Martín', '1991-11-02', 'Córdoba', 'Córdoba', 2),
('90123456', 'Diego', 'Hernández', '1986-01-14', 'Santa Fe', 'Santa Fe', 1),
('01234567', 'Valeria', 'Castro', '1989-05-22', 'Neuquén', 'Neuquén', 3);

-- Listar todos los clientes
SELECT *
FROM clientes;

-- Mostrar todos los clientes cuyo nombre empiece con “J”
SELECT *
FROM clientes
WHERE nombre LIKE "J%";

-- Mostrar velocidad y precio de los planes con una velocidad mayor o igual a 50

SELECT velocidad, precio
FROM planes_internet
WHERE velocidad >= 50;

-- Mostrar la velocidad del plan con el nombre del cliente

SELECT c.nombre, p.velocidad
FROM clientes c
JOIN planes_internet p ON c.id_plan = p.id_plan;

-- Mostrar los 3 primeros planes con mayor descuento

SELECT *
FROM planes_internet
ORDER BY descuento DESC
LIMIT 3;

-- Mostrar los clientes con fecha de nacimiento entre 1985 y 1987 y que vivan en la provincia de Santa Fe.

SELECT *
FROM clientes
WHERE fecha_nacimiento BETWEEN "1985-01-01"
AND "1990-01-01"
AND provincia = "Santa Fe";

-- Mostrar la cantidad de planes que hay registrados

SELECT COUNT(*)
FROM planes_internet;

-- Actualizar el precio del plan con id 2

UPDATE planes_internet
SET precio = 750.00
WHERE id_plan = 2;

-- Insertar un nuevo cliente

INSERT INTO clientes (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES
('44432904', 'Delfina', 'Glavas', '2002-10-14', 'Córdoba', 'Río Segundo', 5);

-- Eliminar el último cliente ingresado
DELETE 
FROM clientes
WHERE dni = '44432904'
