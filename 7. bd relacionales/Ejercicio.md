Una empresa proveedora de Internet necesita una base de datos para almacenar cada uno de sus clientes junto con el plan/pack que tiene contratado.

Mediante un análisis previo se conoce que se tiene que almacenar la siguiente información:

De los clientes se debe registrar: dni, nombre, apellido, fecha de nacimiento, provincia, ciudad.
1. Luego del planteo de los requerimientos de la empresa, se solicita modelar los mismos mediante un DER (Diagrama Entidad-Relación).

En cuanto a los planes de internet: identificación del plan, velocidad ofrecida en megas, precio, descuento.

2. Respuestas a las Preguntas
a. ¿Cuál es la primary key para la tabla de clientes? Justificar respuesta.

Primary Key: DNI
Justificación: El DNI es un identificador único para cada cliente en el país. Ningún cliente debería tener el mismo DNI, lo que garantiza la unicidad y permite identificar de manera efectiva cada registro.
b. ¿Cuál es la primary key para la tabla de planes de internet? Justificar respuesta.

Primary Key: ID_Plan
Justificación: ID_Plan es un identificador único para cada plan de internet. Al igual que el DNI para los clientes, el ID_Plan asegura que cada plan se pueda identificar y diferenciar de los demás, incluso si los planes tienen características similares.
c. ¿Cómo serían las relaciones entre tablas? ¿En qué tabla debería haber foreign key? ¿A qué campo de qué tabla hace referencia dicha foreign key? Justificar respuesta.

Relaciones:
Un cliente puede tener múltiples contratos (1
) con diferentes planes.
Cada contrato se asocia a un único cliente y un único plan.
Foreign Keys:
En la tabla Contratos:
DNI_Cliente (FK) referencia a DNI en la tabla Clientes.
ID_Plan (FK) referencia a ID_Plan en la tabla Planes.
Justificación: Esto permite que los contratos se relacionen con un cliente específico y con un plan específico. Así, se mantiene la integridad referencial entre las tablas.


3. Una vez realizado el planteo del diagrama y de haber respondido estas preguntas, utilizar PHPMyAdmin o MySQL Workbench para ejecutar lo siguiente:

-- Crear la base de datos
CREATE DATABASE empresa_internet;
USE empresa_internet;

-- Crear la tabla de clientes
CREATE TABLE Clientes (
    DNI VARCHAR(15) PRIMARY KEY,
    Nombre VARCHAR(50),
    Apellido VARCHAR(50),
    Fecha_Nacimiento DATE,
    Provincia VARCHAR(50),
    Ciudad VARCHAR(50)
);

-- Crear la tabla de planes
CREATE TABLE Planes (
    ID_Plan INT AUTO_INCREMENT PRIMARY KEY,
    Velocidad INT,
    Precio DECIMAL(10, 2),
    Descuento DECIMAL(5, 2)
);

-- Crear la tabla de contratos
CREATE TABLE Contratos (
    ID_Contrato INT AUTO_INCREMENT PRIMARY KEY,
    DNI_Cliente VARCHAR(15),
    ID_Plan INT,
    FOREIGN KEY (DNI_Cliente) REFERENCES Clientes(DNI),
    FOREIGN KEY (ID_Plan) REFERENCES Planes(ID_Plan)
);

-- Insertar registros en la tabla de clientes
INSERT INTO Clientes (DNI, Nombre, Apellido, Fecha_Nacimiento, Provincia, Ciudad) VALUES
('12345678A', 'Juan', 'Pérez', '1985-05-12', 'Buenos Aires', 'La Plata'),
('87654321B', 'Ana', 'Gómez', '1990-11-23', 'Córdoba', 'Córdoba'),
('23456789C', 'Luis', 'Martínez', '1980-02-15', 'Santa Fe', 'Rosario'),
('34567890D', 'María', 'López', '1995-07-30', 'Mendoza', 'Mendoza'),
('45678901E', 'Carlos', 'Hernández', '1975-01-20', 'Tucumán', 'San Miguel de Tucumán'),
('56789012F', 'Laura', 'González', '1988-03-25', 'Salta', 'Salta'),
('67890123G', 'Javier', 'Ramírez', '1992-09-14', 'Neuquén', 'Neuquén'),
('78901234H', 'Patricia', 'Fernández', '1983-12-05', 'Chaco', 'Resistencia'),
('89012345I', 'Fernando', 'Jiménez', '1978-04-17', 'Río Negro', 'Viedma'),
('90123456J', 'Elena', 'Castro', '1994-08-22', 'San Juan', 'San Juan');

-- Insertar registros en la tabla de planes
INSERT INTO Planes (Velocidad, Precio, Descuento) VALUES
(10, 500.00, 0),
(20, 800.00, 10),
(50, 1200.00, 15),
(100, 2000.00, 20),
(200, 3000.00, 25);

-- Insertar registros en la tabla de contratos
INSERT INTO Contratos (DNI_Cliente, ID_Plan) VALUES
('12345678A', 1),
('87654321B', 2),
('23456789C', 3),
('34567890D', 1),
('45678901E', 4),
('56789012F', 2),
('67890123G', 5),
('78901234H', 3),
('89012345I', 4),
('90123456J', 1);

Se solicita crear una nueva base de datos llamada “empresa_internet”.
Incorporar 10 registros en la tabla de clientes y 5 en la tabla de planes de internet.
Realizar las asociaciones/relaciones correspondientes entre estos registros.

4. Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias.

SELECT Velocidad, Precio, Descuento FROM Planes;

SELECT AVG(Precio) AS Precio_Promedio FROM Planes;

SELECT * FROM Clientes;

SELECT * FROM Planes;

SELECT * FROM Clientes WHERE Provincia = 'Buenos Aires';

SELECT * FROM Planes WHERE Descuento > 15;

SELECT COUNT(*) AS Total_Clientes FROM Clientes;

SELECT * FROM Contratos WHERE DNI_Cliente = '12345678A';

SELECT c.Nombre, c.Apellido, p.Velocidad, p.Precio
FROM Contratos ct
JOIN Clientes c ON ct.DNI_Cliente = c.DNI
JOIN Planes p ON ct.ID_Plan = p.ID_Plan;

SELECT c.Nombre, c.Apellido, p.Velocidad
FROM Contratos ct
JOIN Clientes c ON ct.DNI_Cliente = c.DNI
JOIN Planes p ON ct.ID_Plan = p.ID_Plan
WHERE p.Velocidad > 50;
