
use empleado_db;

SELECT * FROM Empleado;


#Ejercicio 1
SELECT e.nombre, e.puesto, d.localidad FROM Empleado e
JOIN Departamento d
ON e.depto_nro = d.depto_nro;

#Ejercicio 2
SELECT depto_nro AS Departamento, COUNT(*) FROM Empleado
GROUP BY depto_nro 
HAVING COUNT(*) > 2;

#Ejercicio 3
SELECT e.nombre, e.salario, d.nombre_depto FROM Empleado e
JOIN Departamento d ON e.depto_nro = d.depto_nro
WHERE puesto = (SELECT puesto FROM Empleado 
WHERE nombre = "Mito" AND apellido = "Barchuk");

#Ejercicio 4
SELECT * from Empleado 
WHERE depto_nro = (
SELECT depto_nro FROM Departamento 
WHERE nombre_depto = "Contabilidad");

#Ejercicio 5
SELECT nombre FROM Empleado 
WHERE salario = (
SELECT MIN(Salario) FROM Empleado);

#Ejercicio 6
SELECT nombre, apellido FROM Empleado 
WHERE salario = (
SELECT MAX(salario) FROM Empleado 
WHERE cod_emp IN (
SELECT e.cod_emp from Empleado e
JOIN Departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = "Ventas"));