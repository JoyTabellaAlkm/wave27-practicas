-- Crear la base de datos
CREATE DATABASE biblioteca;

-- Usar la base de datos
USE biblioteca;

-- Tabla AUTOR
CREATE TABLE Autor (
    idAutor INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100),
    Nacionalidad VARCHAR(50)
);

-- Tabla LIBRO
CREATE TABLE Libro (
    idLibro INT PRIMARY KEY AUTO_INCREMENT,
    Titulo VARCHAR(150),
    Editorial VARCHAR(100),
    Area VARCHAR(50)
);

-- Tabla LIBROAUTOR (relación muchos a muchos entre LIBRO y AUTOR)
CREATE TABLE LibroAutor (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES Autor(idAutor),
    FOREIGN KEY (idLibro) REFERENCES Libro(idLibro)
);

-- Tabla ESTUDIANTE
CREATE TABLE Estudiante (
    idLector INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100),
    Apellido VARCHAR(100),
    Direccion VARCHAR(150),
    Carrera VARCHAR(50),
    Edad INT
);

-- Tabla PRESTAMO (relación entre ESTUDIANTE y LIBRO)
CREATE TABLE Prestamo (
    idLector INT,
    idLibro INT,
    FechaPrestamo DATE,
    FechaDevolucion DATE,
    Devuelto BOOLEAN,
    PRIMARY KEY (idLector, idLibro, FechaPrestamo),
    FOREIGN KEY (idLector) REFERENCES Estudiante(idLector),
    FOREIGN KEY (idLibro) REFERENCES Libro(idLibro)
);

-- Insertar datos en la tabla AUTOR
INSERT INTO Autor (Nombre, Nacionalidad) VALUES
('Gabriel García Márquez', 'Colombiana'),
('Isabel Allende', 'Chilena'),
('J.K. Rowling', 'Británica'),
('Jorge Luis Borges', 'Argentina'),
('Mario Vargas Llosa', 'Peruana'),
('Victor Hugo', 'Francesa'),
('Umberto Eco', 'Italiana');

-- Insertar datos en la tabla LIBRO
INSERT INTO Libro (Titulo, Editorial, Area) VALUES
('Cien Años de Soledad', 'Sudamericana', 'Novela'),
('La Casa de los Espíritus', 'Debolsillo', 'Novela'),
('Harry Potter y la Piedra Filosofal', 'Salamandra', 'Fantasía'),
('El Aleph', 'Debolsillo', 'Cuento'),
('La Ciudad y los Perros', 'Alfaguara', 'Novela'),
('El Universo: Guía de viaje', 'Editorial Planeta', 'Guía'),
('Bases de Datos Avanzadas', 'Editorial Técnica', 'Base de Datos'),
('Introducción a la Programación', 'Editorial Académica', 'Informática'),
('Fundamentos de la Web', 'Editorial Digital', 'Internet');

-- Ahora, insertar datos en la tabla LIBROAUTOR asegurando que los idAutor y idLibro son correctos
INSERT INTO LibroAutor (idAutor, idLibro) VALUES
(1, 1),  -- Gabriel García Márquez - Cien Años de Soledad
(2, 2),  -- Isabel Allende - La Casa de los Espíritus
(3, 3),  -- J.K. Rowling - Harry Potter y la Piedra Filosofal
(4, 4),  -- Jorge Luis Borges - El Aleph
(5, 5),  -- Mario Vargas Llosa - La Ciudad y los Perros
(6, 6),  -- Victor Hugo - El Universo: Guía de viaje
(7, 7),  -- Umberto Eco - Bases de Datos Avanzadas
(3, 8),  -- J.K. Rowling - Introducción a la Programación
(7, 9);  -- Umberto Eco - Fundamentos de la Web (corregido de 8 a 7)

-- Insertar datos en la tabla ESTUDIANTE
INSERT INTO Estudiante (Nombre, Apellido, Direccion, Carrera, Edad) VALUES
('Juan', 'Pérez', 'Calle Falsa 123', 'Ingeniería', 20),
('María', 'González', 'Avenida Siempre Viva 456', 'Medicina', 22),
('Pedro', 'Ramírez', 'Calle Luna 789', 'Derecho', 21),
('Ana', 'Torres', 'Calle Sol 101', 'Arquitectura', 23),
('Luis', 'Martínez', 'Avenida Principal 202', 'Economía', 22),
('Carlos', 'Lopez', 'Calle del Sol 112', 'Informática', 24),
('Sofia', 'Diaz', 'Avenida del Bosque 223', 'Informática', 23),
('Miguel', 'Hernandez', 'Calle de la Luna 334', 'Informática', 25);

-- Insertar datos en la tabla PRESTAMO
INSERT INTO Prestamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 1, '2024-10-01', '2024-10-15', TRUE),
(2, 2, '2024-10-03', '2024-10-17', FALSE),
(3, 3, '2024-10-05', '2024-10-19', FALSE),
(4, 4, '2024-10-07', '2024-10-21', TRUE),
(5, 5, '2024-10-09', '2024-10-23', FALSE),
(6, 8, '2024-10-10', '2024-10-24', FALSE),
(7, 9, '2024-10-11', '2024-10-25', FALSE),
(5, 7, '2024-10-12', '2024-10-26', TRUE);

SELECT *
FROM Autor;

SELECT nombre, edad
FROM estudiante;

SELECT *
FROM estudiante 
WHERE carrera = 'Informática';

SELECT *
FROM autor
WHERE nacionalidad = 'francesa'
OR nacionalidad = 'italiana';

SELECT *
FROM libro
WHERE area != 'internet';

SELECT *
FROM libro
WHERE editorial = 'Salamandra';

SELECT *
FROM estudiante
WHERE edad > (SELECT AVG(edad)
FROM estudiante);

SELECT nombre
FROM estudiante
WHERE apellido LIKE 'G%';

SELECT a.nombre
FROM autor a
JOIN libroautor la ON la.idAutor = a.idAutor
JOIN libro l ON l.idLibro = la.idLibro
WHERE l.titulo = 'El Universo: Guía de viaje';

SELECT l.*
FROM libro l
JOIN prestamo p ON p.idLibro = l.idLibro
JOIN estudiante e ON e.idLector = p.idLector
WHERE e.nombre = 'Filippo'
AND e.apellido = 'Galli';

SELECT nombre
FROM estudiante
WHERE edad = (SELECT MIN(edad)
			FROM estudiante);
            
SELECT e.nombre
FROM estudiante e
JOIN prestamo p ON e.idLector = p.idLector
JOIN libro l ON p.idLibro = l.idLibro
WHERE l.area = 'Base de datos';

SELECT l.*
FROM libro l
JOIN libroautor la ON  l.idLibro = la.idLibro
JOIN autor a ON la.idAutor = a.idAutor
WHERE a.nombre = 'J.K. Rowling';

SELECT l.titulo
FROM libro l
JOIN prestamo p ON p.idLibro = l.idLibro
WHERE p.fechadevolucion = '2021-07-16';
