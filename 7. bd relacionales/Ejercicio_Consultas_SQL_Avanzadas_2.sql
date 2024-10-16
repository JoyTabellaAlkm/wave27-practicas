# CONSULTAS AVANZADAS SQL 2
SET SQL_SAFE_UPDATES = 0;
# Agregar una película a la tabla movies.
INSERT INTO movies(title,rating,awards,release_date,length) VALUES('El diario de una pasión', 7.6, 2, '2004-10-10', 120);
# Agregar un género a la tabla genres.
INSERT INTO genres(created_at, name, ranking, active) VALUES('2024-10-16 15:13:00','Romance', 13, 1);
# Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = 13 WHERE id = 22;
# Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 22 WHERE id = 3;
# Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy(
SELECT * FROM movies
);
# Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SELECT * FROM movies_copy;
DELETE FROM movies_copy WHERE awards < 5; 
SELECT * FROM movies_copy;
# Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.name, COUNT(*) AS number_movies FROM genres AS g 
INNER JOIN movies AS m ON g.id = m.genre_id 
GROUP BY g.name ORDER BY 2;
# Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name, m.title, m.awards FROM actors AS a
INNER JOIN movies AS m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;
# Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX title_idx
ON movies(title);
# Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;
EXPLAIN SELECT * FROM movies WHERE title = 'El diario de una pasión'; 
# En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
# R. Sí, habría una busqueda de datos más eficiente y veloz ya que se necesitan realizar varias consultas
# ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
# R. Otra tabla en la que creariamos un indice sería en 'movies' en el atributo 'awards', ya 
# que nos permite optimizar posibles operaciones que se realicen en este atributo.