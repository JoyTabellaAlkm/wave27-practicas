USE movies_db;

CREATE TEMPORARY TABLE TWD (id INT, created_at timestamp, updated_at timestamp,
title varchar(500), number INT, release_date datetime, rating decimal(3,1),
season_id INT);

INSERT INTO TWD SELECT ep.*
FROM episodes ep
JOIN seasons sea ON sea.id = ep.season_id
JOIN series s ON s.id = sea.serie_id
WHERE s.title = 'The Walking Dead';

SELECT title
FROM TWD
