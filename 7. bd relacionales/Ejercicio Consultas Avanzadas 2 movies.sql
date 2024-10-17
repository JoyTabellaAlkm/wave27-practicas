USE movies_db;

-- 1. Agregar una película a la tabla movies.
INSERT INTO movies
(created_at, updated_at, title, rating, awards, release_date, length, genre_id)
VALUES
(NULL, NULL, "Charlie y la Fábrica de Chocolate", 8.6, 3, "2016-08-12", 102, 1);

-- 2. Agregar un género a la tabla genres.
INSERT INTO genres
(created_at, updated_at, name, ranking, active)
VALUES
(NULL, NULL, "Thriller", 13, 1);

-- 3. Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET genre_id = (SELECT id FROM genres WHERE name = "Thriller")
WHERE title = "Charlie y la Fábrica de Chocolate";

-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = (SELECT id FROM movies WHERE title = "Charlie y la Fábrica de Chocolate")
WHERE id = 1;

-- 5. Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy
SELECT * FROM movies;

-- 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_copy
WHERE awards < 5;

-- 7. Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.name
FROM genres g
JOIN movies m ON m.genre_id = g.id
GROUP BY g.id
HAVING COUNT(m.id) > 0;

-- 7. Opción B (más performante, no hace falta nada más ya que el inner join no va a traer géneros matcheados con películas NULL)
SELECT DISTINCT g.name
FROM genres g
JOIN movies m ON m.genre_id = g.id;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name -- , m.title, m.awards
FROM actors a
JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- 9. Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX index_title
ON movies (title);

-- 10. Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- 11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
/*
	No sabemos cómo se utilizará la base de datos, pero creeríamos que sí existiría una mejora notable al crear índices,
    ya que mejoraría la velocidad de búsqueda si, por ejemplo, quisiéramos buscar actores por nombre o apellido, o
    películas por rating.
*/

-- 12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
/*
	Nombre y apellido de actores, rating de películas. Por lo justificado en el punto 11.
*/