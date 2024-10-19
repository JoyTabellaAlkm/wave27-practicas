#Mostrar el título y el nombre del género de todas las series
SELECT title,genres.name
FROM series INNER JOIN genres
ON series.genre_id = genres.id;

# Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT DISTINCT epi.title,ac.first_name,ac.last_name
FROM actor_episode as ac_epi 
INNER JOIN actors as ac
ON ac_epi.actor_id = ac.id
INNER JOIN episodes as epi
ON ac_epi.episode_id = epi.id;

#Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT se.title as titulo, SUM(seasons.number) as episodios
FROM seasons
INNER JOIN series as se
ON seasons.serie_id = se.id
GROUP BY se.id;

#Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, COUNT(*) as cantidad_peliculas
FROM movies as m
INNER JOIN genres as g
ON m.genre_id = g.id
GROUP BY g.id
HAVING cantidad_peliculas>3;

#Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT ac.first_name, ac.last_name
FROM actor_movie AS ac_mo
INNER JOIN movies AS m ON ac_mo.movie_id = m.id
INNER JOIN actors AS ac ON ac_mo.actor_id = ac.id
WHERE m.title LIKE 'La Guerra de las Galaxias%'
GROUP BY ac.first_name, ac.last_name, ac.id
HAVING COUNT(DISTINCT m.id) = (SELECT COUNT(*) FROM movies WHERE title LIKE 'La Guerra de las Galaxias%');
 
