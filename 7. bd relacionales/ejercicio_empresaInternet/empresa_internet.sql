USE empresa_internet;

INSERT INTO planes (velocidad, precio, descuento) VALUES
(10, 20.00, 0),
(50, 35.00, 5),
(100, 50.00, 10),
(200, 70.00, 15),
(500, 100.00, 20);

INSERT INTO clientes (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES
('12345678A', 'Juan', 'Pérez', '1990-01-01', 'Buenos Aires', 'Buenos Aires', 2),
('23456789B', 'Ana', 'Gómez', '1985-05-12', 'CABA', 'CABA', 1),
('34567890C', 'Luis', 'Fernández', '1988-03-15', 'Córdoba', 'Córdoba', 3),
('45678901D', 'María', 'López', '1992-07-20', 'Santa Fe', 'Rosario', 4),
('56789012E', 'Pedro', 'Martínez', '1980-09-30', 'Mendoza', 'Mendoza', 5),
('67890123F', 'Laura', 'Rodríguez', '1995-12-11', 'Tucumán', 'San Miguel de Tucumán', 2),
('78901234G', 'Carlos', 'Sánchez', '1987-04-08', 'Salta', 'Salta', 3),
('89012345H', 'Sofía', 'Torres', '1993-11-22', 'Neuquén', 'Neuquén', 4),
('90123456I', 'Javier', 'Morales', '1989-10-02', 'Misiones', 'Posadas', 5),
('01234567J', 'Patricia', 'Díaz', '1991-08-18', 'La Plata', 'La Plata', 1);

-- 1. Listar todos los clientes
SELECT * FROM clientes;

-- 2. Listar todos los planes
SELECT * FROM planes;

-- 3. Traer todos los clientes de la provincia de Buenos Aires
SELECT * FROM clientes WHERE provincia = 'Buenos Aires';

-- 4. Obtener la cantidad de clientes por plan
SELECT id_plan, COUNT(*) AS cantidad_clientes
FROM clientes
GROUP BY id_plan;

-- 5. Listar los planes ordenados por precio descendente 
SELECT * FROM planes ORDER BY precio DESC;

-- 6. Actualizar los planes de id 2 con un nuevo precio 
UPDATE planes
SET precio = 25.00
WHERE id_plan = 2;

-- 7. Contar numero total de clientes
SELECT COUNT(*) AS total_clientes FROM clientes;

-- 8. Encontrar el cliente mayor de edad
SELECT * FROM clientes ORDER BY fecha_nacimiento ASC LIMIT 1;

-- 9. Traer todos los clientes que su nombre empiece con J
SELECT * FROM clientes WHERE nombre LIKE 'J%';

-- 10. Traer todos los clientes que su nombre NO empiece con J
SELECT * FROM clientes WHERE nombre NOT LIKE 'J%';

