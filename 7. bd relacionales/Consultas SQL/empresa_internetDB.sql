#Crear una nueva base de datos llamada “empresa_internet”.
CREATE DATABASE empresa_internet;

USE empresa_internet;

#Crear tablas
CREATE TABLE Clients (
	id INT PRIMARY KEY AUTO_INCREMENT,
    dni VARCHAR(20),
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    birth_date DATE,
    province VARCHAR(100),
    city VARCHAR(100)
);

CREATE TABLE Plans (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    speed INT NOT NULL,
    price DECIMAL(10,2) NOT NULL
);

CREATE TABLE Contract (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_cliente INT NOT NULL,
    id_plan INT NOT NULL,
    total_price DECIMAL(10,2) NOT NULL,
    discount DECIMAL(3,2) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES Clients(id),
    FOREIGN KEY (id_plan) REFERENCES Plans(id)
);

#Incorporar 10 registros en la tabla de clientes y 5 en la tabla de planes de internet.
insert into Clients (dni, first_name, last_name, birth_date, province, city) values 
('68-212-0506', 'Phil', 'Winser', '2024-02-24', 'Tabasco', 'Kosai-shi'),
('00-152-7712', 'Jerrold', 'Taynton', '2024-09-08', 'Gävleborg', 'Ljusdal'),
('64-926-6526', 'Kamilah', 'Stears', '2024-08-08', 'Tabasco', 'Benito Juarez'),
('66-539-1396', 'Steffie', 'Ipplett', '2023-11-28', 'Kuala Lumpur', 'Banjar Jambe Baleran'),
('53-636-3680', 'Hermon', 'Kleine', '2024-04-01', 'Kuala Lumpur', 'Heshui'),
('67-686-0216', 'Huey', 'Colisbe', '2024-01-09', 'Kuala Lumpur', 'Paipa'),
('10-346-0417', 'Ricki', 'Skeene', '2023-12-04', 'Tabasco', 'Wantian'),
('72-238-4818', 'Zsazsa', 'Bloxsome', '2024-03-11', 'Kuala Lumpur', 'Kuala Lumpur'),
('36-629-6740', 'Ronda', 'Zealander', '2024-09-04', 'Kuala Lumpur', 'Jankomir'),
('45-159-5000', 'Marve', 'Aldred', '2024-05-23', 'Tabasco', 'Chaoyang');

insert into Plans (speed, price) values 
(100, 1000),
(700, 7000),
(200, 2000),
(10000, 10000),
(500, 5000);

INSERT INTO Contract (id_cliente, id_plan, total_price, discount) VALUES
(1, 1, 100.00, 0.10),
(2, 2, 150.00, 0.05),
(3, 3, 200.00, 0.15),
(4, 4, 250.00, 0.20),
(5, 5, 300.00, 0.10),
(6, 1, 120.00, 0.08),
(7, 2, 170.00, 0.12),
(8, 3, 220.00, 0.07),
(9, 4, 270.00, 0.05),
(10, 5, 320.00, 0.10);

#Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias
#1.Listar todos los planes con una velocidad mayor a 100 Mbps:
SELECT * FROM Plans WHERE speed > 100;

#2.Mostrar todos los contratos con un descuento mayor al 10%:
SELECT * FROM Contract WHERE discount > 0.10;

#3.Obtener el total de contratos para un cliente específico:
SELECT COUNT(*) FROM Contract WHERE client_id = 1;

#4.Listar los planes que cuestan más de $200:
SELECT * FROM Plans WHERE price > 200;

#5.Mostrar los contratos con el plan más costoso
SELECT * FROM Contract ORDER BY total_price DESC LIMIT 1;

#6.Calcular el total de ingresos por cliente a través de sus contratos:
SELECT client_id, SUM(total_price) as total_spent
FROM Contract
GROUP BY client_id;

#7. Listar los contratos con un precio total entre $200 y $300:
SELECT * FROM Contratact WHERE total_price BETWEEN 200 AND 300;

#8.Obtener la suma total de ingresos generados por todos los contratos:
SELECT SUM(total_price) as total_income FROM Contract;

#9.Contar cuántos contratos tienen más del 15% de descuento:
SELECT COUNT(*) FROM Contract WHERE discount > 0.15;

#10. Obtener el promedio de descuento aplicado en todos los contratos:
SELECT AVG(discount) AS average_discount FROM Contract;