/*
INSERT INTO provincias (nombre) VALUES ("Buenos Aires");

INSERT INTO ciudades (nombre, provincias_id) VALUES ("CABA", 1);

-- SELECT * FROM ciudades JOIN provincias ON ciudades.provincias_id = provincias.id;

INSERT INTO planes (velocidad, precio, descuento) VALUES (1000, 40000.0, 0.0);
INSERT INTO planes (velocidad, precio, descuento) VALUES (500, 20000.0, 5000.0);
INSERT INTO planes (velocidad, precio, descuento) VALUES (200, 10000.0, 0.0);
INSERT INTO planes (velocidad, precio, descuento) VALUES (100, 5000.0, 0.0);
INSERT INTO planes (velocidad, precio, descuento) VALUES (50, 2500.0, 0.0);

INSERT INTO clientes (nombre, apellido, dni, fecha_nacimiento, ciudades_id, planes_id) VALUES ("Johanna", "Tabella", "43123456", "2002-06-15", 1, 1);
*/

SELECT 
    *
FROM
    clientes cl
        JOIN
    planes pl ON cl.planes_id = pl.id
        JOIN
    ciudades ci ON ci.id = cl.ciudades_id
        JOIN
    provincias pr ON pr.id = ci.provincias_id;