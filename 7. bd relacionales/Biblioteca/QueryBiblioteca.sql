USE biblioteca;

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









