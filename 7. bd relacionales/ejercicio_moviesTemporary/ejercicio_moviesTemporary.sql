USE movies_db;

-- Ejercicio 1
-- 1. Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE TWD (
    id INT NOT NULL PRIMARY KEY,
    title VARCHAR(255),
    rating DECIMAL(5,1),
    season INT
);

INSERT INTO TWD (id, title, rating, season)
SELECT e.id, e.title, e.rating, s.number AS season
FROM episodes e
JOIN seasons s ON s.id = e.season_id 
JOIN series se ON s.serie_id = se.id
WHERE se.title = 'The Walking Dead';

SELECT * FROM TWD;

-- 2. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT *
FROM TWD
WHERE season = 1;

-- 3. En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
-- Opcion 1:
ALTER TABLE `movies_db`.`movies` 
ADD INDEX `indice_titulo` (`title` ASC) VISIBLE;

-- Opcion 2:
CREATE INDEX indice_release_date ON movies (release_date);

SHOW INDEX FROM movies;

-- 4. 
-- Elegimos crear índices para titulo y fecha de lanzamiento debido a que creemos que el título es lo más buscado por los usuarios, y la fecha de lanzamiento es útil para ordenar las películas por antigüedad.