#Mostrar el título y el nombre del género de todas las series
SELECT series.title, genres.name FROM series LEFT JOIN genres ON series.genre_id = genres.id;

#Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT episodes.title, actors.first_name, actors.last_name 
FROM actor_episode INNER JOIN episodes ON actor_episode.episode_id = episodes.id
INNER JOIN actors ON actor_episode.actor_id = actors.id;

#Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title, COUNT(*) AS '# of seasons' 
FROM seasons INNER JOIN series ON seasons.serie_id = series.id 
GROUP BY serie_id;

#Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT genres.name, COUNT(*) AS total FROM movies 
INNER JOIN genres ON movies.genre_id = genres.id
GROUP BY genre_id HAVING total >= 3;

#Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan
SELECT DISTINCT actors.first_name, actors.last_name FROM actor_movie
INNER JOIN actors ON actor_movie.actor_id = actors.id 
WHERE actors.id IN
	(SELECT actor_movie.actor_id FROM actor_movie
	INNER JOIN movies ON actor_movie.movie_id = movies.id 
	WHERE movies.title LIKE 'La Guerra de las galaxias%'
	GROUP BY actor_movie.actor_id HAVING COUNT(*) >=2 );

