-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema empresa_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema empresa_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `empresa_db` DEFAULT CHARACTER SET utf8 ;
USE `empresa_db` ;

-- -----------------------------------------------------
-- Table `empresa_db`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_db`.`departamento` (
  `depto_nro` VARCHAR(7) NOT NULL,
  `nombre_depto` VARCHAR(45) NOT NULL,
  `localidad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`depto_nro`),
  UNIQUE INDEX `depto_nro_UNIQUE` (`depto_nro` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa_db`.`empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_db`.`empleado` (
  `cod_emp` VARCHAR(6) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `puesto` VARCHAR(45) NOT NULL,
  `fecha_alta` DATE NOT NULL,
  `salario` INT NOT NULL,
  `comision` INT NOT NULL,
  `depto_nro` VARCHAR(7) NOT NULL,
  PRIMARY KEY (`cod_emp`),
  UNIQUE INDEX `cod_emp_UNIQUE` (`cod_emp` ASC) VISIBLE,
  INDEX `fk_empleado_departamento_idx` (`depto_nro` ASC) VISIBLE,
  CONSTRAINT `fk_empleado_departamento`
    FOREIGN KEY (`depto_nro`)
    REFERENCES `empresa_db`.`departamento` (`depto_nro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO departamento (depto_nro, nombre_depto, localidad) VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1'); 


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
