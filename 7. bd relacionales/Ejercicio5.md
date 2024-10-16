### Ejercicio 1: Crear una Tabla Temporal y Consultar

1. **Crear la tabla temporal llamada `TWD` y guardar los episodios de todas las temporadas de “The Walking Dead”.**

   Supongamos que tienes una tabla llamada `episodios` que contiene la información de los episodios, incluyendo el título, la temporada y el nombre de la serie. Aquí está el SQL para crear la tabla temporal y cargar los episodios de “The Walking Dead”:

   ```sql
   -- Crear la tabla temporal TWD
   CREATE TEMPORARY TABLE TWD AS
   SELECT *
   FROM episodios
   WHERE serie = 'The Walking Dead';
   ```

2. **Consultar los episodios de la primera temporada.**

   Ahora puedes realizar una consulta a la tabla temporal para ver los episodios de la primera temporada:

   ```sql
   SELECT *
   FROM TWD
   WHERE temporada = 1;
   ```

### Ejercicio 2: Crear un Índice

1. **Seleccionar una tabla donde crear un índice.**

   Supongamos que tienes una tabla llamada `peliculas`. Aquí hay un ejemplo de cómo crear un índice en el campo `titulo`, que a menudo se consulta para buscar películas:

   ```sql
   -- Crear un índice en el campo titulo de la tabla peliculas
   CREATE INDEX idx_titulo ON peliculas(titulo);
   ```

2. **Chequear la creación del índice.**

   Puedes verificar que el índice se ha creado correctamente con la siguiente consulta (la sintaxis puede variar ligeramente dependiendo de tu sistema de gestión de bases de datos):

   ```sql
   SHOW INDEX FROM peliculas;
   ```

### Análisis de la Creación del Índice

**Razones para crear un índice:**
- **Mejora del rendimiento:** Los índices permiten acceder a los datos de manera más rápida y eficiente, especialmente en columnas que se utilizan frecuentemente en cláusulas `WHERE`, `JOIN` o `ORDER BY`.
- **Optimización de búsquedas:** Si la columna `titulo` se utiliza a menudo para buscar películas, un índice en esta columna puede reducir el tiempo de búsqueda.

**Criterios para elegir los campos:**
- **Frecuencia de consultas:** Elegir columnas que se usan comúnmente en las consultas.
- **Cardinalidad:** Preferiblemente, seleccionar campos con alta cardinalidad (es decir, con muchos valores distintos) para maximizar la efectividad del índice.
- **Impacto en inserciones y actualizaciones:** Ten en cuenta que los índices pueden ralentizar las operaciones de inserción, actualización y eliminación, ya que deben mantenerse actualizados.

Si tienes más preguntas o necesitas más detalles, ¡no dudes en preguntar!