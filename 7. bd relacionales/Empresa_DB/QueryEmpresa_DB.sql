-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan 
-- los vendedores.
SELECT d.nombre_depto, e.puesto, d.localidad
FROM departamento d
JOIN empleado e ON e.depto_nro = d.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.
SELECT d.nombre_depto, COUNT(e.cod_emp) AS 'Cantidad de Empleados'
FROM departamento d
JOIN empleado e ON e.depto_nro = d.depto_nro
GROUP BY d.nombre_depto
HAVING COUNT(e.cod_emp) > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e
JOIN departamento d ON d.depto_nro = e.depto_nro
WHERE puesto = (SELECT puesto
FROM empleado
WHERE nombre = 'Mito'
AND apellido = 'Barchuk' );

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, 
-- ordenados por nombre.
SELECT e.*
FROM empleado e
JOIN departamento d ON d.depto_nro = e.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT e.nombre
FROM empleado e
WHERE e.salario = (SELECT MIN(salario)
					FROM empleado);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.*
FROM empleado e
WHERE e.salario = (SELECT MAX(e2.salario)
                 FROM empleado e2
                 JOIN departamento d ON d.depto_nro = e2.depto_nro
                 WHERE d.nombre_depto = 'Ventas');
