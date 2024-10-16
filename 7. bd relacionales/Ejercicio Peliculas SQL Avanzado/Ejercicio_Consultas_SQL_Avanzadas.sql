# EJERCICIO 1
CREATE TEMPORARY TABLE TWD(
SELECT e.*, sea.title AS season_title FROM episodes AS e 
JOIN seasons AS sea ON e.season_id = sea.id
JOIN series AS ser ON sea.serie_id = ser.id
WHERE ser.title = 'The Walking Dead'
);

SELECT * FROM TWD;

SELECT * FROM TWD WHERE season_title = 'Primer Temporada';

# EJERCICIO 2
ALTER TABLE `movies_db`.`movies` 
ADD INDEX `rating_idx` (`rating` ASC) VISIBLE;
;

SELECT * FROM movies WHERE rating = 5.7;
EXPLAIN SELECT * FROM movies WHERE rating = 5.7;