#Listar los datos de los autores.
SELECT * FROM autor;
#Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM estudiante;
#¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM estudiante WHERE carrera = 'Informatica';
#¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autor WHERE nacionalidad = 'Francesa' OR nacionalidad = 'Italiana';
#¿Qué libros no son del área de internet?
SELECT * FROM libro WHERE area != 'Internet';
#Listar los libros de la editorial Salamandra.
SELECT * FROM libro WHERE editorial = 'Salamandra';
#Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiante WHERE edad > (SELECT AVG(edad) FROM estudiante);
#Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre FROM estudiante WHERE apellido LIKE 'G%';
#Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre FROM autor AS a 
JOIN libro_autor AS la ON a.id_autor = la.id_autor WHERE la.id_libro = 
(SELECT id_libro FROM libro WHERE titulo = 'El Universo: Guía de viaje');
#¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.* FROM libro AS l JOIN prestamo AS p ON l.id_libro = p.id_libro
WHERE p.id_lector IN (SELECT id_lector FROM estudiante WHERE nombre = 'Filippo' AND apellido = 'Galli');
#Listar el nombre del estudiante de menor edad.
SELECT nombre FROM estudiante WHERE edad = 
(SELECT MIN(edad) FROM estudiante);
#Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre FROM estudiante AS e
JOIN prestamo AS p ON e.id_lector = p.id_lector
WHERE p.id_libro IN
(SELECT id_libro FROM libro WHERE area = 'Base de datos');
#Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo FROM libro AS l JOIN libro_autor AS la ON l.id_libro = la.id_libro
WHERE la.id_autor IN
(SELECT id_autor FROM autor WHERE nombre = 'J.K Rowling');
#Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo FROM libro AS l JOIN prestamo AS p ON l.id_libro = p.id_libro
 WHERE p.fecha_devolucion = '2021-07-16';