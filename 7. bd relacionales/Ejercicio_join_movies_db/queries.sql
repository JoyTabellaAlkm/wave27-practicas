-- Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name 
FROM series s 
LEFT JOIN genres g ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title ,a.first_name, a.last_name 
FROM actor_episode ae
LEFT JOIN actors a ON ae.actor_id = a.id
LEFT JOIN episodes e ON ae.episode_id = e.id
ORDER BY e.title;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT sea.serie_id, ser.title, count(*)
FROM seasons sea
LEFT JOIN series ser ON sea.serie_id = ser.id
GROUP BY sea.serie_id, ser.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, COUNT(*) AS movie_count
FROM movies m
LEFT JOIN genres g ON m.genre_id = g.id
GROUP BY g.name
HAVING COUNT(*) >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT a.first_name, a.last_name
FROM actor_movie am
LEFT JOIN actors a ON am.actor_id = a.id
LEFT JOIN movies m ON am.movie_id = m.id
WHERE m.title like "La Guerra de las galaxias%";
