-- 1. Listar los datos de los autores.
   SELECT * FROM AUTOR;

-- 2.Listar nombre y edad de los estudiantes.

   SELECT 
	Nombre, 
	Edad 
   FROM ESTUDIANTE;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?

   SELECT 
	* 
   FROM ESTUDIANTE WHERE Carrera = 'Informática';
   
-- 4. ¿Qué autores son de nacionalidad francesa o italiana?

   SELECT 
	* 
   FROM AUTOR 
   WHERE Nacionalidad IN ('Francesa', 'Italiana');
   
-- 5. ¿Qué libros no son del área de internet?

   SELECT 
	* 
   FROM LIBRO 
   WHERE Area <> 'Internet';
   

-- 6. Listar los libros de la editorial Salamandra.

   SELECT 
	* 
   FROM LIBRO WHERE Editorial = 'Salamandra';
   
-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.

   SELECT
	* 
   FROM ESTUDIANTE 
   WHERE Edad > (SELECT AVG(Edad) FROM ESTUDIANTE);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.

   SELECT 
	Nombre,
    Apellido
   FROM ESTUDIANTE 
   WHERE Apellido LIKE 'G%';
   


-- 9.Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).

SELECT 
    A.Nombre 
FROM AUTOR A 
WHERE A.idAutor IN (
        SELECT 
            LA.idAutor 
        FROM LIBROAUTOR LA 
        WHERE LA.idLibro IN (
                SELECT 
                    L.idLibro 
                FROM LIBRO L 
                WHERE L.Titulo = 'El Universo: Guía de viaje'
            )
    );
   
-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT 
    L.* 
FROM LIBRO L 
WHERE L.idLibro IN (
        SELECT 
            P.idLibro 
        FROM PRESTAMO P 
        WHERE P.idLector IN (
                SELECT 
                    E.idLector 
                FROM ESTUDIANTE E 
                WHERE E.Nombre = 'Filippo' 
                AND E.Apellido = 'Galli'
            )
    );
    
-- 11. Listar el nombre del estudiante de menor edad.

    SELECT 
		Nombre 
    FROM ESTUDIANTE 
    WHERE Edad = (SELECT MIN(Edad) FROM ESTUDIANTE);
    

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.

SELECT 
    E.Nombre 
FROM ESTUDIANTE E 
WHERE E.idLector IN (
        SELECT 
            P.idLector 
        FROM PRESTAMO P 
        WHERE P.idLibro IN (
                SELECT 
                    L.idLibro 
                FROM LIBRO L 
                WHERE L.Area = 'Base de Datos'
            )
    );
    

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.

SELECT 
    L.* 
FROM LIBRO L 
WHERE L.idLibro IN (
        SELECT 
            LA.idLibro 
        FROM LIBROAUTOR LA 
        WHERE LA.idAutor IN (
				SELECT 
                    A.idAutor 
                FROM AUTOR A 
                WHERE A.Nombre = 'J.K. Rowling'
            )
    );
    

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
    SELECT 
		L.Titulo 
    FROM LIBRO L 
    JOIN PRESTAMO P ON L.idLibro = P.idLibro 
    WHERE P.FechaDevolucion = '2021-07-16';