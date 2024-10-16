-- Crear BD
DROP DATABASE IF EXISTS Biblioteca;
CREATE DATABASE Biblioteca;
USE Biblioteca;

-- Crear tablas
CREATE TABLE AUTOR (
    idAutor INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100),
    Nacionalidad VARCHAR(50)
);

CREATE TABLE LIBRO (
    idLibro INT PRIMARY KEY AUTO_INCREMENT,
    Titulo VARCHAR(255),
    Editorial VARCHAR(100),
    Area VARCHAR(100)
);

CREATE TABLE LIBROAUTOR (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor , idLibro),
    FOREIGN KEY (idAutor)
        REFERENCES AUTOR (idAutor),
    FOREIGN KEY (idLibro)
        REFERENCES LIBRO (idLibro)
);

CREATE TABLE ESTUDIANTE (
    idLector INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100),
    Apellido VARCHAR(100),
    Direccion VARCHAR(255),
    Carrera VARCHAR(100),
    Edad INT
);

CREATE TABLE PRESTAMO (
    idLector INT,
    idLibro INT,
    FechaPrestamo DATE,
    FechaDevolucion DATE,
    Devuelto BOOLEAN,
    PRIMARY KEY (idLector , idLibro , FechaPrestamo),
    FOREIGN KEY (idLector)
        REFERENCES ESTUDIANTE (idLector),
    FOREIGN KEY (idLibro)
        REFERENCES LIBRO (idLibro)
);

-- Mock de datos
-- Insertar autores
INSERT INTO AUTOR (Nombre, Nacionalidad) VALUES
('Gabriel García Márquez', 'Colombiana'),
('J.K. Rowling', 'Británica'),
('George Orwell', 'Británica'),
('Le ble', 'Francesa'),
('Pepe Argento', 'Italiana');

-- Insertar libros
INSERT INTO LIBRO (Titulo, Editorial, Area) VALUES
('Cien años de soledad', 'Editorial Sudamericana', 'Literatura'),
('Harry Potter y la piedra filosofal', 'Bloomsbury', 'Fantasía'),
('1984', 'Secker & Warburg', 'Distopía'),
('El Universo: Guia de viaje', 'Salamandra', 'Base de datos'),
('El loco que grita', 'Meli', 'Base de datos');

-- Insertar relaciones libro-autor
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES
(1, 1),
(2, 2),
(3, 3),
(1, 3),
(3, 5),
(4, 4);

-- Insertar estudiantes
INSERT INTO ESTUDIANTE (Nombre, Apellido, Direccion, Carrera, Edad) VALUES
('Juan', 'Pérez', 'Calle Falsa 123', 'Literatura', 20),
('María', 'González', 'Avenida Siempre Viva 456', 'Historia', 22),
('Filippo', 'Galli', 'Boulevard del Río 789', 'Ingeniería', 21),
('Felipe', 'Cafici', 'Calle falsa 123', 'Informática', 23),
('Charly', 'Gomez Vazques De La Serna', 'Meli 123', 'Informatica', 18);

-- Insertar préstamos
INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 1, '2023-10-01', NULL, FALSE),
(2, 2, '2023-10-02', NULL, FALSE),
(3, 3, '2023-10-03', '2023-10-10', TRUE),
(4, 4, '2020-07-16', '2021-07-16', TRUE);

-- 1. Listar los datos de los autores.
SELECT * FROM AUTOR;

-- 2. Listar nombre y edad de los estudiantes
SELECT Nombre, Edad
FROM ESTUDIANTE;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT Nombre, Apellido
FROM ESTUDIANTE
WHERE Carrera = "Informática";

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT Nombre
FROM AUTOR
WHERE Nacionalidad = "Francesa"
OR Nacionalidad = "Italiana";

-- 5. ¿Qué libros no son del área de internet?
SELECT Titulo
FROM LIBRO
WHERE Area != "Internet";

-- 6. Listar los libros de la editorial Salamandra.
SELECT Titulo
FROM LIBRO
WHERE Editorial = "Salamandra";

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM ESTUDIANTE
WHERE Edad > (SELECT AVG(Edad) FROM ESTUDIANTE);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT Nombre, Apellido
FROM ESTUDIANTE
WHERE Apellido LIKE "G%";

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.Nombre
FROM AUTOR a
JOIN LIBROAUTOR la on a.idAutor = la.idAutor
JOIN LIBRO l on l.idLibro = la.idLibro
WHERE l.Titulo = "El Universo: Guía de viaje";

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.Titulo
FROM LIBRO l
JOIN PRESTAMO p ON l.idLibro = p.idLibro
JOIN ESTUDIANTE e ON e.idLector = p.idLector
WHERE e.Nombre = "Filippo" AND e.Apellido = "Galli";

-- 11. Listar el nombre del estudiante de menor edad.
SELECT Nombre, Edad
FROM ESTUDIANTE
ORDER BY Edad ASC
LIMIT 1;

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.Nombre, e.Apellido
FROM ESTUDIANTE e
JOIN PRESTAMO p ON e.idLector = p.idLector
JOIN LIBRO l ON p.idLibro = l.idLibro
WHERE l.Area = "Base de datos";

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.Titulo
FROM LIBRO l
JOIN LIBROAUTOR la ON l.idLibro = la.idLibro
JOIN AUTOR a ON la.idAutor = a.idAutor
WHERE a.Nombre = "J.K. Rowling";

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.Titulo
FROM LIBRO l
JOIN PRESTAMO p ON l.idLibro = p.idLibro
WHERE p.FechaDevolucion = "2021-07-16";