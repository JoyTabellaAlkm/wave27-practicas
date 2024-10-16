
use movies_db;
#Ejercicio 1
select * from movies;

#Ejercicio 2
SELECT first_name, last_name, rating from actors;

#Ejercicio 3
SELECT title AS Titulo from series;

#Ejercicio 4
SELECT first_name, last_name from actors 
WHERE rating > 7.5;

#Ejercicio 5
SELECT title, rating, awards FROM movies 
WHERE rating > 7.5 AND awards > 2;

#Ejercicio 6 
SELECT title, rating FROM movies 
ORDER BY rating;

#Ejercicio 7
SELECT title FROM movies
LIMIT 3;

#Ejercicio 8
SELECT title, rating, awards from movies
ORDER BY rating DESC
LIMIT 5;

#Ejercicio 9
SELECT * FROM actors
LIMIT 10;

#Ejercicio 10
SELECT title, rating FROM movies
WHERE title = "Toy Story";

#Ejercicio 11
SELECT first_name, last_name from actors
WHERE first_name = "Sam";

#Ejercicio 12
SELECT title, release_date FROM movies
WHERE release_date BETWEEN "2004-01-01" AND "2008-12-31"; 

#Ejercicio 13
SELECT title FROM movies
WHERE rating > 3 AND awards > 1 AND release_date BETWEEN "1988-01-01" AND "2009-12-31"; 

 