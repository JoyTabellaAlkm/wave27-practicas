USE empresa_internet;

-- Eliminar tablas si existen
DROP TABLE IF EXISTS contract;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS plans;

-- Crear tabla de planes de internet
CREATE TABLE plans (
    plan_id INT AUTO_INCREMENT PRIMARY KEY,
    speed INT,
    price DECIMAL(10,2),
    discount DECIMAL(5,2)
);

-- Crear tabla de clientes
CREATE TABLE customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    dni INT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    birth_date DATE,
    province VARCHAR(50),
    city VARCHAR(50)
);

-- Crear tabla de contratos
CREATE TABLE contract (
    contract_id INT AUTO_INCREMENT PRIMARY KEY,
    plan_id INT,
    customer_id INT,
    FOREIGN KEY (plan_id) REFERENCES plans(plan_id),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

-- Insertar planes
INSERT INTO plans (speed, price, discount) VALUES
(10, 29.99, 0.00),
(50, 49.99, 5.00),
(100, 69.99, 10.00),
(200, 89.99, 15.00),
(30, 19.99, 0.00);

-- Insertar clientes
INSERT INTO customers (dni, first_name, last_name, birth_date, province, city) VALUES
(12345678, 'Juan', 'Pérez', '1990-01-15', 'Buenos Aires', 'Buenos Aires'),
(23456789, 'Ana', 'Gómez', '1985-04-20', 'Córdoba', 'Córdoba'),
(34567890, 'Luis', 'Martínez', '1992-11-30', 'Santa Fe', 'Rosario'),
(45678901, 'María', 'López', '1980-03-15', 'Mendoza', 'Mendoza'),
(56789012, 'Pedro', 'Sánchez', '1975-08-25', 'Tucumán', 'San Miguel de Tucumán'),
(67890123, 'Laura', 'Torres', '1995-06-12', 'Salta', 'Salta'),
(78901234, 'Carlos', 'Ramírez', '1988-09-09', 'Chaco', 'Resistencia'),
(89012345, 'Elena', 'Hernández', '1993-12-01', 'Chubut', 'Comodoro Rivadavia'),
(90123456, 'Jorge', 'Jiménez', '1982-05-05', 'Jujuy', 'San Salvador de Jujuy'),
(12345679, 'Sofía', 'Martín', '1999-07-07', 'Formosa', 'Formosa');

-- Inserta contratos
INSERT INTO contract (plan_id, customer_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);