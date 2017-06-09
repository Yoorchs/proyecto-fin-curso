-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-06-2017 a las 14:35:59
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `proyecto_fin_curso`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `cursoCreate`(IN `pcodCurso` VARCHAR(25) CHARSET utf8, IN `pnomCurso` VARCHAR(25) CHARSET utf8, OUT `pcodigo` INT)
    NO SQL
BEGIN
	INSERT INTO `cursos` ( 
        `codCurso`, 
        `nomcurso`) 
        VALUES (
        LOWER(pcodCurso),
        LOWER(pnomCurso));
        SET pcodigo = LAST_INSERT_ID();
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `cursoDelete`(IN `pcodcurso` INT)
    NO SQL
BEGIN

DELETE FROM cursos WHERE codigo = pcodcurso;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `cursoGetAll`()
    NO SQL
BEGIN
	SELECT 
    `codigo`,
    `codCurso`,
    `nomcurso`
    FROM `cursos`;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `cursoGetById`(IN `pcodCurso` INT)
    NO SQL
BEGIN
	SELECT 
    `codigo`,
    `codCurso`,
    `nomcurso`
    FROM `cursos`
	WHERE `pcodCurso` = `codigo`;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `cursoUpdate`(IN `pcodCurso` VARCHAR(25), IN `pnomCurso` VARCHAR(25), IN `pcodigo` INT)
    NO SQL
BEGIN
	UPDATE cursos 
	SET `codCurso` = LOWER(pcodCurso), 
    	`nomcurso` = LOWER(pnomCurso) 
 	WHERE codigo = pcodigo;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE IF NOT EXISTS `cursos` (
  `codigo` int(9) NOT NULL AUTO_INCREMENT COMMENT 'Identificador unico de la tabla',
  `codCurso` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `nomcurso` varchar(150) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Descripcion de curso',
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`codigo`, `codCurso`, `nomcurso`) VALUES
(7, '2', 'mono');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
