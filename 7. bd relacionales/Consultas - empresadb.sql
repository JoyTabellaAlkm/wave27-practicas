-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores
SELECT 
	e.nombre, 
    e.puesto, 
    d.localidad
FROM EMPLEADO e
JOIN DEPARTAMENTO d ON e.depto_nro = d.depto_nro
WHERE e.puesto = 'Vendedor';

-- Visualizar los departamentos con más de cinco empleados.
SELECT 
	d.nombre_depto, 
	COUNT(e.cod_emp) AS Total_Empleados
FROM DEPARTAMENTO d
LEFT JOIN EMPLEADO e ON d.depto_nro = e.depto_nro
GROUP BY d.depto_nro
HAVING COUNT(e.cod_emp) > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT 
	e.nombre, 
	e.salario, 
    d.nombre_depto
FROM EMPLEADO e
JOIN DEPARTAMENTO d ON e.depto_nro = d.depto_nro
WHERE e.puesto = (SELECT puesto FROM EMPLEADO WHERE nombre = 'Mito' AND apellido = 'Barchuk');

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.*
FROM EMPLEADO e
JOIN DEPARTAMENTO d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT 
nombre, 
apellido
FROM EMPLEADO
WHERE salario = (SELECT MIN(salario) FROM EMPLEADO);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.

SELECT e.*
FROM EMPLEADO e
JOIN DEPARTAMENTO d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Ventas'
AND e.salario = (SELECT MAX(salario) FROM EMPLEADO WHERE depto_nro = d.depto_nro);

select * from departamento;
