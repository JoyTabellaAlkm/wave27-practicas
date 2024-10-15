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
    precio DECIMAL(10, 2) NOT NULL,
    descuento INT NOT NULL
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
(1, 20, 500.00, 10),
(2, 50, 800.00, 15),
(3, 100, 1300.00, 20),
(4, 200, 2000.00, 25),
(5, 500, 3500.00, 30);