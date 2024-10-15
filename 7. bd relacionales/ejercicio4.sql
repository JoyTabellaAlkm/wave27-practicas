USE empresa_internet;

CREATE TABLE clientes (
    id INT PRIMARY KEY,
    dni VARCHAR(20) UNIQUE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    provincia VARCHAR(50) NOT NULL,
    ciudad VARCHAR(50) NOT NULL
);

CREATE TABLE planes (
    id INT PRIMARY KEY,
    velocidad_ofrecida INT NOT NULL,
    precio_base DECIMAL(10, 2) NOT NULL
);

INSERT INTO clientes (id, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES
(1, '12345678', 'Juan', 'Pérez', '1990-05-20', 'Buenos Aires', 'Buenos Aires'),
(2, '23456789', 'Ana', 'Gómez', '1985-11-15', 'CABA', 'CABA'),
(3, '34567890', 'Pedro', 'Fernández', '2000-02-10', 'Córdoba', 'Córdoba'),
(4, '45678901', 'María', 'López', '1992-07-25', 'Santa Fe', 'Rosario'),
(5, '56789012', 'Lucía', 'Martínez', '1988-03-22', 'Mendoza', 'Mendoza'),
(6, '67890123', 'Jorge', 'García', '1995-08-30', 'La Plata', 'La Plata'),
(7, '78901234', 'Sofía', 'Rodríguez', '1980-12-05', 'Tucumán', 'San Miguel de Tucumán'),
(8, '89012345', 'Diego', 'Sánchez', '1998-04-18', 'Salta', 'Salta'),
(9, '90123456', 'Valentina', 'Hernández', '1991-01-13', 'Neuquén', 'Neuquén'),
(10, '01234567', 'Pablo', 'Cruz', '1983-09-29', 'Chaco', 'Resistencia');

INSERT INTO planes (id, velocidad_ofrecida, precio, descuento) VALUES
(1, 20, 500.00),
(2, 50, 800.00),
(3, 100, 1300.00),
(4, 200, 2000.00),
(5, 500, 3500.00);

CREATE TABLE clientes_planes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    idClientes INT NOT NULL,
    idPlanes INT NOT NULL,
    FOREIGN KEY (idClientes) REFERENCES clientes(id),
    FOREIGN KEY (idPlanes) REFERENCES planes(id),
    precio_total DECIMAL(10, 2) NOT NULL,
    descuento INT NOT NULL
);

INSERT INTO clientes_planes (idClientes, idPlanes, precio_total, descuento) VALUES
(1, 1, 100.00, 10),
(1, 2, 200.00, 15),
(2, 1, 150.00, 5),
(3, 3, 300.00, 20),
(2, 2, 250.00, 25),
(4, 4, 180.00, 0),
(3, 1, 120.00, 10),
(1, 3, 220.00, 18),
(5, 2, 260.00, 12),
(6, 4, 300.00, 0);

### 1. Obtener todos los clientes y sus datos
SELECT * FROM clientes;

### 2. Obtener todos los planes disponibles y sus precios
SELECT * FROM planes;

### 3. Obtener todos los clientes que tienen un plan específico (por ejemplo, el plan con ID 2)
SELECT c.*
FROM clientes c
JOIN clientes_planes cp ON c.id = cp.idClientes
WHERE cp.idPlanes = 2;

### 4. Obtener los planes asignados a un cliente específico (por ejemplo, el cliente con ID 1)
SELECT p.*
FROM planes p
JOIN clientes_planes cp ON p.id = cp.idPlanes
WHERE cp.idClientes = 1;

### 5. Agregar un nuevo cliente
INSERT INTO clientes (id, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES
(11, '11223344', 'Felipe', 'Díaz', '1995-02-14', 'Buenos Aires', 'La Plata');

### 6. Modificar la velocidad de un plan (por ejemplo, cambiar la velocidad del plan con ID 1 a 30 megas)
UPDATE planes
SET velocidad_ofrecida = 30
WHERE id = 1;

### 7. Contar cuántos clientes hay en total
SELECT COUNT(*) AS total_clientes FROM clientes;

### 8. Obtener el promedio de precios de los planes
SELECT AVG(precio) AS promedio_precio FROM planes;

### 9. Eliminar un cliente específico (por ejemplo, el cliente con ID 10)
DELETE FROM clientes WHERE id = 10;

### 10. Obtener una lista de clientes y sus respectivos planes, incluyendo el nombre del cliente y la velocidad del plan
SELECT c.nombre, c.apellido, p.velocidad_ofrecida
FROM clientes c
JOIN clientes_planes cp ON c.id = cp.idClientes
JOIN planes p ON cp.idPlanes = p.id;