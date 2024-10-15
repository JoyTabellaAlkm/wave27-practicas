-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema empresa_internet
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema empresa_internet
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `empresa_internet` DEFAULT CHARACTER SET utf8 ;
USE `empresa_internet` ;

-- -----------------------------------------------------
-- Table `empresa_internet`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`clientes` (
  `id_cliente` INT NOT NULL,
  `dni` VARCHAR(20) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `provincia` VARCHAR(45) NOT NULL,
  `ciudad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa_internet`.`planes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`planes` (
  `id_plan` INT NOT NULL,
  `velocidad` VARCHAR(45) NOT NULL,
  `precio` VARCHAR(45) NOT NULL,
  `descuento` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_plan`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa_internet`.`clientes_planes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`clientes_planes` (
  `id_clientes_planes` INT NOT NULL,
  `fecha_contratacion` DATE NOT NULL,
  `id_cliente` INT NOT NULL,
  `id_plan` INT NOT NULL,
  PRIMARY KEY (`id_clientes_planes`),
  INDEX `fk_clientes_planes_clientes_idx` (`id_cliente` ASC) VISIBLE,
  INDEX `fk_clientes_planes_planes1_idx` (`id_plan` ASC) VISIBLE,
  CONSTRAINT `fk_clientes_planes_clientes`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `empresa_internet`.`clientes` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clientes_planes_planes1`
    FOREIGN KEY (`id_plan`)
    REFERENCES `empresa_internet`.`planes` (`id_plan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `empresa_internet`.`clientes`
-- -----------------------------------------------------
START TRANSACTION;
USE `empresa_internet`;
INSERT INTO `empresa_internet`.`clientes` (`id_cliente`, `dni`, `nombre`, `apellido`, `fecha_nacimiento`, `provincia`, `ciudad`) VALUES (001, '1234', 'Santiago', 'Gomez', '1990-04-15', 'Antioquia', 'Medellin');
INSERT INTO `empresa_internet`.`clientes` (`id_cliente`, `dni`, `nombre`, `apellido`, `fecha_nacimiento`, `provincia`, `ciudad`) VALUES (002, '5678', 'Mariana', 'Rodriguez', '1985-10-22', 'Bogotá D.C.', 'Bogotá');
INSERT INTO `empresa_internet`.`clientes` (`id_cliente`, `dni`, `nombre`, `apellido`, `fecha_nacimiento`, `provincia`, `ciudad`) VALUES (003, '9012', 'Juan', 'Perez', '1992-07-05', 'Valle del Cauca', 'Cali');
INSERT INTO `empresa_internet`.`clientes` (`id_cliente`, `dni`, `nombre`, `apellido`, `fecha_nacimiento`, `provincia`, `ciudad`) VALUES (004, '3456', 'Valentina', 'Martinez', '1998-01-30', 'Atlántico', 'Barranquilla');
INSERT INTO `empresa_internet`.`clientes` (`id_cliente`, `dni`, `nombre`, `apellido`, `fecha_nacimiento`, `provincia`, `ciudad`) VALUES (005, '7890', 'Nicolás', 'Lopez', '1983-06-18', 'Santander', 'Bucaramanga');
INSERT INTO `empresa_internet`.`clientes` (`id_cliente`, `dni`, `nombre`, `apellido`, `fecha_nacimiento`, `provincia`, `ciudad`) VALUES (006, '1357', 'Isabela', 'Torres', '1995-11-12', 'Cundinamarca', 'Soacha');
INSERT INTO `empresa_internet`.`clientes` (`id_cliente`, `dni`, `nombre`, `apellido`, `fecha_nacimiento`, `provincia`, `ciudad`) VALUES (007, '9753', 'Mateo', 'Fernandez', '1991-03-08', 'Bolivar', 'Cartagena');
INSERT INTO `empresa_internet`.`clientes` (`id_cliente`, `dni`, `nombre`, `apellido`, `fecha_nacimiento`, `provincia`, `ciudad`) VALUES (008, '2468', 'Laura', 'Diaz', '1994-09-25', 'Huila', 'Neiva');
INSERT INTO `empresa_internet`.`clientes` (`id_cliente`, `dni`, `nombre`, `apellido`, `fecha_nacimiento`, `provincia`, `ciudad`) VALUES (009, '0864', 'Felipe', 'Jiménez', '1980-02-02', 'Quindio', 'Armenia');
INSERT INTO `empresa_internet`.`clientes` (`id_cliente`, `dni`, `nombre`, `apellido`, `fecha_nacimiento`, `provincia`, `ciudad`) VALUES (010, '1580', 'Camila', 'Herrera', '2000-08-27', 'Nariño', 'Pasto');

COMMIT;


-- -----------------------------------------------------
-- Data for table `empresa_internet`.`planes`
-- -----------------------------------------------------
START TRANSACTION;
USE `empresa_internet`;
INSERT INTO `empresa_internet`.`planes` (`id_plan`, `velocidad`, `precio`, `descuento`) VALUES (001, '50', '120000', '10');
INSERT INTO `empresa_internet`.`planes` (`id_plan`, `velocidad`, `precio`, `descuento`) VALUES (002, '100', '200000', '15');
INSERT INTO `empresa_internet`.`planes` (`id_plan`, `velocidad`, `precio`, `descuento`) VALUES (003, '150', '280000', '5');
INSERT INTO `empresa_internet`.`planes` (`id_plan`, `velocidad`, `precio`, `descuento`) VALUES (004, '200', '350000', '20');
INSERT INTO `empresa_internet`.`planes` (`id_plan`, `velocidad`, `precio`, `descuento`) VALUES (005, '300', '450000', '25');

COMMIT;


-- -----------------------------------------------------
-- Data for table `empresa_internet`.`clientes_planes`
-- -----------------------------------------------------
START TRANSACTION;
USE `empresa_internet`;
INSERT INTO `empresa_internet`.`clientes_planes` (`id_clientes_planes`, `fecha_contratacion`, `id_cliente`, `id_plan`) VALUES (001, '2010-05-03', 002, 001);
INSERT INTO `empresa_internet`.`clientes_planes` (`id_clientes_planes`, `fecha_contratacion`, `id_cliente`, `id_plan`) VALUES (002, '2011-06-10', 005, 005);
INSERT INTO `empresa_internet`.`clientes_planes` (`id_clientes_planes`, `fecha_contratacion`, `id_cliente`, `id_plan`) VALUES (003, '2010-12-12', 006, 003);
INSERT INTO `empresa_internet`.`clientes_planes` (`id_clientes_planes`, `fecha_contratacion`, `id_cliente`, `id_plan`) VALUES (004, '2018-09-10', 001, 004);
INSERT INTO `empresa_internet`.`clientes_planes` (`id_clientes_planes`, `fecha_contratacion`, `id_cliente`, `id_plan`) VALUES (005, '2012-10-03', 005, 001);
INSERT INTO `empresa_internet`.`clientes_planes` (`id_clientes_planes`, `fecha_contratacion`, `id_cliente`, `id_plan`) VALUES (006, '2010-05-04', 003, 002);
INSERT INTO `empresa_internet`.`clientes_planes` (`id_clientes_planes`, `fecha_contratacion`, `id_cliente`, `id_plan`) VALUES (007, '2020-01-01', 010, 004);
INSERT INTO `empresa_internet`.`clientes_planes` (`id_clientes_planes`, `fecha_contratacion`, `id_cliente`, `id_plan`) VALUES (008, '2021-03-18', 007, 004);

COMMIT;

