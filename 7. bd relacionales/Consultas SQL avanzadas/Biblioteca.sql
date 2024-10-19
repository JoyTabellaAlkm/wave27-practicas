CREATE DATABASE biblioteca_db;

USE biblioteca_db;

#Crear las tablas
CREATE TABLE autor (
    id_autor INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    nacionalidad VARCHAR(50)
);

CREATE TABLE estudiante (
    id_lector INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    direccion VARCHAR(255),
    carrera VARCHAR(100),
    edad INT
);

CREATE TABLE libro (
    id_libro INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255),
    editorial VARCHAR(100),
    area VARCHAR(100)
);

CREATE TABLE libro_autor (
    id_autor INT,
    id_libro INT,
    PRIMARY KEY (id_autor, id_libro),
    FOREIGN KEY (id_autor) REFERENCES autor(id_autor),
    FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
);

CREATE TABLE prestamo (
    id_lector INT,
    id_libro INT,
    fecha_prestamo DATE,
    fecha_devolucion DATE,
    devuelto BOOLEAN,
    PRIMARY KEY (id_lector, id_libro),
    FOREIGN KEY (id_lector) REFERENCES estudiante(id_lector),
    FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
);

-- Insertar datos en la tabla AUTOR
INSERT INTO autor (nombre, nacionalidad) VALUES 
('Isaac Asimov', 'Rusa'),
('J.R.R. Tolkien', 'Británica'),
('Agatha Christie', 'Británica'),
('Haruki Murakami', 'Japonesa'),
('J.D. Salinger', 'Estadounidense'),
('Julio Cortázar', 'Argentina'),
('Albert Camus', 'Francesa'),
('Italo Calvino', 'Italiana'),
('J.K. Rowling', 'Británica');

-- Insertar datos en la tabla ESTUDIANTE
INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad) VALUES 
('Carlos', 'Sánchez', 'Calle Luna 12', 'Ingeniería de Sistemas', 21),
('Laura', 'Fernández', 'Avenida Sol 34', 'Derecho', 22),
('Mario', 'Gómez', 'Boulevard del Parque 89', 'Ingeniería Electrónica', 23),
('Ana', 'Torres', 'Camino Verde 45', 'Literatura', 20),
('Luis', 'Martínez', 'Calle de las Flores 67', 'Matemáticas', 24),
('Filippo', 'Galli', 'Via Roma 1', 'Informática', 22);

-- Insertar datos en la tabla LIBRO
INSERT INTO libro (titulo, editorial, area) VALUES 
('Fundación', 'Debolsillo', 'Ciencia Ficción'),
('El Señor de los Anillos', 'HarperCollins', 'Fantasía'),
('Asesinato en el Orient Express', 'Planeta', 'Misterio'),
('Kafka en la orilla', 'Tusquets', 'Ficción'),
('El guardián entre el centeno', 'Little, Brown', 'Ficción'),
('Rayuela', 'Alfaguara', 'Literatura'),
('Internet para todos', 'Alfaomega', 'Internet'),
('Bases de datos modernas', 'Salamandra', 'Base de Datos'),
('El Universo: Guía de viaje', 'Tusquets', 'Ciencia');

-- Insertar datos en la tabla LIBROAUTOR
INSERT INTO libro_autor (id_autor, id_libro) VALUES 
(1, 1),  -- Isaac Asimov - Fundación
(2, 2),  -- J.R.R. Tolkien - El Señor de los Anillos
(3, 3),  -- Agatha Christie - Asesinato en el Orient Express
(4, 4),  -- Haruki Murakami - Kafka en la orilla
(5, 5),  -- J.D. Salinger - El guardián entre el centeno
(6, 6),  -- Julio Cortázar - Rayuela
(7, 9),  -- Albert Camus - El Universo: Guía de viaje
(8, 9),  -- Italo Calvino - El Universo: Guía de viaje
(9, 9);  -- J.K. Rowling - El Universo: Guía de viaje

-- Insertar datos en la tabla PRESTAMO
INSERT INTO prestamo (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES 
(1, 1, '2023-01-15', '2023-02-01', TRUE),  -- Carlos Sánchez - Fundación
(2, 2, '2023-01-20', '2023-02-05', TRUE),  -- Laura Fernández - El Señor de los Anillos
(3, 3, '2023-02-10', '2023-02-25', FALSE), -- Mario Gómez - Asesinato en el Orient Express
(4, 4, '2023-02-15', '2023-03-01', TRUE),  -- Ana Torres - Kafka en la orilla
(5, 5, '2023-03-01', '2023-03-15', FALSE), -- Luis Martínez - El guardián entre el centeno
(6, 7, '2023-01-25', '2023-02-10', FALSE), -- Filippo Galli - Internet para todos
(6, 9, '2021-07-01', '2021-07-16', FALSE); -- Filippo Galli - El Universo: Guía de viaje
