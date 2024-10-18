-- Mostrar todos los registros de la tabla de movies.
SELECT * FROM movies_db.movies;

-- Mostrar el nombre, apellido y rating de todos los actores.
SELECT first_name as Nombre, last_name as Apellido, rating as Rating FROM actors;

-- Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
Select title as 'Título' from series as Series;

-- Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
Select first_name as Nombre, last_name as Apellido from actors as ac where ac.rating >7.5;

-- Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
Select title, rating, awards from movies as mo where mo.rating > 7.5 and mo.awards>2;

-- Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
select title, rating from movies order by rating ASC;

-- Mostrar los títulos de las primeras tres películas en la base de datos.
select title from movies limit 3;

-- Mostrar el top 5 de las películas con mayor rating.
select title, rating from movies as mo order by mo.rating DESC limit 5;

-- Listar los primeros 10 actores.
SELECT first_name, last_name from actors limit 10;

-- Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
select title as "Título", rating as 'Rating' from movies as mo where mo.title like '%Toy Story%';

-- Mostrar a todos los actores cuyos nombres empiezan con Sam.
select first_name as "NOMBRE", last_name as "APELLIDO" from actors ac where ac.first_name LIKE '%Sam%';

-- Mostrar el título de las películas que salieron entre el 2004 y 2008.
select title as "Título" from movies as mo where mo.release_date >= "2004-01-01" and mo.release_date <= "2024-12-31";

-- Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
select title as 'Título' from movies as mo where mo.rating >3 and mo.awards>1 and mo.release_date >= "1088-01-01" and mo.release_date <= "2009-12-31";
