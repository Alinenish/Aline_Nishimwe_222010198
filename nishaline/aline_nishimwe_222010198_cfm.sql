-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 11:40 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aline_nishimwe_222010198_cfm`
--

-- --------------------------------------------------------

--
-- Table structure for table `attachments`
--

CREATE TABLE `attachments` (
  `Attachment_id` int(11) NOT NULL,
  `File_name` varchar(255) DEFAULT NULL,
  `File_type` varchar(50) DEFAULT NULL,
  `File_size` varchar(20) DEFAULT NULL,
  `date_uploaded` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `attachments`
--

INSERT INTO `attachments` (`Attachment_id`, `File_name`, `File_type`, `File_size`, `date_uploaded`) VALUES
(1, 'photo', 'document', '115', '2024-02-15'),
(2, 'bill', 'pdf', '32', '2023-09-15'),
(12, 'bill', 'pdf', '32', '2023-09-12'),
(18, 'bill', 'pdf', '32', '2023-12-29'),
(23, 'bill', 'pdf', '18', '2023-08-24'),
(38, 'documents', 'word', '500', '2023-07-23'),
(44, 'book', 'ppt', 'book', '2024-02-14'),
(60, 'documents', 'word', '35', '2023-09-03'),
(76, 'DOCUMENTS', 'EXCEL', '250', '2023-02-12');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `COUNTRY` varchar(255) DEFAULT NULL,
  `DISTRICT` varchar(20) DEFAULT NULL,
  `AGE` varchar(255) DEFAULT NULL,
  `GENDER` varchar(255) DEFAULT NULL,
  `password` varchar(225) DEFAULT NULL,
  `Email` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `NAME`, `COUNTRY`, `DISTRICT`, `AGE`, `GENDER`, `password`, `Email`) VALUES
(5, 'MUTONI Alice', 'kenya', 'kigali', '24', 'female', '', 'alicemutoni3@gmail.com'),
(14, 'RUTH UWERA', 'Rwanda', 'RUBAVU', '28', 'female', NULL, 'ruthuwera222@gmail.com'),
(23, 'kalisa', 'Rwanda', 'Rwamagana', '35', 'male', NULL, 'kalisa2002@gmail.com'),
(25, 'MUGABO Paul', 'Rwanda', 'Rusizi', '32', 'male', NULL, 'paulmugabo12@gmail.com'),
(26, 'Aline', 'Rwanda', 'rusizi', '23', NULL, 'fhfjhh@2', 'aline@gmail.com'),
(27, 'NISHIMWE Aline', 'Rwanda', 'Rusizi', '23', NULL, '123', 'alinenishimwe2001@gmail.com'),
(28, 'yvonne muhawe', 'Rwanda', 'kigali', '45', NULL, '222010198', 'yvonnemuhawe@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `feedback_id` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `Reply` text DEFAULT NULL,
  `feedback_text` text DEFAULT NULL,
  `replymanager` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`feedback_id`, `customer_id`, `Reply`, `feedback_text`, `replymanager`) VALUES
(6, 23, 'thank you for your feedback', 'Excellent service', '223'),
(12, NULL, 'outdated of your product', 'i am not satisfy', 'give us your details information'),
(16, 5, 'satisfy', 'your product is very quality', '44'),
(17, 25, 'order', 'i recerved your product but can not match with my orderly', '45'),
(23, NULL, 'poor quality', 'in two days i cannot assess to my product', 'sorry for this service but we can help you'),
(34, NULL, 'poor quality', 'your product doesn\'t have good quality', 'we are going to recorver'),
(35, NULL, 'thank you ', NULL, NULL),
(36, NULL, 'thank you ', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE `manager` (
  `manager_id` int(11) NOT NULL,
  `username` varchar(225) DEFAULT NULL,
  `password_hash` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Role` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`manager_id`, `username`, `password_hash`, `Email`, `Role`) VALUES
(8, 'yvonne', '123', 'yvonne@gmail.com', 'general manager'),
(22, 'nishimwe aline ', '222012', 'alinenishimwe2001@gmail.com', 'brancher manager'),
(44, 'MUGISHA David', '2222', 'mugishadavid21@gmail.com', 'Brancher manager'),
(45, 'NIYONKURU Paul', '2224', 'niyonkurupaul@gmail.com', 'general manager'),
(67, 'hirwa Bless', '234', 'bless@gmail.com', 'general manager'),
(78, 'kalisa liliane', '6988', 'liliane@gmail.com', 'manager'),
(79, 'umutoni akeza', '4357', 'akeza@gmail.com', 'brancher manager');

-- --------------------------------------------------------

--
-- Table structure for table `services`
--

CREATE TABLE `services` (
  `service_id` int(20) NOT NULL,
  `date` varchar(100) DEFAULT NULL,
  `duration` varchar(100) DEFAULT NULL,
  `type_of_service` varchar(100) DEFAULT NULL,
  `availability` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `services`
--

INSERT INTO `services` (`service_id`, `date`, `duration`, `type_of_service`, `availability`) VALUES
(1, '2024-01-18', '6:00am up 6:00am', 'delivering products', 'courier service'),
(2, '2023-12-12', '12:45:12', 'packing', 'packing materials'),
(3, '2023-12-30', '15:45:12', 'Trading', 'Buying and selling'),
(12, '2024-02-24', '9:30 pm', 'derively', 'purchase chips'),
(23, '2024-04-12', '8:20am', 'delivery', 'selling flowers');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attachments`
--
ALTER TABLE `attachments`
  ADD PRIMARY KEY (`Attachment_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`),
  ADD UNIQUE KEY `customer_id` (`customer_id`),
  ADD UNIQUE KEY `customer_id_2` (`password`) USING BTREE,
  ADD UNIQUE KEY `password` (`password`,`NAME`,`COUNTRY`,`DISTRICT`,`AGE`,`GENDER`) USING HASH;

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`feedback_id`),
  ADD KEY `customer_id` (`customer_id`);

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`manager_id`);

--
-- Indexes for table `services`
--
ALTER TABLE `services`
  ADD PRIMARY KEY (`service_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attachments`
--
ALTER TABLE `attachments`
  MODIFY `Attachment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=78;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `feedback_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `manager`
--
ALTER TABLE `manager`
  MODIFY `manager_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=80;

--
-- AUTO_INCREMENT for table `services`
--
ALTER TABLE `services`
  MODIFY `service_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
