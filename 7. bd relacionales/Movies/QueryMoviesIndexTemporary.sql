USE movies_db;

-- Agregar una película a la tabla movies.
INSERT INTO movies (created_at, updated_at, title, rating, awards, release_date,
length, genre_id) VALUES
(null, null, 'El Rey León', 10.0, 11, '2004-07-04', 320, 10);

-- Agregar un género a la tabla genres.
INSERT INTO genres (created_at, updated_at, name, ranking, active) VALUES
('2024-10-16', null, 'Halloween', 13, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies 
SET genre_id = 13 
WHERE id = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita 
-- la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = 22
WHERE favorite_movie_id IS null;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE copia_movies (id INT, created_at timestamp, updated_at timestamp,
title varchar(500), rating decimal(3,1), awards INT, release_date datetime,
length INT, genre_id INT);

INSERT INTO copia_movies SELECT *
FROM movies;

SELECT *
FROM copia_movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0; -- Porque si no, no me deja borrar

DELETE copia_movies
FROM copia_movies
WHERE awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT g.* -- No va a mostrar nulos
FROM genres g
JOIN movies m ON m.genre_id = g.id;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.*
FROM actors a
JOIN movies m ON m.id = a.favorite_movie_id
WHERE m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX movies_titlex
ON movies(title);

SELECT *
FROM actors;

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- En la tabla de actores que actuaron en esa película ya que puede ser también
-- una tabla muy consultada
CREATE INDEX actor_first_namex
ON actors(first_name);

SELECT first_name
FROM actors
WHERE first_name = 'Leonardo';