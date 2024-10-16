### Consigna 1: Agregar una película a la tabla `movies`

```sql
INSERT INTO movies (title, release_year, awards, genre_id) 
VALUES ('Nueva Película', 2023, 0, NULL);
```

### Consigna 2: Agregar un género a la tabla `genres`

```sql
INSERT INTO genres (name) 
VALUES ('Nuevo Género');
```

### Consigna 3: Asociar la película del punto 1 al género creado en el punto 2

Primero, debes obtener el `id` del género recién creado:

```sql
-- Supongamos que el nuevo género tiene id 5 (ajusta según corresponda)
UPDATE movies 
SET genre_id = 5 
WHERE title = 'Nueva Película';
```

### Consigna 4: Modificar la tabla `actors` para que al menos un actor tenga como favorita la película agregada en el punto 1

Primero, necesitas obtener el `id` de la película recién creada:

```sql
-- Supongamos que el nuevo id de la película es 10 (ajusta según corresponda)
UPDATE actors 
SET favorite_movie_id = 10 
WHERE id = 1;  -- Cambia el ID del actor según corresponda
```

### Consigna 5: Crear una tabla temporal copia de la tabla `movies`

```sql
CREATE TEMPORARY TABLE temp_movies AS 
SELECT * FROM movies;
```

### Consigna 6: Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards

```sql
DELETE FROM temp_movies 
WHERE awards < 5;
```

### Consigna 7: Obtener la lista de todos los géneros que tengan al menos una película

```sql
SELECT g.name 
FROM genres g 
JOIN movies m ON g.id = m.genre_id 
GROUP BY g.id;
```

### Consigna 8: Obtener la lista de actores cuya película favorita haya ganado más de 3 awards

```sql
SELECT a.* 
FROM actors a 
JOIN movies m ON a.favorite_movie_id = m.id 
WHERE m.awards > 3;
```

### Consigna 9: Crear un índice sobre el nombre en la tabla `movies`

```sql
CREATE INDEX idx_movie_title ON movies(title);
```

### Consigna 10: Chequear que el índice fue creado correctamente

```sql
SHOW INDEX FROM movies;
```

### Análisis sobre la mejora al crear índices

**¿Existiría una mejora notable al crear índices?**
- **Sí, existen mejoras significativas al crear índices**. Los índices mejoran la velocidad de las consultas, especialmente en tablas grandes, ya que permiten a la base de datos localizar los registros más rápidamente sin necesidad de realizar un escaneo completo de la tabla. Esto es crucial para consultas que implican búsquedas, filtrados o uniones.

**¿En qué otra tabla crearía un índice y por qué?**
- **Recomendaría crear un índice en la tabla `actors`, específicamente en el campo `favorite_movie_id`**. Este campo se usa para asociar actores con sus películas favoritas, y al crear un índice aquí, se aceleraría el proceso de búsqueda de actores basados en su película favorita. Dado que esta es una relación frecuente en las consultas, el índice puede mejorar el rendimiento general de las búsquedas relacionadas con los actores y sus películas favoritas.

Si necesitas más información o tienes preguntas adicionales, ¡estaré encantado de ayudar!