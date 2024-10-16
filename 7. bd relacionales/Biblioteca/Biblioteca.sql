-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema biblioteca
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema biblioteca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `biblioteca` DEFAULT CHARACTER SET utf8 ;
USE `biblioteca` ;

-- -----------------------------------------------------
-- Table `biblioteca`.`libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`libro` (
  `id_libro` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `editorial` VARCHAR(45) NOT NULL,
  `area` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_libro`),
  UNIQUE INDEX `id_libro_UNIQUE` (`id_libro` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`estudiante` (
  `id_lector` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `carrera` VARCHAR(45) NOT NULL,
  `edad` SMALLINT(3) NOT NULL,
  PRIMARY KEY (`id_lector`),
  UNIQUE INDEX `idlector_UNIQUE` (`id_lector` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`prestamo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`prestamo` (
  `id_libro` INT NOT NULL,
  `id_lector` INT NOT NULL,
  `fecha_prestamo` DATETIME NOT NULL,
  `fecha_devolucion` DATETIME NOT NULL,
  `devuelto` TINYINT NOT NULL,
  PRIMARY KEY (`id_libro`, `id_lector`),
  INDEX `fk_prestamo_estudiante1_idx` (`id_lector` ASC) VISIBLE,
  CONSTRAINT `fk_prestamo_libro1`
    FOREIGN KEY (`id_libro`)
    REFERENCES `biblioteca`.`libro` (`id_libro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prestamo_estudiante1`
    FOREIGN KEY (`id_lector`)
    REFERENCES `biblioteca`.`estudiante` (`id_lector`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`autor` (
  `id_autor` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `nacionalidad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_autor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`libro_autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`libro_autor` (
  `id_libro` INT NOT NULL,
  `id_autor` INT NOT NULL,
  PRIMARY KEY (`id_libro`, `id_autor`),
  INDEX `fk_libro_has_autor_autor1_idx` (`id_autor` ASC) VISIBLE,
  INDEX `fk_libro_has_autor_libro_idx` (`id_libro` ASC) VISIBLE,
  CONSTRAINT `fk_libro_has_autor_libro`
    FOREIGN KEY (`id_libro`)
    REFERENCES `biblioteca`.`libro` (`id_libro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_libro_has_autor_autor1`
    FOREIGN KEY (`id_autor`)
    REFERENCES `biblioteca`.`autor` (`id_autor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `biblioteca`.`libro`
-- -----------------------------------------------------
START TRANSACTION;
USE `biblioteca`;
INSERT INTO `biblioteca`.`libro` (`id_libro`, `titulo`, `editorial`, `area`) VALUES (1, 'El universo: Guía de viaje', 'Salamandra', 'Base de datos');
INSERT INTO `biblioteca`.`libro` (`id_libro`, `titulo`, `editorial`, `area`) VALUES (2, 'Aprendiendo Java I', 'Salamandra', 'Internet');

COMMIT;


-- -----------------------------------------------------
-- Data for table `biblioteca`.`estudiante`
-- -----------------------------------------------------
START TRANSACTION;
USE `biblioteca`;
INSERT INTO `biblioteca`.`estudiante` (`id_lector`, `nombre`, `apellido`, `direccion`, `carrera`, `edad`) VALUES (1, 'Vanessa', 'Lozano', '1234', 'Informatica', 22);
INSERT INTO `biblioteca`.`estudiante` (`id_lector`, `nombre`, `apellido`, `direccion`, `carrera`, `edad`) VALUES (2, 'Ana', 'Garcia', '5678', 'Informatica', 24);
INSERT INTO `biblioteca`.`estudiante` (`id_lector`, `nombre`, `apellido`, `direccion`, `carrera`, `edad`) VALUES (3, 'Leandro', 'Ramirez', '1456', 'Diseño', 15);
INSERT INTO `biblioteca`.`estudiante` (`id_lector`, `nombre`, `apellido`, `direccion`, `carrera`, `edad`) VALUES (4, 'Filippo', 'Galli', '7834', 'Arquitectura', 30);

COMMIT;


-- -----------------------------------------------------
-- Data for table `biblioteca`.`prestamo`
-- -----------------------------------------------------
START TRANSACTION;
USE `biblioteca`;
INSERT INTO `biblioteca`.`prestamo` (`id_libro`, `id_lector`, `fecha_prestamo`, `fecha_devolucion`, `devuelto`) VALUES (1, 2, '2021-01-16', '2021-07-16', 1);
INSERT INTO `biblioteca`.`prestamo` (`id_libro`, `id_lector`, `fecha_prestamo`, `fecha_devolucion`, `devuelto`) VALUES (1, 3, '2024-01-07', '2024-10-30', 0);
INSERT INTO `biblioteca`.`prestamo` (`id_libro`, `id_lector`, `fecha_prestamo`, `fecha_devolucion`, `devuelto`) VALUES (2, 4, '2024-07-18', '2025-01-25', 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `biblioteca`.`autor`
-- -----------------------------------------------------
START TRANSACTION;
USE `biblioteca`;
INSERT INTO `biblioteca`.`autor` (`id_autor`, `nombre`, `nacionalidad`) VALUES (1, 'J.K Rowling', 'Francesa');
INSERT INTO `biblioteca`.`autor` (`id_autor`, `nombre`, `nacionalidad`) VALUES (2, 'Jorge Martin', 'Italiana');
INSERT INTO `biblioteca`.`autor` (`id_autor`, `nombre`, `nacionalidad`) VALUES (3, 'Sebastian', 'Colombiana');

COMMIT;


-- -----------------------------------------------------
-- Data for table `biblioteca`.`libro_autor`
-- -----------------------------------------------------
START TRANSACTION;
USE `biblioteca`;
INSERT INTO `biblioteca`.`libro_autor` (`id_libro`, `id_autor`) VALUES (1, 1);
INSERT INTO `biblioteca`.`libro_autor` (`id_libro`, `id_autor`) VALUES (1, 2);
INSERT INTO `biblioteca`.`libro_autor` (`id_libro`, `id_autor`) VALUES (2, 2);
INSERT INTO `biblioteca`.`libro_autor` (`id_libro`, `id_autor`) VALUES (2, 3);

COMMIT;

