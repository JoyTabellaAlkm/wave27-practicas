select * from movies;
select first_name, last_name, rating from actors;
select title as titulo from series;
select first_name, last_name from actors where rating > 7.5;
select title, rating, awards from movies where awards > 2 and rating >7.5;
select title, rating from movies order by rating asc;
select title from movies limit 3;
select title, rating from movies order by rating desc limit 5;
select * from actors limit 10;
select title, rating from movies where title = 'Toy Story';
select first_name, last_name, rating from actors where first_name like 'Sam%';
select title, release_date from movies where release_date between '2004-01-01' and '2008-12-31';
select title, release_date, rating from movies where rating > 3 and awards > 1 and
 release_date between '1998-01-01' and '2009-12-31' order by rating;