USE movies_db;
SELECT * FROM episodes;
SELECT * FROM series;

-- Ejercicio 1

-- 1. Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.

CREATE TEMPORARY TABLE TWD (
    id INT NOT NULL PRIMARY KEY,
    title VARCHAR(255),
    rating DECIMAL(5,1),
    season INT
);

INSERT INTO TWD (id, title, rating, season)
SELECT id, title, rating, season_id
FROM episodes
WHERE number = (SELECT id FROM series WHERE title = 'The Walking Dead');
SELECT * FROM TWD;

-- 2. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.

SELECT *
FROM TWD
WHERE season = 46;

-- 3. En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
-- Opcion 1:
ALTER TABLE `movies_db`.`movies` 
ADD INDEX `indice_titulo` (`title` ASC) VISIBLE;

-- Opcion 2:
create index indice_release_date on movies (release_date);

SHOW INDEX FROM movies;

-- 4. 
-- Elegimos crear índices para titulo y fecha de lanzamiento debido a que creemos que el título es lo más buscado por los usuarios, y la fecha de lanzamiento es útil para ordenar las películas por antigüedad.