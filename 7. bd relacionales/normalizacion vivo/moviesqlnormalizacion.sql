/*Ejercicio de la parte de normalizacion*/
DROP TABLE IF EXISTS TWD;
CREATE TEMPORARY TABLE TWD AS
SELECT 
	e.id, 
	e.title, 
    e.release_date, 
    s.number
FROM episodes e
JOIN seasons s ON e.season_id = s.id
JOIN series ser ON s.serie_id = ser.id
WHERE ser.title = 'The Walking Dead';
SELECT *
FROM TWD
WHERE number = 1;
-- Elegir una tabla y crear un indice
CREATE INDEX idx_episode_title ON episodes(title);
-- Verificar la creacion del indice
SHOW INDEX FROM episodes;
-- Insertar en la tabla movies
INSERT INTO movies (title, rating, awards, release_date, length, genre_id)
VALUES ('New Movie Title', 7.5, 3, '2024-10-16', 120, NULL);
-- Agregar un genero
INSERT INTO genres (name,ranking)
VALUES ('New Genre',13);
select * from genres;
-- Asociar a la película del punto 1 con el género creado en el punto 2
SET @new_genre_id = LAST_INSERT_ID();
UPDATE movies 
SET genre_id = @new_genre_id 
WHERE title = 'New Movie Title';
select * from movies;
-- Modificar la tabla `actors` para que al menos un actor tenga como favorita la película agregada en el punto 1
SET @new_movie_id = (SELECT id FROM movies WHERE title = 'New Movie Title');
UPDATE actors 
SET favorite_movie_id = @new_movie_id 
WHERE id = 13;  -- Cambia el criterio para seleccionar el actor si es necesario
select * from actors;
-- crear tabla temporal con copia de movies
CREATE TEMPORARY TABLE temp_movies AS 
SELECT * FROM movies;
select * from temp_movies;
-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards
DELETE FROM temp_movies 
WHERE awards < 5;
-- 7. Obtener la lista de todos los géneros que tengan al menos una película
SELECT g.name 
FROM genres g
JOIN movies m ON g.id = m.genre_id
GROUP BY g.id;
--  8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards
SELECT a.* 
FROM actors a
JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;
-- 9. Crear un índice sobre el nombre en la tabla `movies`
CREATE INDEX idx_movie_title ON movies(title);
-- Chquear que el indice fue creado correctamente
SHOW INDEX FROM movies;