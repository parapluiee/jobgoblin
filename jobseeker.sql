-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2023 at 04:18 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jobgoblin`
--

-- --------------------------------------------------------

--
-- Table structure for table `jobseeker`
--

CREATE TABLE `jobseeker` (
  `jobseeker_id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `dob` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `prev_salary` double NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `jobseeker`
--

INSERT INTO `jobseeker` (`jobseeker_id`, `description`, `dob`, `email`, `name`, `prev_salary`, `username`, `password`) VALUES
(1, 'I am a professional mc player. Currently looking for a team to play for. Also adept at networking.', '08/23/99', 'mc789@gmail.com', 'Mac', 5000.02, 'mc734', 'make a wish.com'),
(9, 'Former Data Analyst at NASA. Looking for a big check.', '09/12/67', 'zman69@gmail.com', 'Thomas', 1450000.99, 'zman69', 'zman12345'),
(12, 'Former Data Analyst at My Garage.Com. Looking for a big check.', '09/12/69', 'hkwjoeo@gmail.com', 'Thomas', 2.25, 'hkwjoeo', 'jsjwoie39'),
(13, 'Looking to get paid better. Peep my Resume', '04/05/81', 'yooooo000@gmail.com', 'Yooyoo', 89756.78, 'yooo78', '12345678'),
(14, 'Broke College Grad. Looking for spare change', '04/06/94', 'johntm@gmail.com', 'John', 0.02, 'johnTheMan', '578908'),
(15, 'Sad job seeker.', '08/25/2000', 'JobSeekerEmail', 'Example JobSeeker', 100000.25, 'JobSeekerUserName', 'JobSeekerPassword');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jobseeker`
--
ALTER TABLE `jobseeker`
  ADD PRIMARY KEY (`jobseeker_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jobseeker`
--
ALTER TABLE `jobseeker`
  MODIFY `jobseeker_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
