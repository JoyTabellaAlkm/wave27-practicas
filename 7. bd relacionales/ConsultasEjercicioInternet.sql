
-- Seleccionar todos los clientes
SELECT * FROM customers;

-- Seleccionar todos los planes disponibles
SELECT * FROM plans;

-- Buscar un cliente por su ID
SELECT * FROM customers WHERE customer_id = 1;

-- Listar todos los clientes y su plan asociado
SELECT 
    c.first_name,
    c.last_name, 
    p.speed, 
    p.price
FROM customers c
JOIN contract ct ON c.customer_id = ct.customer_id
JOIN plans p ON ct.plan_id = p.plan_id;

-- Buscar todos los clientes en una provincia específica
SELECT * FROM customers WHERE province = 'Córdoba';

-- Contar cuántos clientes hay en cada provincia
SELECT 
    province, 
    COUNT(*) AS num_clients 
FROM customers 
GROUP BY province;

-- Listar todos los planes y sus precios
SELECT 
    p.plan_id, 
    p.speed, 
    p.price 
FROM plans p;

-- Buscar todos los planes con un descuento mayor a un cierto porcentaje
SELECT * FROM plans WHERE discount > 5.00;

-- Listar los clientes que tienen un plan con una velocidad superior a 50 Mbps
SELECT 
    c.first_name, 
    c.last_name,
    p.speed 
FROM customers c
JOIN contract ct ON c.customer_id = ct.customer_id
JOIN plans p ON ct.plan_id = p.plan_id
WHERE p.speed > 50;

-- Obtener el precio promedio de todos los planes disponibles
SELECT AVG(price) AS average_price FROM plans;

-- Listar los planes que tienen una velocidad de al menos 100 Mbps
SELECT 
    p.plan_id, 
    p.speed 
FROM plans p
WHERE p.speed >= 100;

-- Obtener la cantidad de planes (no hay tipos de planes en este caso)
SELECT 
    COUNT(*) AS num_plans 
FROM plans;

-- Listar los clientes junto con su descuento en el plan
SELECT 
    c.first_name, 
    c.last_name, 
    p.discount 
FROM customers c
JOIN contract ct ON c.customer_id = ct.customer_id
JOIN plans p ON ct.plan_id = p.plan_id;