-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 19, 2019 at 09:41 AM
-- Server version: 10.1.40-MariaDB
-- PHP Version: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kavine`
--

-- --------------------------------------------------------

--
-- Table structure for table `uzsakymai`
--

CREATE TABLE `uzsakymai` (
  `id` int(10) UNSIGNED NOT NULL,
  `pav` varchar(256) COLLATE utf8_lithuanian_ci NOT NULL,
  `trukme_ruosimo` int(11) DEFAULT NULL,
  `trukme_kaitinimo` int(11) DEFAULT NULL,
  `busena` enum('uzsakytas','anuliuotas','ivykdytas') COLLATE utf8_lithuanian_ci NOT NULL DEFAULT 'uzsakytas'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

--
-- Dumping data for table `uzsakymai`
--

INSERT INTO `uzsakymai` (`id`, `pav`, `trukme_ruosimo`, `trukme_kaitinimo`, `busena`) VALUES
(1, 'Ledai', 0, 0, 'uzsakytas'),
(2, 'Kava Juoda', 0, 0, 'uzsakytas'),
(4, 'Cezario salotos', 15, 0, 'uzsakytas'),
(6, 'Obuoliu pyragas su braskemis', 0, 0, 'anuliuotas'),
(7, 'Kava Late', 0, 0, 'anuliuotas'),
(8, 'Humus Pica', 15, 8, 'uzsakytas'),
(9, 'Saltibarsciai su bulvemis', 15, 5, 'uzsakytas'),
(10, 'Bulviniai blynai', 10, 15, 'anuliuotas'),
(11, 'Vaisin? arbata', 0, 0, 'uzsakytas'),
(12, 'Blyneliai su bananais', 15, 10, 'uzsakytas'),
(13, 'Varšk??iai', 20, 10, 'anuliuotas');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `uzsakymai`
--
ALTER TABLE `uzsakymai`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `uzsakymai`
--
ALTER TABLE `uzsakymai`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
