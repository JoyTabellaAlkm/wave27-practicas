-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad FROM empleado AS e 
JOIN departamento AS d ON e.depto_nro = d.depto_nro WHERE e.puesto = 'Vendedor';

-- Visualizar los departamentos con más de cinco empleados.
SELECT d.* FROM departamento AS d JOIN empleado AS e ON d.depto_nro = e.depto_nro 
GROUP BY e.depto_nro HAVING COUNT(*)>5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto FROM empleado AS e 
JOIN departamento AS d ON e.depto_nro = d.depto_nro
WHERE e.puesto = 
(SELECT puesto FROM empleado WHERE nombre = 'Mito' AND apellido = 'Barchuk');

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.* FROM empleado AS e JOIN departamento AS d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad' ORDER BY e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre FROM empleado WHERE salario = (SELECT MIN(salario) FROM empleado);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’
SELECT * FROM empleado 
WHERE (salario, depto_nro) =
	(SELECT MAX(salario), d.depto_nro FROM empleado AS e 
	JOIN departamento AS d ON e.depto_nro = d.depto_nro
	WHERE d.nombre_depto = 'Ventas' GROUP BY d.depto_nro);
