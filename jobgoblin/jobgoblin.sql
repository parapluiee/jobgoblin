-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 18, 2023 at 02:22 PM
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
-- Table structure for table `comlogin`
--

CREATE TABLE `comlogin` (
  `comid` bigint(20) NOT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `comlogin`
--

INSERT INTO `comlogin` (`comid`, `pass`, `user`) VALUES
(17, 'jobby', 'gobby');

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `id` bigint(20) NOT NULL,
  `descr` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `founding_date` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `num_ratings` int(11) NOT NULL,
  `rating` double NOT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `web_link` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`id`, `descr`, `email`, `founding_date`, `name`, `num_ratings`, `rating`, `start_date`, `web_link`) VALUES
(17, 'Professional Networking Startup in Greensboro', 'jobbygobby@gmail.com', '03/21/2002', 'Jobgoblin', 0, 5, '01/01/2023', 'jobgoblin.com'),
(18, 'Educational Institution', 'uncg@uncg.edu', '01/01/1900', 'UNCG', 1000, 4, '03/23/2023', 'uncg.edu');

INSERT INTO `company` (`id`, `descr`, `email`, `founding_date`, `name`, `num_ratings`, `rating`, `start_date`, `web_link`) VALUES
(1, 'company descriptiopn', 'company.com', '1/1/1', 'super boring', 45, 5.5, '1/1/1', 'boringco.com'),
(19, 'We clean lawns!', 'lawning@email.com', '3/2/2003', 'Lawning Company', 2, 4, '5/1/2023', 'lawning.com');

-- --------------------------------------------------------

--
-- Table structure for table `job`
--

CREATE TABLE `job` (
  `id` bigint(20) NOT NULL,
  `companyid` bigint(20) NOT NULL,
  `date_posted` varchar(255) DEFAULT NULL,
  `descr` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `salary_high` int(11) NOT NULL,
  `salary_low` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `job`
--

INSERT INTO `job` (`id`, `companyid`, `date_posted`, `descr`, `name`, `salary_high`, `salary_low`) VALUES
(12, 17, '04/18/2023', 'High-level management of the company.', 'CEO', 20, 20);

INSERT INTO `job` (`id`, `companyid`, `date_posted`, `descr`, `name`, `num_ratings`, `quizid`, `rating`, `recruiterid`, `salary_high`, `salary_low`) VALUES
(22, 1, '3/2/21', 'a boring job', 'job', 3, 0, 5, 30, 2000, 1000),
(28, 1, '3/2/1', 'its a boring hjob', 'boring job', 34, 10.02, 5, 30, 324324, 434345),
(29, 0, NULL, NULL, NULL, 0, 0, 0, 0, 0, 0),
(31, 2, '4/4/200', 'super description', 'non company 1 job', 12, 12, 2, 28, 10000, 2000);

-- --------------------------------------------------------

--
-- Table structure for table `jobseeker`
--

CREATE TABLE `jobseeker` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `prevsalary` double NOT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `recruiter`
--

CREATE TABLE `recruiter` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rating` double NOT NULL,
  `start_date` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `recruiter`
--

INSERT INTO `recruiter` (`id`, `description`, `email`, `name`, `rating`, `start_date`) VALUES
(4, 'Partial owner of jobgoblin', 'eistafford@uncg.edu', 'Eli Stafford', 5, '03/21/2002');

INSERT INTO `recruiter` (`id`, `name`, `email`, `description`, `rating`, `start_date`) VALUES
(30, 'beep', 'beep@gmail.com', 'description', 100, '2/3/45'),
(35, 'naem', 'email', 'desc', 45, 'date'),
(39, 'tester', 'test.com', 'test descriptop', 4, '10/2/21'),
(40, 'pea brain', 'snoopdogofscience@gmail.com', 'againstthiskindofmind', 100, '10/2/12');

-- --------------------------------------------------------

--
-- Table structure for table `recruiter_company`
--

CREATE TABLE `recruiter_company` (
  `recid` bigint(20) NOT NULL,
  `comid` bigint(20) NOT NULL,
  `rel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `recruiter_company`
--

INSERT INTO `recruiter_company` (`recid`, `comid`, `rel`) VALUES
(4, 17, 1);

INSERT INTO `recruiter_company` (`recid`, `comid`, `rel`) VALUES
(30, 1, 1),
(30, 19, 1);

-- --------------------------------------------------------

--
-- Table structure for table `recruiter_job`
--

CREATE TABLE `recruiter_job` (
  `recid` bigint(20) NOT NULL,
  `jobid` bigint(20) NOT NULL,
  `rel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `templates/jobseeker`
--

CREATE TABLE `templates/jobseeker` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `prevsalary` double NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `prev_salary` double NOT NULL,
  `jobseeker_id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `dob` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comlogin`
--
ALTER TABLE `comlogin`
  ADD PRIMARY KEY (`comid`);

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `job`
--
ALTER TABLE `job`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jobseeker`
--
ALTER TABLE `jobseeker`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `recruiter`
--
ALTER TABLE `recruiter`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `recruiter_company`
--
ALTER TABLE `recruiter_company`
  ADD PRIMARY KEY (`comid`,`recid`);

--
-- Indexes for table `templates/jobseeker`
--
ALTER TABLE `templates/jobseeker`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `company`
--
ALTER TABLE `company`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `job`
--
ALTER TABLE `job`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `jobseeker`
--
ALTER TABLE `jobseeker`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `recruiter`
--
ALTER TABLE `recruiter`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `templates/jobseeker`
--
ALTER TABLE `templates/jobseeker`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
