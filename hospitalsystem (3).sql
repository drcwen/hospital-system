-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 11, 2025 at 07:16 PM
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
-- Database: `hospitalsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `dischargepatient`
--

CREATE TABLE `dischargepatient` (
  `patient_id` varchar(255) NOT NULL,
  `patient_firstName` varchar(255) DEFAULT NULL,
  `patient_lastName` varchar(255) DEFAULT NULL,
  `discharge_date` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dischargepatient`
--

INSERT INTO `dischargepatient` (`patient_id`, `patient_firstName`, `patient_lastName`, `discharge_date`) VALUES
('2000105', 'Mark', 'Derraco', '11/28/2024');

-- --------------------------------------------------------

--
-- Table structure for table `employeeaccounts`
--

CREATE TABLE `employeeaccounts` (
  `emp_id` int(254) NOT NULL,
  `emp_firstName` varchar(254) NOT NULL,
  `emp_lastName` varchar(254) NOT NULL,
  `emp_department` varchar(254) NOT NULL,
  `emp_email` varchar(254) NOT NULL,
  `emp_password` varchar(254) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employeeaccounts`
--

INSERT INTO `employeeaccounts` (`emp_id`, `emp_firstName`, `emp_lastName`, `emp_department`, `emp_email`, `emp_password`) VALUES
(1000100, 'Wendel', 'Derraco', 'Admin Department', 'admin@healthcare.com', '123'),
(1000101, 'Maria', 'Bautista', 'Physician', 'maria.bautista@healthcare.com', '123'),
(1000102, 'Juan', 'Dela Cruz', 'Accounting Department', 'juan.delacruz@healthcare.com', '123');

-- --------------------------------------------------------

--
-- Table structure for table `employeearchive`
--

CREATE TABLE `employeearchive` (
  `count` int(255) NOT NULL,
  `emp_id` varchar(255) NOT NULL,
  `emp_firstName` varchar(255) NOT NULL,
  `emp_lastName` varchar(255) NOT NULL,
  `department` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `action` varchar(255) NOT NULL,
  `date_of_action` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employeearchive`
--

INSERT INTO `employeearchive` (`count`, `emp_id`, `emp_firstName`, `emp_lastName`, `department`, `username`, `password`, `action`, `date_of_action`) VALUES
(1, '1000104', 'asdas', 'asdas', 'Doctor Department', 'asdasd', 'asdasd', 'Delete', '12/03/2024'),
(2, '1000103', 'Mike', 'Hulip', 'Accounting Department', 'mikehulip', '123', 'Delete', '12/12/2024'),
(3, '1000102', 'Juan', 'Dela Cruz', 'Accounting Department', 'juan.delacruz@hospital.com', '123', 'Delete', '12/12/2024');

-- --------------------------------------------------------

--
-- Table structure for table `finalizebills`
--

CREATE TABLE `finalizebills` (
  `patient_id` int(255) NOT NULL,
  `patient_firstName` varchar(255) DEFAULT NULL,
  `patient_lastName` varchar(255) DEFAULT NULL,
  `roomcharge_quant` varchar(255) DEFAULT NULL,
  `roomcharge_price` varchar(255) DEFAULT NULL,
  `roomcharge_total` varchar(255) DEFAULT NULL,
  `physicianfee_quant` varchar(255) DEFAULT NULL,
  `physicianfee_price` varchar(255) DEFAULT NULL,
  `physicianfee_total` varchar(255) DEFAULT NULL,
  `labtest_quant` varchar(255) DEFAULT NULL,
  `labtest_price` varchar(255) NOT NULL,
  `labtest_total` varchar(255) DEFAULT NULL,
  `surgery_quant` varchar(255) DEFAULT NULL,
  `surgery_price` varchar(255) DEFAULT NULL,
  `surgery_total` varchar(255) DEFAULT NULL,
  `nursing_quant` varchar(255) DEFAULT NULL,
  `nursing_price` varchar(255) DEFAULT NULL,
  `nursing_total` varchar(255) DEFAULT NULL,
  `final_total` varchar(255) DEFAULT NULL,
  `date_admission` varchar(255) DEFAULT NULL,
  `date_discharge` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `finalizebills`
--

INSERT INTO `finalizebills` (`patient_id`, `patient_firstName`, `patient_lastName`, `roomcharge_quant`, `roomcharge_price`, `roomcharge_total`, `physicianfee_quant`, `physicianfee_price`, `physicianfee_total`, `labtest_quant`, `labtest_price`, `labtest_total`, `surgery_quant`, `surgery_price`, `surgery_total`, `nursing_quant`, `nursing_price`, `nursing_total`, `final_total`, `date_admission`, `date_discharge`) VALUES
(2000105, 'Mark', 'Derraco', '7', '0.0', '0.0', '1', '2000.0', '2000.0', '1', '5000.0', '5000.0', '0', '0.0', '0.0', '1', '2000.0', '2000.0', '9000.0', NULL, NULL),
(2000107, 'asd', 'asd', '2', '2.0', '2.0', '1', '3000.0', '3000.0', '1', '2000.0', '2000.0', '0', '0.0', '0.0', '0', '0.0', '0.0', '5004.0', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `inpatient`
--

CREATE TABLE `inpatient` (
  `inpatient_count` int(255) NOT NULL,
  `patient_id` int(255) NOT NULL,
  `patient_firstName` varchar(255) DEFAULT NULL,
  `patient_lastName` varchar(255) DEFAULT NULL,
  `inpatient_contactEmer` varchar(255) DEFAULT NULL,
  `inpatient_contactNumEmer` varchar(255) DEFAULT NULL,
  `inpatient_room` varchar(255) DEFAULT NULL,
  `inpatient_admissiondate` varchar(255) DEFAULT NULL,
  `inpatient_admissiontime` varchar(255) DEFAULT NULL,
  `inpatient_allergies` varchar(255) DEFAULT NULL,
  `inpatient_chronic` varchar(255) DEFAULT NULL,
  `inpatient_physician` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `inpatient`
--

INSERT INTO `inpatient` (`inpatient_count`, `patient_id`, `patient_firstName`, `patient_lastName`, `inpatient_contactEmer`, `inpatient_contactNumEmer`, `inpatient_room`, `inpatient_admissiondate`, `inpatient_admissiontime`, `inpatient_allergies`, `inpatient_chronic`, `inpatient_physician`) VALUES
(25, 2000107, 'asd', 'asd', 'James', '092733819178', '501', '12-12-2024', '1:42pm', 'Shrimp', 'Hypertension', 'Maria Bautista');

-- --------------------------------------------------------

--
-- Table structure for table `outpatient`
--

CREATE TABLE `outpatient` (
  `outpatient_count` int(255) NOT NULL,
  `patient_id` int(255) NOT NULL,
  `patient_firstName` varchar(255) NOT NULL,
  `patient_lastName` varchar(255) NOT NULL,
  `outpatient_contactEmer` varchar(255) NOT NULL,
  `outpatient_contactNumEmer` varchar(255) NOT NULL,
  `outpatient_allergies` varchar(255) NOT NULL,
  `outpatient_chronic` varchar(255) NOT NULL,
  `outpatient_physician` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `patientarchive`
--

CREATE TABLE `patientarchive` (
  `count` int(11) NOT NULL,
  `patient_id` int(255) NOT NULL,
  `patient_firstName` varchar(255) NOT NULL,
  `patient_lastName` varchar(255) NOT NULL,
  `patient_age` varchar(255) NOT NULL,
  `patient_birthday` varchar(255) NOT NULL,
  `patient_contact` varchar(255) NOT NULL,
  `patient_allergies` varchar(255) NOT NULL,
  `patient_address` varchar(255) NOT NULL,
  `patient_ailment` varchar(255) NOT NULL,
  `patient_type` varchar(255) NOT NULL,
  `blood_type` varchar(255) NOT NULL,
  `chronic_conditions` varchar(255) NOT NULL,
  `person_emergency` varchar(255) NOT NULL,
  `contact_emergency` varchar(255) NOT NULL,
  `physician` varchar(255) NOT NULL,
  `room_number` varchar(255) DEFAULT NULL,
  `admission_date` varchar(255) DEFAULT NULL,
  `admission_time` varchar(255) DEFAULT NULL,
  `action` varchar(255) NOT NULL,
  `date_of_action` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patientarchive`
--

INSERT INTO `patientarchive` (`count`, `patient_id`, `patient_firstName`, `patient_lastName`, `patient_age`, `patient_birthday`, `patient_contact`, `patient_allergies`, `patient_address`, `patient_ailment`, `patient_type`, `blood_type`, `chronic_conditions`, `person_emergency`, `contact_emergency`, `physician`, `room_number`, `admission_date`, `admission_time`, `action`, `date_of_action`) VALUES
(26, 2000106, 'Janes', 'Cruz', '24', '12-13-2001', '09875586748', 'N/A', 'Quezon City', 'Cough', 'In Patient', 'A-', 'Hypertension', 'Morri Cruz', '09892235466', 'Maria Bautista', '501', '12-01-2024', '5:45 PM', 'Update', '12/08/2024 01:18:00'),
(27, 2000108, 'asdaa', 'asdasasddasdasdsa', 'asd', 'asdaasds', 'sdasddasd', 'asd', 'asadasasd', 'asdasdasd', 'asd', 'asds', 'asd', 'd', 'as', 'asd', 'asd', 'as', 'asd', 'Delete', '12/08/2024'),
(28, 2000106, 'Janesss', 'Cruz', '24', '12-13-2001', '09875586748', 'N/A', 'Quezon City', 'Cough', 'In Patient', 'A-', 'Hypertension', 'Morri Cruz', '09892235466', 'Maria Bautista', '501', '12-01-2024', '5:45 PM', 'Update', '12/08/2024 01:20:41'),
(29, 2000106, 'Janesss', 'Cruz', '24', '12-13-2001', '09875586748', 'N/A', 'Quezon City', 'Cough', 'In Patient', 'A-', 'Hypertension', 'Morri Cruz', '09892235466', 'Maria Bautista', '501', '12-01-2024', '5:45 PM', 'Delete', '12/08/2024 01:43:27');

-- --------------------------------------------------------

--
-- Table structure for table `patientbalances`
--

CREATE TABLE `patientbalances` (
  `patient_id` varchar(255) NOT NULL,
  `patient_firstName` varchar(255) NOT NULL,
  `patient_lastName` varchar(255) NOT NULL,
  `balance` varchar(255) NOT NULL,
  `outstanding_balance` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patientbalances`
--

INSERT INTO `patientbalances` (`patient_id`, `patient_firstName`, `patient_lastName`, `balance`, `outstanding_balance`) VALUES
('2000105', 'Mark', 'Derraco', '9000.0', '0.0'),
('2000107', 'asd', 'asd', '5004.0', '-4996.0');

-- --------------------------------------------------------

--
-- Table structure for table `receipt`
--

CREATE TABLE `receipt` (
  `receipt_number` int(255) NOT NULL,
  `patient_id` varchar(255) DEFAULT NULL,
  `patient_firstName` varchar(255) DEFAULT NULL,
  `patient_lastName` varchar(255) DEFAULT NULL,
  `payment_price` varchar(255) DEFAULT NULL,
  `balance` varchar(255) DEFAULT NULL,
  `dateOfPayment` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `receipt`
--

INSERT INTO `receipt` (`receipt_number`, `patient_id`, `patient_firstName`, `patient_lastName`, `payment_price`, `balance`, `dateOfPayment`) VALUES
(100, '2000200', 'Placeholder Only', 'Placeholder Only', '450', NULL, ''),
(113, '2000105', 'Mark', 'Derraco', '4500', '0.0', '11/28/2024'),
(115, '2000105', 'Mark', 'Derraco', '1', '0.0', '12/05/2024'),
(116, '2000107', 'asd', 'asd', '5004', '0.0', '12/12/2024'),
(117, '2000107', 'asd', 'asd', '10000', '-4996.0', '12/12/2024');

-- --------------------------------------------------------

--
-- Table structure for table `registerpatient`
--

CREATE TABLE `registerpatient` (
  `patient_id` int(255) NOT NULL,
  `patient_firstName` varchar(255) NOT NULL,
  `patient_lastName` varchar(255) NOT NULL,
  `patient_age` varchar(255) NOT NULL,
  `patient_birthday` varchar(255) NOT NULL,
  `patient_contact` varchar(255) NOT NULL,
  `patient_address` varchar(255) NOT NULL,
  `patient_ailment` varchar(255) NOT NULL,
  `patient_type` varchar(255) NOT NULL,
  `patient_blood` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `registerpatient`
--

INSERT INTO `registerpatient` (`patient_id`, `patient_firstName`, `patient_lastName`, `patient_age`, `patient_birthday`, `patient_contact`, `patient_address`, `patient_ailment`, `patient_type`, `patient_blood`) VALUES
(2000105, 'Mark', 'Derraco', '20', '12-22-2003', '0923427342734234', 'Caloocan', 'Cough', 'Discharged', 'A+'),
(2000106, 'asd', 'asd', 'asd', '12-05-2024', 'asd', 'asd', 'asd', 'In Patient', 'A+'),
(2000107, 'asd', 'asd', '20', '12-12-2024', '09763374627', 'Caloocan', 'Diabetes', 'In Patient', 'A-');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dischargepatient`
--
ALTER TABLE `dischargepatient`
  ADD PRIMARY KEY (`patient_id`);

--
-- Indexes for table `employeeaccounts`
--
ALTER TABLE `employeeaccounts`
  ADD PRIMARY KEY (`emp_id`);

--
-- Indexes for table `employeearchive`
--
ALTER TABLE `employeearchive`
  ADD PRIMARY KEY (`count`);

--
-- Indexes for table `finalizebills`
--
ALTER TABLE `finalizebills`
  ADD PRIMARY KEY (`patient_id`);

--
-- Indexes for table `inpatient`
--
ALTER TABLE `inpatient`
  ADD PRIMARY KEY (`inpatient_count`);

--
-- Indexes for table `outpatient`
--
ALTER TABLE `outpatient`
  ADD PRIMARY KEY (`outpatient_count`);

--
-- Indexes for table `patientarchive`
--
ALTER TABLE `patientarchive`
  ADD PRIMARY KEY (`count`);

--
-- Indexes for table `patientbalances`
--
ALTER TABLE `patientbalances`
  ADD PRIMARY KEY (`patient_id`);

--
-- Indexes for table `receipt`
--
ALTER TABLE `receipt`
  ADD PRIMARY KEY (`receipt_number`);

--
-- Indexes for table `registerpatient`
--
ALTER TABLE `registerpatient`
  ADD PRIMARY KEY (`patient_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employeearchive`
--
ALTER TABLE `employeearchive`
  MODIFY `count` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `inpatient`
--
ALTER TABLE `inpatient`
  MODIFY `inpatient_count` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `outpatient`
--
ALTER TABLE `outpatient`
  MODIFY `outpatient_count` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `patientarchive`
--
ALTER TABLE `patientarchive`
  MODIFY `count` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `receipt`
--
ALTER TABLE `receipt`
  MODIFY `receipt_number` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=118;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
