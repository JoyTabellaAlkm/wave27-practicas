select * from movies_db.movies;
select first_name, last_name, rating from movies_db.actors;
select title as titulo from movies_db.series;
select first_name, last_name from movies_db.actors where rating > 7.5;
select title, rating, awards from movies_db.movies where awards > 2 and rating >7.5;
select title, rating from movies_db.movies order by rating asc;
select title from movies_db.movies limit 3;
select title, rating from movies_db.movies order by rating desc limit 5;
select first_name, last_name from movies_db.actors limit 10;
select title, rating from movies_db.movies where title = 'Toy Story';
select first_name, last_name from movies_db.actors where first_name like 'Sam%';
select title from movies_db.movies where release_date between '2004-01-01' and '2008-12-31';
select title from movies_db.movies where rating > 3 and awards > 1 and
 release_date between '1998-01-01' and '2009-12-31' order by rating;