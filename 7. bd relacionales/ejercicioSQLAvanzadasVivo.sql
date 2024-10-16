-- Implementar la base de datos
CREATE DATABASE biblioteca_db;
USE biblioteca_db;

CREATE TABLE libro(
idLibro INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
titulo VARCHAR(255),
editorial VARCHAR(255),
categoria VARCHAR(255)
);

CREATE TABLE autor(
idAutor INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
nombre VARCHAR(255),
nacionalidad VARCHAR(255)
);

CREATE TABLE libroAutor(
idAutor INT,
idLibro INT,
FOREIGN KEY (idAutor) REFERENCES autor(idAutor),
FOREIGN KEY (idLibro) REFERENCES libro(idLibro)
);

CREATE TABLE estudiante(
idLector INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
nombre VARCHAR(255),
apellido VARCHAR(255),
direccion VARCHAR(255),
carrera VARCHAR(255),
edad INT
);

CREATE TABLE prestamo(
idLector INT,
idLibro INT,
fechaPrestamo DATE,
fechaDevolucion DATE,
devuelto BOOL
);

-- Cargar 5 registros en cada tabla
INSERT INTO libro(titulo, editorial, categoria) VALUES("El retrato de Dorian Grey", "Alma Ilustrados", "Drama");
INSERT INTO libro(titulo, editorial, categoria) VALUES("Orgullo y prejuicio", "Alma Ilustrados", "Romance");
INSERT INTO libro(titulo, editorial, categoria) VALUES("El principito", "Salamandra", "Infantil");
INSERT INTO libro(titulo, editorial, categoria) VALUES("Harry Potter: La orden del fénix", "Salamandra", "Novela fantástica");
INSERT INTO libro(titulo, editorial, categoria) VALUES("Mujercitas", "Alma Ilustrados", "Novela");

INSERT INTO autor(nombre, nacionalidad) VALUES("Oscar Wilde", "Irlandés");
INSERT INTO autor(nombre, nacionalidad) VALUES("Jane Austen", "Británica");
INSERT INTO autor(nombre, nacionalidad) VALUES("Antoine de Saint-Exupéry", "Francé");
INSERT INTO autor(nombre, nacionalidad) VALUES("J.K Rowling", "Británica");
INSERT INTO autor(nombre, nacionalidad) VALUES("Louisa May Alcott", "Estadounidense");

INSERT INTO libroAutor(idAutor, idLibro) VALUES(1,1);
INSERT INTO libroAutor(idAutor, idLibro) VALUES(2,2);
INSERT INTO libroAutor(idAutor, idLibro) VALUES(3,3);
INSERT INTO libroAutor(idAutor, idLibro) VALUES(4,4);
INSERT INTO libroAutor(idAutor, idLibro) VALUES(5,5);

INSERT INTO estudiante(nombre, apellido, direccion, carrera, edad) VALUES("Pepito", "Perez", "Calle Elm 123", "Ingeniería Ambiental", 25);
INSERT INTO estudiante(nombre, apellido, direccion, carrera, edad) VALUES("Camila", "Arbelaez", "Calle Elm 456", "Ingeniería de Software", 21);
INSERT INTO estudiante(nombre, apellido, direccion, carrera, edad) VALUES("Stefany", "Solano", "Calle Elm 678", "Física", 27);
INSERT INTO estudiante(nombre, apellido, direccion, carrera, edad) VALUES("Sofia", "Montoya", "Calle Elm 890", "Ingeniería de Software", 21);
INSERT INTO estudiante(nombre, apellido, direccion, carrera, edad) VALUES("Maria", "Bolivar", "Calle Elm 768", "Química", 23);

INSERT INTO prestamo(idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES(1, 1, "2024-08-10", "2024-09-10", 0);
INSERT INTO prestamo(idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES(2, 2, "2019-08-10", "2019-09-10", 1);
INSERT INTO prestamo(idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES(3, 3, "2020-08-10", "2020-09-10", 1);
INSERT INTO prestamo(idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES(4, 4, "2021-06-16", "2021-07-17", 0);
INSERT INTO prestamo(idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES(5, 5, "2024-08-16", "2024-09-17", 0);

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiante WHERE edad > (SELECT AVG(edad) FROM estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre, apellido FROM estudiante WHERE nombre LIKE("G%");

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT * FROM libro WHERE idLibro IN (SELECT idLibro FROM prestamo WHERE fechaDevolucion = "2021-07-17");

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT libro.* FROM libro INNER JOIN libroAutor ON libroAutor.idLibro = libro.idLibro WHERE libroAutor.idAutor = (SELECT idAutor FROM autor WHERE nombre = "J.K Rowling");
