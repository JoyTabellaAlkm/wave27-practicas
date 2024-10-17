USE biblioteca_db;

-- Eliminar tablas si existen
DROP TABLE IF EXISTS autor;
DROP TABLE IF EXISTS estudiante;
DROP TABLE IF EXISTS libro;
DROP TABLE IF EXISTS libroautor;
DROP TABLE IF EXISTS prestamo;


-- Crear las tablas necesarias
CREATE TABLE AUTOR (
    idAutor INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100),
    Nacionalidad VARCHAR(50)
);

CREATE TABLE ESTUDIANTE (
    idLector INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100),
    Apellido VARCHAR(100),
    Direccion VARCHAR(255),
    Carrera VARCHAR(100),
    Edad INT
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
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

CREATE TABLE PRESTAMO (
    idLector INT,
    idLibro INT,
    FechaPrestamo DATE,
    FechaDevolucion DATE,
    Devuelto BOOLEAN,
    PRIMARY KEY (idLector, idLibro),
    FOREIGN KEY (idLector) REFERENCES ESTUDIANTE(idLector),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

-- Insertar en las tablas 

INSERT INTO AUTOR (Nombre, Nacionalidad) VALUES 
('J.K. Rowling', 'Británica'),
('Gabriel García Márquez', 'Colombiana'),
('Albert Camus', 'Francesa'),
('Italo Calvino', 'Italiana'),
('George Orwell', 'Británica'),
('Maria Perez Marquez','Española');

INSERT INTO ESTUDIANTE (Nombre, Apellido, Direccion, Carrera, Edad) VALUES 
('Filippo', 'Galli', 'Via Roma 1', 'Informática', 22),
('María', 'López', 'Calle Falsa 123', 'Ingeniería', 20),
('Lucía', 'Martínez', 'Avenida Siempre Viva 456', 'Informática', 21),
('Juan', 'Pérez', 'Boulevard de los Sueños 789', 'Literatura', 23),
('Ana', 'García', 'Calle de la Esperanza 101', 'Biología', 19);


INSERT INTO LIBRO (Titulo, Editorial, Area) VALUES 
('Harry Potter y la piedra filosofal', 'Salamandra', 'Ficción'),
('Cien años de soledad', 'Editorial Sudamericana', 'Literatura'),
('El extranjero', 'Random House', 'Ficción'),
('Las ciudades invisibles', 'Tusquets', 'Literatura'),
('1984', 'Planeta', 'Ficción'),
('Administracion Basica de Base de datos', 'Alfaomega','Base de Datos');

INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES 
(1, 1),  -- J.K. Rowling - Harry Potter
(2, 2),  -- Gabriel García Márquez - Cien años de soledad
(3, 3),  -- Albert Camus - El extranjero
(4, 4),  -- Italo Calvino - Las ciudades invisibles
(5, 5),  -- George Orwell - 1984
(6,6);   -- Maria Perez Marquez


INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES 
(1, 1, '2021-07-01', '2021-07-15', TRUE),  -- Filippo Galli
(2, 2, '2021-07-05', '2021-07-20', TRUE),  -- María López
(3, 3, '2021-07-10', '2021-07-25', FALSE), -- Lucía Martínez
(4, 4, '2021-07-12', '2021-07-29', TRUE),  -- Juan Pérez
(5, 5, '2021-07-15', '2021-07-30', FALSE), -- Ana García
(1, 6, '2021-07-01', '2021-07-16', FALSE); -- Filippo Galli
   
   
   
   
   