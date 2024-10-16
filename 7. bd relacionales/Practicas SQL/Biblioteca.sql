
-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS biblioteca_db;
USE biblioteca_db;

-- Crear la tabla AUTOR
CREATE TABLE Autor (
    idAutor INT AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    Nacionalidad VARCHAR(50) NOT NULL,
    PRIMARY KEY (idAutor)
);

-- Crear la tabla LIBRO
CREATE TABLE Libro (
    idLibro INT AUTO_INCREMENT,
    Titulo VARCHAR(255) NOT NULL,
    Editorial VARCHAR(100) NOT NULL,
    Area VARCHAR(100) NOT NULL,
    PRIMARY KEY (idLibro)
);

-- Crear la tabla ESTUDIANTE
CREATE TABLE Estudiante (
    idLector INT AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    Apellido VARCHAR(100) NOT NULL,
    Direccion VARCHAR(255) NOT NULL,
    Carrera VARCHAR(100) NOT NULL,
    Edad INT NOT NULL,
    PRIMARY KEY (idLector)
);

-- Crear la tabla LIBROAUTOR (relación muchos a muchos)
CREATE TABLE LibroAutor (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES Autor(idAutor) ON DELETE CASCADE,
    FOREIGN KEY (idLibro) REFERENCES Libro(idLibro) ON DELETE CASCADE
);

-- Crear la tabla PRESTAMO
CREATE TABLE Prestamo (
    idLector INT,
    idLibro INT,
    FechaPrestamo DATE NOT NULL,
    FechaDevolucion DATE NOT NULL,
    Devuelto BOOLEAN NOT NULL,
    PRIMARY KEY (idLector, idLibro),
    FOREIGN KEY (idLector) REFERENCES Estudiante(idLector) ON DELETE CASCADE,
    FOREIGN KEY (idLibro) REFERENCES Libro(idLibro) ON DELETE CASCADE
);