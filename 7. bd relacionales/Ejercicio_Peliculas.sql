-- Mostrar todos los registros de la tabla de movies

SELECT * FROM movies;

-- Mostrar el nombre, apellido y rating de todos los actores

SELECT 
 first_name AS nombre,
 last_name AS apellido, 
 rating
FROM actors;

-- Mostrar el título de todas las series y usar alias 
-- para que tanto el nombre de la tabla como el campo estén en español

SELECT 
	title AS 'Título de la Serie'
FROM series; 

-- Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5

SELECT 
	first_name AS nombre, 
	last_name AS apellido
FROM actors
WHERE rating > 7.5;

-- Mostrar el título de las películas, el rating y los premios de las películas 
-- con un rating mayor a 7.5 y con más de dos premios

SELECT title AS 'Título', 
	rating AS 'Rating', 
	awards AS 'Premios'
FROM movies
WHERE rating > 7.5 AND awards > 2;

-- Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente
SELECT 
	title AS 'Título', 
	rating AS 'Rating'
FROM movies
ORDER BY rating ASC;

-- Mostrar los títulos de las primeras tres películas en la base de datos
SELECT 
	title AS 'Título'
FROM movies
LIMIT 3;

-- Mostrar el top 5 de las películas con mayor rating
SELECT 
	title AS 'Título', 
	rating AS 'Rating'
FROM movies
ORDER BY rating DESC
LIMIT 5;

-- Listar los primeros 10 actores

SELECT 
	first_name AS nombre, 
	last_name AS apellido
FROM actors
LIMIT 10;

-- Mostrar el título y rating de todas las películas cuyo título sea de "Toy Story"
SELECT 
	title AS 'Título', 
	rating AS 'Rating'
FROM movies
WHERE title = 'Toy Story';

-- Mostrar a todos los actores cuyos nombres empiezan con "Sam"

SELECT 
	first_name AS nombre, 
	last_name AS apellido
FROM actors
WHERE first_name LIKE 'Sam%';

-- Mostrar el título de las películas que salieron entre el 2004 y 2008

SELECT 
	title AS 'Título'
FROM movies
WHERE YEAR(release_date) BETWEEN 2004 AND 2008;

-- Traer el título de las películas con el rating mayor a 3, con más de 1 premio 
-- y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating

SELECT 
	title AS 'Título'
FROM movies
WHERE rating > 3 
	AND awards > 1 
    AND YEAR(release_date)
    BETWEEN 1988 AND 2009  
ORDER BY rating;

/*Parte dos del ejercicio de peliculas - Miercoles 16*/

-- Mostrar el título y el nombre del género de todas las series.
SELECT 
	s.title AS Serie_Title, 
	g.name AS Genre_Name
FROM series s
JOIN genres g ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos

SELECT 
	e.title AS Episode_Title, 
    a.first_name AS Actor_First_Name, 
    a.last_name AS Actor_Last_Name
FROM episodes e
JOIN actor_episode ae ON e.id = ae.id
JOIN actors a ON ae.id = a.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas
SELECT 
	s.title AS Serie_Title, 
    COUNT(se.id) AS Total_Seasons
FROM series s
LEFT JOIN seasons se ON s.id = se.id
GROUP BY s.id;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3

SELECT 
	g.name AS Genre_Name, 
    COUNT(m.id) AS Total_Movies
FROM genres g
JOIN movies m ON g.id = m.genre_id
GROUP BY g.id
HAVING COUNT(m.id) >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan

SELECT DISTINCT 
a.first_name AS Actor_First_Name, 
a.last_name AS Actor_Last_Name
FROM actors a
JOIN actor_movie am ON a.id = am.actor_id
JOIN movies m ON am.movie_id = m.id
WHERE m.title LIKE '%La guerra de las galaxias%'
GROUP BY a.id
HAVING COUNT(DISTINCT m.id) = (SELECT COUNT(*) FROM movies WHERE title LIKE '%La guerra de las galaxias%');

/*Ejercicio de la parte de normalizacion*/





