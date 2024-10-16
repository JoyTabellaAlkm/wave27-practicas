USE movies_db;
--Mostrar el título y el nombre del género de todas las series.
SELECT series.title, genres.name FROM series INNER JOIN genres ON series.genre_id = genres.id;

--Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT episodes.title, actors.first_name, actors.last_name FROM episodes JOIN actors;

--Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title, COUNT(seasons.id) AS TotalTemporadas FROM series LEFT JOIN seasons ON series.id = seasons.serie_id
GROUP BY series.id, series.title;

--Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select genres.name, COUNT(movies.genre_id) as TotalPeliculas from genres left join movies on genres.id = movies.genre_id
GROUP BY genres.id, genres.name HAVING TotalPeliculas > 3;

--Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT a.first_name, a.last_name
FROM actors a
INNER JOIN actor_movie am ON a.id = am.actor_id
INNER JOIN movies m ON am.movie_id = m.id
WHERE m.title LIKE '%La Guerra de las Galaxias%'
GROUP BY a.id
HAVING COUNT(DISTINCT m.id) = (SELECT COUNT(*) FROM movies WHERE title LIKE '%La Guerra de las Galaxias%');

