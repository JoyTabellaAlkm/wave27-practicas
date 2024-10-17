
USE movies_db;


#Ejercicio 1
CREATE TEMPORARY TABLE TWD(
	Serie VARCHAR(45),
    Temporada VARCHAR(45),
    Temporada_numero VARCHAR(45),
    Episodio VARCHAR(45),
    Rating DECIMAL(3,1)
);

INSERT INTO TWD (Serie, Temporada, Temporada_numero, Episodio, Rating)
SELECT se.title AS Serie, 
       s.title AS Temporada, 
       s.number AS Temporada_numero, 
       e.title AS Episodio, 
       e.rating AS Rating 
FROM seasons s
JOIN episodes e ON e.season_id = s.id
JOIN series se ON s.serie_id = se.id
WHERE s.serie_id = 3;

SELECT * FROM TWD;

#Ejercicio 1
INSERT INTO movies(title, rating, awards, release_date, length, genre_id)
VALUES ("TED 2", 8.9, 2, "2015-08-13", 95, 1);

SELECT * FROM movies 
WHERE title = "TED 2";

#Ejercicio 2
INSERT INTO genres(name, ranking, active, created_at)
VALUES ("Terror psicologico", 13, 1, "2024-10-10");

SELECT * FROM actors;

#Ejercicio 3
UPDATE movies SET genre_id = 13
WHERE id  = 21;

#Ejercicio 4
UPDATE actors SET favorite_movie_id = 22
WHERE id = 3;

#Ejercicio 5
CREATE TEMPORARY TABLE movies_copy(
	id INT, 
    title VARCHAR(100),
    rating DECIMAL(3,1),
    awards INT,
    release_date DATETIME,
    length INT,
    genre_id INT
);


INSERT INTO movies_copy(id, title, rating, awards, release_date, length, genre_id)
SELECT id, title, rating, awards, release_date, length, genre_id FROM movies;

SELECT * FROM movies_copy;

CREATE INDEX idx_title ON movies_copy(title);

#Ejercicio 6
DELETE FROM movies_copy WHERE awards < 5;

#Ejercicio 7 
SELECT DISTINCT g.name
FROM genres g
JOIN movies m ON m.genre_id = g.id;

#Ejercicio 8
SELECT a.first_name AS Name, a.last_name AS "Last Name" FROM actors a
JOIN movies m ON m.id = a.favorite_movie_id
WHERE m.awards > 3;

#Bonus
SELECT g.name, SUM(m.awards) AS awards
FROM genres g
JOIN movies m ON m.genre_id = g.id
GROUP BY g.name
HAVING SUM(m.awards) > 4;

#Ejercicio 9
CREATE INDEX idx_title ON movies(title);
DROP INDEX idx_title ON movies;

EXPLAIN SELECT * FROM movies WHERE title = "TED 2";
#Ejercicio 10
SHOW INDEX FROM movies;

CREATE INDEX idx_name ON actors(first_name);
DROP INDEX idx_name ON actors;

EXPLAIN SELECT * FROM actors 
WHERE first_name = "Sam";

SELECT * FROM actors 
WHERE  last_name = "Worthington" and first_name = "Sam";
