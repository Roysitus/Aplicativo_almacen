-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-02-2023 a las 06:37:26
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_almacen`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `admin` varchar(100) NOT NULL,
  `contraseña` varchar(100) NOT NULL,
  `peticiones` int(11) NOT NULL,
  `habilitado` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `edad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`admin`, `contraseña`, `peticiones`, `habilitado`, `nombre`, `apellido`, `edad`) VALUES
('ADMIN-0', '123456', 5, 'True', 'UTP', 'Utpino', 25);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingreso`
--

CREATE TABLE `ingreso` (
  `codigo` varchar(100) NOT NULL,
  `fecha` varchar(100) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ingreso`
--

INSERT INTO `ingreso` (`codigo`, `fecha`, `cantidad`) VALUES
('COD-0', '16/07/2022', 50),
('COD-0', '16/07/2022', 23);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `codigo` varchar(100) NOT NULL,
  `nombrepro` varchar(100) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`codigo`, `nombrepro`, `cantidad`, `precio`) VALUES
('COD-0', 'Jean ', 250, 65);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `retiro`
--

CREATE TABLE `retiro` (
  `codigo` varchar(100) NOT NULL,
  `fecha` varchar(100) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `retiro`
--

INSERT INTO `retiro` (`codigo`, `fecha`, `cantidad`) VALUES
('COD-0', '16/07/2022', 50);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `user` varchar(100) NOT NULL,
  `contraseña` varchar(100) NOT NULL,
  `peticiones` int(11) NOT NULL,
  `habilitado` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `edad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`user`, `contraseña`, `peticiones`, `habilitado`, `nombre`, `apellido`, `edad`) VALUES
('USER-0', 'bask3t*16', 3, 'True', 'Linux', 'Parrot', 19),
('USER-1', '123456', 1, 'True', 'Keny', 'Delgado', 19),
('USER-2', '123456', 2, 'True', 'Utp', 'Centro', 19);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `codigoVenta` varchar(50) NOT NULL,
  `codigoProducto` varchar(50) NOT NULL,
  `cantidadVenta` int(11) NOT NULL,
  `precioProducto` double NOT NULL,
  `nombreApellido` varchar(100) NOT NULL,
  `dni` varchar(50) NOT NULL,
  `celular` varchar(50) NOT NULL,
  `direccion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`codigoVenta`, `codigoProducto`, `cantidadVenta`, `precioProducto`, `nombreApellido`, `dni`, `celular`, `direccion`) VALUES
('VENT-0', 'COD-0', 5, 1.5, 'Miguel Hernandez', '76511896', '971045623', 'Lima Metropolitana 1588');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`admin`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`user`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`codigoVenta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
