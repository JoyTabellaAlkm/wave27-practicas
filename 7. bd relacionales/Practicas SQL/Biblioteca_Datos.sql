
-- Insertar registros en la tabla AUTOR
INSERT INTO Autor (Nombre, Nacionalidad) VALUES
('Gabriel García Márquez', 'Colombiano'),
('J.K. Rowling', 'Británica'),
('Mario Vargas Llosa', 'Peruano'),
('Isabel Allende', 'Chilena'),
('George Orwell', 'Británico');

-- Insertar registros en la tabla LIBRO
INSERT INTO Libro (Titulo, Editorial, Area) VALUES
('Cien años de soledad', 'Editorial Sudamericana', 'Ficción'),
('Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
('La ciudad y los perros', 'Editorial Seix Barral', 'Ficción'),
('La casa de los espíritus', 'Editorial Plaza & Janés', 'Ficción'),
('1984', 'Editorial Planeta', 'Distopía');

-- Insertar registros en la tabla ESTUDIANTE
INSERT INTO Estudiante (Nombre, Apellido, Direccion, Carrera, Edad) VALUES
('Juan', 'Pérez', 'Calle 123', 'Ingeniería', 20),
('María', 'González', 'Avenida 456', 'Derecho', 22),
('Luis', 'Martínez', 'Calle 789', 'Medicina', 21),
('Ana', 'López', 'Calle 101', 'Arquitectura', 23),
('Pedro', 'Hernández', 'Avenida 202', 'Biología', 19);

-- Insertar registros en la tabla LIBROAUTOR
INSERT INTO LibroAutor (idAutor, idLibro) VALUES
(1, 1),  -- Gabriel García Márquez - Cien años de soledad
(2, 2),  -- J.K. Rowling - Harry Potter y la piedra filosofal
(3, 3),  -- Mario Vargas Llosa - La ciudad y los perros
(4, 4),  -- Isabel Allende - La casa de los espíritus
(5, 5);  -- George Orwell - 1984

-- Insertar registros en la tabla PRESTAMO
INSERT INTO Prestamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 1, '2023-10-01', '2023-10-15', TRUE),
(2, 2, '2023-10-02', '2023-10-16', FALSE),
(3, 3, '2023-10-03', '2023-10-17', TRUE),
(4, 4, '2023-10-04', '2023-10-18', FALSE),
(5, 5, '2023-10-05', '2023-10-19', TRUE);