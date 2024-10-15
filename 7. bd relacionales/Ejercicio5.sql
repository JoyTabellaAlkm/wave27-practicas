-- 1. Mostrar título y nombre del género de todas las series
SELECT se.title, ge.name
FROM series se INNER JOIN genres ge
ON se.genre_id = ge.id;


-- 2. Mostrar titulo de episodios, nombre y apellido de actores que trabajan en cada uno.
SELECT ep.title, ac.first_name, ac.last_name
FROM episodes ep
JOIN actor_episode ae ON ep.id = ae.episode_id
JOIN actors ac ON ae.actor_id = ac.id;

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT se.title, COUNT(sa.id) AS "Total Seasons"
FROM series se
LEFT JOIN seasons sa ON sa.serie_id = se.id
GROUP BY se.id, se.title
ORDER BY se.title;

-- 4. Mostrar el nombre de todos los generos y la cantidad total de películas por cada uno siempre que sea mayor
-- o igual a 3.
SELECT ge.name, COUNT(mo.id) AS movie_count
FROM genres ge
LEFT JOIN movies mo ON ge.id = mo.genre_id
GROUP BY ge.name
HAVING COUNT(mo.id) >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las 
-- galaxias y que estos no se repitan.
SELECT DISTINCT a.first_name, a.last_name
FROM Actors a
JOIN actor_movie am ON a.id = am.actor_id
JOIN movies m ON am.movie_id = m.id
	WHERE m.id IN (SELECT id FROM movies WHERE title LIKE '%La Guerra de las Galaxias%')
GROUP BY a.id
HAVING COUNT(DISTINCT m.id) = (SELECT COUNT(DISTINCT id) FROM movies WHERE title LIKE '%La Guerra de las Galaxias%');