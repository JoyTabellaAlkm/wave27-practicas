### Tablas Supuestas

1. **Autores**
   - `id_autor` (PK)
   - `nombre`
   - `apellido`
   - `nacionalidad`

2. **Estudiantes**
   - `id_estudiante` (PK)
   - `nombre`
   - `apellido`
   - `edad`
   - `carrera`

3. **Libros**
   - `id_libro` (PK)
   - `titulo`
   - `area`
   - `editorial`
   - `id_autor` (FK)

4. **Prestamos**
   - `id_prestamo` (PK)
   - `id_libro` (FK)
   - `id_estudiante` (FK)
   - `fecha_devolucion`

### Consultas SQL

1. **Listar los datos de los autores.**
   ```sql
   SELECT * FROM Autores;
   ```

2. **Listar nombre y edad de los estudiantes.**
   ```sql
   SELECT nombre, edad FROM Estudiantes;
   ```

3. **¿Qué estudiantes pertenecen a la carrera informática?**
   ```sql
   SELECT * FROM Estudiantes WHERE carrera = 'Informática';
   ```

4. **¿Qué autores son de nacionalidad francesa o italiana?**
   ```sql
   SELECT * FROM Autores WHERE nacionalidad IN ('Francesa', 'Italiana');
   ```

5. **¿Qué libros no son del área de internet?**
   ```sql
   SELECT * FROM Libros WHERE area <> 'Internet';
   ```

6. **Listar los libros de la editorial Salamandra.**
   ```sql
   SELECT * FROM Libros WHERE editorial = 'Salamandra';
   ```

7. **Listar los datos de los estudiantes cuya edad es mayor al promedio.**
   ```sql
   SELECT * FROM Estudiantes WHERE edad > (SELECT AVG(edad) FROM Estudiantes);
   ```

8. **Listar los nombres de los estudiantes cuyo apellido comience con la letra G.**
   ```sql
   SELECT nombre FROM Estudiantes WHERE apellido LIKE 'G%';
   ```

9. **Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).**
   ```sql
   SELECT a.nombre
   FROM Autores a
   JOIN Libros l ON a.id_autor = l.id_autor
   WHERE l.titulo = 'El Universo: Guía de viaje';
   ```

10. **¿Qué libros se prestaron al lector “Filippo Galli”?**
    ```sql
    SELECT l.titulo
    FROM Libros l
    JOIN Prestamos p ON l.id_libro = p.id_libro
    JOIN Estudiantes e ON p.id_estudiante = e.id_estudiante
    WHERE CONCAT(e.nombre, ' ', e.apellido) = 'Filippo Galli';
    ```

11. **Listar el nombre del estudiante de menor edad.**
    ```sql
    SELECT nombre
    FROM Estudiantes
    ORDER BY edad ASC
    LIMIT 1;
    ```

12. **Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.**
    ```sql
    SELECT e.nombre
    FROM Estudiantes e
    JOIN Prestamos p ON e.id_estudiante = p.id_estudiante
    JOIN Libros l ON p.id_libro = l.id_libro
    WHERE l.titulo LIKE '%Base de Datos%';
    ```

13. **Listar los libros que pertenecen a la autora J.K. Rowling.**
    ```sql
    SELECT l.titulo
    FROM Libros l
    JOIN Autores a ON l.id_autor = a.id_autor
    WHERE a.nombre = 'J.K.' AND a.apellido = 'Rowling';
    ```

14. **Listar títulos de los libros que debían devolverse el 16/07/2021.**
    ```sql
    SELECT l.titulo
    FROM Libros l
    JOIN Prestamos p ON l.id_libro = p.id_libro
    WHERE p.fecha_devolucion = '2021-07-16';
    ```

### Ejercicio 2: Implementación

Para implementar la base de datos:

1. **Crear la Base de Datos y las Tablas**: Usa el siguiente esquema (ajusta según el DER):

   ```sql
   CREATE DATABASE biblioteca;
   USE biblioteca;

   CREATE TABLE Autores (
       id_autor INT AUTO_INCREMENT PRIMARY KEY,
       nombre VARCHAR(50),
       apellido VARCHAR(50),
       nacionalidad VARCHAR(50)
   );

   CREATE TABLE Estudiantes (
       id_estudiante INT AUTO_INCREMENT PRIMARY KEY,
       nombre VARCHAR(50),
       apellido VARCHAR(50),
       edad INT,
       carrera VARCHAR(50)
   );

   CREATE TABLE Libros (
       id_libro INT AUTO_INCREMENT PRIMARY KEY,
       titulo VARCHAR(100),
       area VARCHAR(50),
       editorial VARCHAR(50),
       id_autor INT,
       FOREIGN KEY (id_autor) REFERENCES Autores(id_autor)
   );

   CREATE TABLE Prestamos (
       id_prestamo INT AUTO_INCREMENT PRIMARY KEY,
       id_libro INT,
       id_estudiante INT,
       fecha_devolucion DATE,
       FOREIGN KEY (id_libro) REFERENCES Libros(id_libro),
       FOREIGN KEY (id_estudiante) REFERENCES Estudiantes(id_estudiante)
   );
   ```

2. **Cargar Registros**: Inserta cinco registros en cada tabla:

   ```sql
   -- Autores
   INSERT INTO Autores (nombre, apellido, nacionalidad) VALUES
   ('Gabriel', 'García Márquez', 'Colombiana'),
   ('J.K.', 'Rowling', 'Británica'),
   ('Isaac', 'Asimov', 'Rusa'),
   ('Stephen', 'King', 'Estadounidense'),
   ('Margaret', 'Atwood', 'Canadiense');

   -- Estudiantes
   INSERT INTO Estudiantes (nombre, apellido, edad, carrera) VALUES
   ('Filippo', 'Galli', 20, 'Informática'),
   ('María', 'Lopez', 22, 'Ingeniería'),
   ('Javier', 'Gómez', 19, 'Informática'),
   ('Ana', 'Pérez', 21, 'Literatura'),
   ('César', 'Alonso', 23, 'Historia');

   -- Libros
   INSERT INTO Libros (titulo, area, editorial, id_autor) VALUES
   ('El Universo: Guía de viaje', 'Astronomía', 'Salamandra', 1),
   ('Harry Potter y la piedra filosofal', 'Ficción', 'Salamandra', 2),
   ('Fundación', 'Ciencia ficción', 'Debolsillo', 3),
   ('El resplandor', 'Terror', 'Alfaguara', 4),
   ('El cuento de la criada', 'Ficción', 'Salamandra', 5);

   -- Prestamos
   INSERT INTO Prestamos (id_libro, id_estudiante, fecha_devolucion) VALUES
   (1, 1, '2021-07-01'),
   (2, 2, '2021-07-05'),
   (3, 1, '2021-07-10'),
   (4, 3, '2021-07-15'),
   (5, 4, '2021-07-20');
   ```

3. **Probar las Consultas**: Ejecuta las consultas SQL planteadas en el Ejercicio 1 en tu entorno de trabajo (PHPMyAdmin o MySQL Workbench) para verificar que funcionen correctamente y devuelvan los resultados esperados.

Si necesitas más ayuda con un paso específico, ¡hazmelo saber!