### Consultas SQL

1. **Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.**
   ```sql
   SELECT e.nombre, e.puesto, d.localidad
   FROM EMPLEADO e
   JOIN DEPARTAMENTO d ON e.depto_nro = d.depto_nro
   WHERE e.puesto = 'Vendedor';
   ```

2. **Visualizar los departamentos con más de cinco empleados.**
   ```sql
   SELECT d.nombre_depto, COUNT(e.cod_emp) AS cantidad_empleados
   FROM DEPARTAMENTO d
   LEFT JOIN EMPLEADO e ON d.depto_nro = e.depto_nro
   GROUP BY d.depto_nro
   HAVING COUNT(e.cod_emp) > 5;
   ```

3. **Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.**
   ```sql
   SELECT e.nombre, e.salario, d.nombre_depto
   FROM EMPLEADO e
   JOIN DEPARTAMENTO d ON e.depto_nro = d.depto_nro
   WHERE e.puesto = (SELECT puesto FROM EMPLEADO WHERE nombre = 'Mito' AND apellido = 'Barchuk');
   ```

4. **Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.**
   ```sql
   SELECT e.*
   FROM EMPLEADO e
   JOIN DEPARTAMENTO d ON e.depto_nro = d.depto_nro
   WHERE d.nombre_depto = 'Contabilidad'
   ORDER BY e.nombre;
   ```

5. **Mostrar el nombre del empleado que tiene el salario más bajo.**
   ```sql
   SELECT e.nombre
   FROM EMPLEADO e
   ORDER BY e.salario ASC
   LIMIT 1;
   ```

6. **Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.**
   ```sql
   SELECT e.*
   FROM EMPLEADO e
   JOIN DEPARTAMENTO d ON e.depto_nro = d.depto_nro
   WHERE d.nombre_depto = 'Ventas'
   ORDER BY e.salario DESC
   LIMIT 1;
   ```

### Descripción de las Consultas

1. **Primera Consulta**: Une las tablas `EMPLEADO` y `DEPARTAMENTO` para obtener la información de los vendedores, filtrando por el puesto "Vendedor".

2. **Segunda Consulta**: Usa una unión externa (`LEFT JOIN`) para contar cuántos empleados hay en cada departamento. Luego agrupa los resultados por departamento y filtra aquellos con más de cinco empleados.

3. **Tercera Consulta**: Selecciona empleados cuyo puesto coincida con el de "Mito Barchuk" usando una subconsulta. Une con la tabla de departamentos para obtener el nombre del departamento.

4. **Cuarta Consulta**: Filtra los empleados que pertenecen al departamento de "Contabilidad" y los ordena alfabéticamente por nombre.

5. **Quinta Consulta**: Ordena todos los empleados por salario en orden ascendente y limita el resultado a uno, obteniendo así al empleado con el salario más bajo.

6. **Sexta Consulta**: Filtra a los empleados que están en el departamento de "Ventas" y ordena por salario en orden descendente, limitando el resultado a uno para obtener al que tiene el salario más alto.

Estas consultas te permitirán extraer la información requerida de manera efectiva y eficiente.