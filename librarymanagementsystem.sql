-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 18, 2020 at 07:59 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `librarymanagementsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admin`
--

CREATE TABLE `tbl_admin` (
  `id` int(11) NOT NULL,
  `adminBarcode` varchar(50) NOT NULL,
  `Firstname` varchar(50) NOT NULL,
  `MiddleName` varchar(50) NOT NULL,
  `Lastname` varchar(50) NOT NULL,
  `Age` int(11) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `ConfirmPass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_admin`
--

INSERT INTO `tbl_admin` (`id`, `adminBarcode`, `Firstname`, `MiddleName`, `Lastname`, `Age`, `Gender`, `Address`, `Username`, `Password`, `ConfirmPass`) VALUES
(4, '002', 'rose', 'panganoron', 'bolito', 25, 'FEMALE', 'balilihan', 'rosetest', '[C@f6abf36', '[C@4d6a7d66');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_androidborrow`
--

CREATE TABLE `tbl_androidborrow` (
  `ISBNBarcode` varchar(22) NOT NULL,
  `Material` varchar(50) NOT NULL,
  `RCBarcode` varchar(50) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Course` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_androidborrow`
--

INSERT INTO `tbl_androidborrow` (`ISBNBarcode`, `Material`, `RCBarcode`, `Name`, `Course`) VALUES
('ISBNBarcode: 978462323', 'Book', '003', 'Mary Rose Bolito', 'BS InfoTech'),
('ISBNBarcode: 978342309', 'Cd', '003', 'Mary Rose Bolito', 'BS InfoTech');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_bookaccessions`
--

CREATE TABLE `tbl_bookaccessions` (
  `id` int(11) NOT NULL,
  `accessID` int(20) NOT NULL,
  `ISBNBarcode` varchar(20) NOT NULL,
  `BookTitle` varchar(55) NOT NULL,
  `BookAuthor` varchar(55) NOT NULL,
  `BookPublisher` varchar(55) NOT NULL,
  `BookType` varchar(55) NOT NULL,
  `NoCopies` int(22) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_bookaccessions`
--

INSERT INTO `tbl_bookaccessions` (`id`, `accessID`, `ISBNBarcode`, `BookTitle`, `BookAuthor`, `BookPublisher`, `BookType`, `NoCopies`) VALUES
(19, 234, '93285', 'Hes into Her', 'Maxinejiji', 'Precious Hearts Romance', 'General Collection', 0),
(20, 235, '93285', 'Hes into Her', 'Maxinejiji', 'Precious Hearts Romance', 'General Collection', 1),
(21, 236, '93285', 'Hes into Her', 'Maxinejiji', 'Precious Hearts Romance', 'General Collection', 2),
(22, 1, '9789719631200', 'Ethics', 'Apolinar Henry', 'VIBal', 'General Collection', 0),
(23, 2, '9789719631200', 'Ethics', 'Apolinar Henry', 'VIBal', 'General Collection', 1),
(24, 342, '5325235', 'fws', 'sfs', 'wetw', 'General References', 0),
(25, 343, '5325235', 'fws', 'sfs', 'wetw', 'General References', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_booktype`
--

CREATE TABLE `tbl_booktype` (
  `id` int(11) NOT NULL,
  `booktype` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_booktype`
--

INSERT INTO `tbl_booktype` (`id`, `booktype`) VALUES
(1, 'GENERAL SECTION'),
(2, 'LAW BOOKS'),
(3, 'FILIPINIANA'),
(4, 'CIRCULAR COLLECTION'),
(5, 'GENERAL REFERENCES'),
(6, 'THESIS'),
(7, 'RESERVED BOOKS'),
(8, 'CHILDREN SECTION');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_borrowinside`
--

CREATE TABLE `tbl_borrowinside` (
  `id` int(11) NOT NULL,
  `material` varchar(20) NOT NULL,
  `accession_number` int(20) NOT NULL,
  `ISBNBarcode` varchar(20) NOT NULL,
  `CopiesAvailable` int(20) NOT NULL,
  `borrower_barcode` varchar(20) NOT NULL,
  `date` varchar(20) NOT NULL,
  `time` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_borrowinside`
--

INSERT INTO `tbl_borrowinside` (`id`, `material`, `accession_number`, `ISBNBarcode`, `CopiesAvailable`, `borrower_barcode`, `date`, `time`) VALUES
(1, 'BOOK', 14, '9780982390849', 3, '004', '11-29-2017', '06:26'),
(2, 'BOOK', 2, '9780949023490', 0, '004', '11-29-2017', '06:47'),
(3, 'JOURNAL', 224, '00976', 0, '223423', '09-13-2020', '06:28'),
(4, 'BOOK', 2, '0094297', 0, '223423', '09-13-2020', '07:02'),
(5, 'MAGAZINE', 356, '9783423434232', 2, '223423', '09-13-2020', '08:10'),
(6, 'NEWSPAPER', 24, '326262', 1, '223423', '09-13-2020', '08:28'),
(7, 'BOOK', 235, '93285', 0, '34242', '09-14-2020', '10:34'),
(8, 'BOOK', 2, '9789719631200', 0, '9789871234530', '09-14-2020', '11:04');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_borrowoutside`
--

CREATE TABLE `tbl_borrowoutside` (
  `id` int(11) NOT NULL,
  `material` varchar(20) NOT NULL,
  `accession_number` varchar(20) NOT NULL,
  `ISBNBarcode` varchar(20) NOT NULL,
  `borrower_barcode` varchar(20) NOT NULL,
  `date_to_return` varchar(20) NOT NULL,
  `category_id` int(5) NOT NULL,
  `date` varchar(20) NOT NULL,
  `time` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_borrowoutside`
--

INSERT INTO `tbl_borrowoutside` (`id`, `material`, `accession_number`, `ISBNBarcode`, `borrower_barcode`, `date_to_return`, `category_id`, `date`, `time`) VALUES
(6, 'BOOK', '2', '9780949023490', '003', '11-30-2017', 2, '11-29-2017', '06:52'),
(7, 'NEWSPAPER', '333', '09876655', '223423', '09-15-2020', 1, '09-13-2020', '07:17'),
(8, 'JOURNAL', '224', '00976', '34242', '09-15-2020', 1, '09-14-2020', '10:16');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_category`
--

CREATE TABLE `tbl_category` (
  `id` int(2) NOT NULL,
  `category` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_category`
--

INSERT INTO `tbl_category` (`id`, `category`) VALUES
(1, 'CONGRESSIONAL LIBRARY'),
(2, 'BISU LIBRARY');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_cd`
--

CREATE TABLE `tbl_cd` (
  `id` int(11) NOT NULL,
  `cd_Barcode` varchar(20) NOT NULL,
  `cd_DateAcquisition` varchar(50) NOT NULL,
  `cd_Title` varchar(50) NOT NULL,
  `cd_EditionNumber` int(4) NOT NULL,
  `cd_Place` varchar(50) NOT NULL,
  `cd_Producer` varchar(50) NOT NULL,
  `cd_Year` int(4) NOT NULL,
  `cd_Genre` varchar(50) NOT NULL,
  `NoOfCopies` int(11) NOT NULL,
  `Status` varchar(20) NOT NULL,
  `days` varchar(10) NOT NULL,
  `Availability` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_cd`
--

INSERT INTO `tbl_cd` (`id`, `cd_Barcode`, `cd_DateAcquisition`, `cd_Title`, `cd_EditionNumber`, `cd_Place`, `cd_Producer`, `cd_Year`, `cd_Genre`, `NoOfCopies`, `Status`, `days`, `Availability`) VALUES
(9, '09025719', '09-16-2020', 'sajajkl', 3246, 'jsalkajlk', 'jskajfkla', 2020, 'English', 2, 'Available', '2', 'YES'),
(10, '543453', '09-23-2020', 'ete', 43333, 'ete', 'terert', 2020, 'Filipino', 2, 'Available', '2', 'YES');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_cdaccession`
--

CREATE TABLE `tbl_cdaccession` (
  `id` int(11) NOT NULL,
  `accession` int(20) NOT NULL,
  `ISBNBarcode` varchar(20) NOT NULL,
  `Title` varchar(55) NOT NULL,
  `Genre` varchar(55) NOT NULL,
  `Copies` int(22) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_cdaccession`
--

INSERT INTO `tbl_cdaccession` (`id`, `accession`, `ISBNBarcode`, `Title`, `Genre`, `Copies`) VALUES
(1, 2323, '23803', 'ssfsdf', 'English', 0),
(2, 2324, '23803', 'ssfsdf', 'English', 1),
(3, 342, '32r3242', '3r2', 'Filipino', 0),
(4, 343, '32r3242', '3r2', 'Filipino', 0),
(5, 94, '23803', 'ssfsdf', 'English', 2),
(6, 95, '23803', 'ssfsdf', 'English', 3),
(8, 454, '32r3242', '3r2', 'Filipino', 0),
(9, 23, '008663', 'asfa', 'Science and Technology', 0),
(10, 24, '008663', 'asfa', 'Science and Technology', 1),
(11, 25, '008663', 'asfa', 'Science and Technology', 2),
(12, 32, '352532', 'rwrw', 'Filipino', 0),
(13, 345, '098777', 'afas', 'English', 0),
(14, 333, '09025719', 'sajajkl', 'English', 0),
(15, 334, '09025719', 'sajajkl', 'English', 1),
(16, 323, '543453', 'ete', 'Filipino', 0),
(17, 324, '543453', 'ete', 'Filipino', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_cdtype`
--

CREATE TABLE `tbl_cdtype` (
  `id` int(11) NOT NULL,
  `cdtype` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_cdtype`
--

INSERT INTO `tbl_cdtype` (`id`, `cdtype`) VALUES
(1, 'SCIENCE AND TECHNOLOGY'),
(2, 'MATHEMATICS'),
(3, 'ENGLISH'),
(4, 'FILIPINO'),
(5, 'ARTS'),
(6, 'HISTORY');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_clientregistration`
--

CREATE TABLE `tbl_clientregistration` (
  `id` int(11) NOT NULL,
  `ClientBarcode` varchar(20) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `DateOfBirth` varchar(20) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `ClientType` varchar(50) NOT NULL,
  `Course` varchar(50) NOT NULL,
  `DateIssued` varchar(20) NOT NULL,
  `DateExpired` varchar(20) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_clientregistration`
--

INSERT INTO `tbl_clientregistration` (`id`, `ClientBarcode`, `Name`, `DateOfBirth`, `Gender`, `Address`, `ClientType`, `Course`, `DateIssued`, `DateExpired`, `Username`, `Password`) VALUES
(2, '004', 'Mary jane Chatto', '09-28-1996', 'Female', 'Balilihan, Bohol', 'BISU Balilihan Student', 'BS Information Technology', '11-29-2017', '11-29- 2018', 'jane', 'chatto'),
(6, '47342', 'gdsgds', '09-17-2020', 'Female', 'gsdgsdg', 'Other School Student', 'BS Information Technology', 'September 13, 2020', 'September 13,  2021', 'test1234', 'merose1234'),
(8, '223423', 'dgsdg', 'September 15, 2020', 'Male', 'dgsdgs', 'BISU Balilihan Student', 'BS Computer Science', '09-13-2020', '09-13-2021', 'ewt', 'fdsfs'),
(9, '34242', 'Rose', '09-16-2020', 'Male', 'dgss', 'Other School Student', 'BS Information Technology', '09-14-2020', '09-14- 2021', 'rose', 'rose'),
(10, '9789871234530', 'Mary Rose Bolito', '09-25-1996', 'Female', 'Balilihan, Bohol', 'BISU Balilihan Student', 'BS Information Technology', '09-14-2020', '09-14-  2021', 'rosetest', 'rosetest'),
(11, '9789871234530', 'fafa', '09-09-2020', 'Male', 'gesaga', 'BISU Balilihan Student', 'BS Electronix', '09-14-2020', '09-14-  2021', 'gggs', 'ss'),
(12, '35232', 'fw', '09-16-2020', 'Male', 'wffffa', 'BISU Balilihan Student', 'BS Electrical', '09-17-2020', '09-17- 2021', 'sfafa', '3233f');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_clientrenewal`
--

CREATE TABLE `tbl_clientrenewal` (
  `id` int(22) NOT NULL,
  `rcbarcode` varchar(22) NOT NULL,
  `dateexpired` varchar(50) NOT NULL,
  `daterenew` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_journal`
--

CREATE TABLE `tbl_journal` (
  `id` int(11) NOT NULL,
  `ISBNBarcode` varchar(20) NOT NULL,
  `DateAcquisition` varchar(20) NOT NULL,
  `J_Title` varchar(50) NOT NULL,
  `J_Author` varchar(50) NOT NULL,
  `J_Publisher` varchar(50) NOT NULL,
  `EditionNumber` int(5) NOT NULL,
  `Pagevol` int(4) NOT NULL,
  `Place` varchar(50) NOT NULL,
  `Year` int(4) NOT NULL,
  `Source` varchar(50) NOT NULL,
  `NoOfCopies` int(11) NOT NULL,
  `Status` varchar(20) NOT NULL,
  `days` varchar(10) NOT NULL,
  `Availability` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_journal`
--

INSERT INTO `tbl_journal` (`id`, `ISBNBarcode`, `DateAcquisition`, `J_Title`, `J_Author`, `J_Publisher`, `EditionNumber`, `Pagevol`, `Place`, `Year`, `Source`, `NoOfCopies`, `Status`, `days`, `Availability`) VALUES
(2, '53235', 'September 16, 2020', 'fffsf', 'f', 'fds', 24, 233, 'f', 2020, 'sdgsdgs', 5, 'Available', '----', 'YES'),
(3, '53523', '09-16-2020', 'efwef', 'efww', 'fwefw', 23, 322, 'fwfe', 2020, 'efffffffffs', 0, 'Available', '2', 'YES');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_journalaccession`
--

CREATE TABLE `tbl_journalaccession` (
  `id` int(11) NOT NULL,
  `accession` int(20) NOT NULL,
  `ISBNBarcode` varchar(20) NOT NULL,
  `Title` varchar(55) NOT NULL,
  `Author` varchar(55) NOT NULL,
  `Publisher` varchar(55) NOT NULL,
  `Copies` int(22) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_journalaccession`
--

INSERT INTO `tbl_journalaccession` (`id`, `accession`, `ISBNBarcode`, `Title`, `Author`, `Publisher`, `Copies`) VALUES
(1, 223, '00976', 'dwdsa', 'sds2rea', 'egwg', 0),
(2, 224, '00976', 'dwdsa', 'sds2rea', 'egwg', 1),
(3, 345, '53235', 'fffsf', 'f', 'fds', 0),
(4, 346, '53235', 'fffsf', 'f', 'fds', 1),
(5, 23, '53235', 'fffsf', 'f', 'fds', 2),
(6, 24, '53235', 'fffsf', 'f', 'fds', 3),
(7, 25, '53235', 'fffsf', 'f', 'fds', 4);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_librarybook`
--

CREATE TABLE `tbl_librarybook` (
  `id` int(11) NOT NULL,
  `ISBNBarcode` varchar(20) NOT NULL,
  `DateAcquisition` varchar(20) NOT NULL,
  `BookTitle` varchar(50) NOT NULL,
  `BookAuthor` varchar(50) NOT NULL,
  `EditionNumber` int(5) NOT NULL,
  `Pagevolume` int(5) NOT NULL,
  `Place` varchar(50) NOT NULL,
  `BookPublisher` varchar(50) NOT NULL,
  `Year` varchar(15) NOT NULL,
  `Binding` varchar(10) NOT NULL,
  `Price` varchar(20) NOT NULL,
  `Type` varchar(50) NOT NULL,
  `NoOfCopies` int(11) NOT NULL,
  `Status` varchar(20) NOT NULL,
  `days` varchar(10) NOT NULL,
  `Availability` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_librarybook`
--

INSERT INTO `tbl_librarybook` (`id`, `ISBNBarcode`, `DateAcquisition`, `BookTitle`, `BookAuthor`, `EditionNumber`, `Pagevolume`, `Place`, `BookPublisher`, `Year`, `Binding`, `Price`, `Type`, `NoOfCopies`, `Status`, `days`, `Availability`) VALUES
(34, '93285', '09-16-2020', 'Hes into Her', 'Maxinejiji', 324, 313, 'Manila', 'Precious Hearts Romance', '2020', 'Hardbound', '890', 'General Collection', 0, 'Available', '4', 'YES'),
(35, '9789719631200', '09-15-2020', 'Ethics', 'Apolinar Henry', 567, 214, 'Manila', 'VIBal', '2020', 'Hardbound', '300', 'General Collection', 0, 'Available', '3', 'YES'),
(36, '5325235', '09-16-2020', 'fws', 'sfs', 342, 32, 'etwtw', 'wetw', '2020', 'Hardbound', '324', 'General References', 2, 'Available', '5', 'YES');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_librarynewspaper`
--

CREATE TABLE `tbl_librarynewspaper` (
  `id` int(11) NOT NULL,
  `ISBNBarcode` varchar(20) NOT NULL,
  `NType` varchar(50) NOT NULL,
  `NHeading` varchar(50) NOT NULL,
  `NVolume` varchar(10) NOT NULL,
  `NDateReceive` varchar(50) NOT NULL,
  `NoOfCopies` int(11) NOT NULL,
  `Status` varchar(20) NOT NULL,
  `days` varchar(12) NOT NULL,
  `Availability` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_librarynewspaper`
--

INSERT INTO `tbl_librarynewspaper` (`id`, `ISBNBarcode`, `NType`, `NHeading`, `NVolume`, `NDateReceive`, `NoOfCopies`, `Status`, `days`, `Availability`) VALUES
(6, '34535', 'Bohol Chronicle', 'dsfs', '233', '09-17- 2020', 0, 'Available', '3', 'YES'),
(7, '35253', 'Bohol Chronicle', 'fwe', '32', '09-10-2020', 2, 'Available', '3', 'YES');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_login`
--

CREATE TABLE `tbl_login` (
  `id` int(11) NOT NULL,
  `adminBarcode` varchar(20) NOT NULL,
  `administrator` varchar(50) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_login`
--

INSERT INTO `tbl_login` (`id`, `adminBarcode`, `administrator`, `Username`, `Password`) VALUES
(1, '1', 'Bisu', 'bisubal', 'maambing'),
(14, '002', 'bolito', 'rosetest', 'rosetest123');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_logintypeclient`
--

CREATE TABLE `tbl_logintypeclient` (
  `id` int(11) NOT NULL,
  `type` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_logintypeclient`
--

INSERT INTO `tbl_logintypeclient` (`id`, `type`) VALUES
(1, 'Student'),
(2, 'Employee'),
(3, 'Outsider'),
(4, 'Faculty');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_magazine`
--

CREATE TABLE `tbl_magazine` (
  `id` int(11) NOT NULL,
  `ISBNBarcode` varchar(20) NOT NULL,
  `DateAcquisition` varchar(20) NOT NULL,
  `M_Title` varchar(50) NOT NULL,
  `M_Publisher` varchar(50) NOT NULL,
  `EditionNumber` int(5) NOT NULL,
  `PageVolume` int(5) NOT NULL,
  `Place` varchar(50) NOT NULL,
  `Year` int(4) NOT NULL,
  `NoofCopies` int(11) NOT NULL,
  `Status` varchar(20) NOT NULL,
  `days` varchar(10) NOT NULL,
  `Availability` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_magazine`
--

INSERT INTO `tbl_magazine` (`id`, `ISBNBarcode`, `DateAcquisition`, `M_Title`, `M_Publisher`, `EditionNumber`, `PageVolume`, `Place`, `Year`, `NoofCopies`, `Status`, `days`, `Availability`) VALUES
(1, '9786472348710', '2017 Nov 6', 'Bea Alonzo', 'Manila Magazine', 2, 123, 'Manila Philippines', 2017, 1, 'Available', '3', 'YES'),
(2, '9783423434232', '2013 Aug 15', 'Katniel lovers', 'Manila Magazine', 2, 21, 'Manila, Philippines', 2013, 3, 'Available', '2', 'YES'),
(4, '9786782468726', '2016 Sep 22', 'Coco Martin', 'Makita, Manila', 21, 23, 'Manila, Philippines', 2016, 1, 'Damaged', '----', 'NO'),
(5, '9788678236488', '2017 Nov 1', 'Maja Salvador', 'Quezon Magazine', 23, 24, 'Manila, Philippines', 2017, 1, 'Return', '----', 'NO'),
(6, '34234', 'MMMM dd, yyyy', 'rewrw', '2qwrq', 2123, 323, '', 2020, 2, 'Damaged', '----', 'YES'),
(7, '09976', 'September 18, 2020', 'waf', 'agasgss', 24, 34234, 'sga', 2020, 2, 'Available', '2', 'YES'),
(8, '5232', '09-16-2020', 'ewfw', 'wefw', 232, 323, 'erfss', 2020, 2, 'Available', '2', 'YES');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_magazineaccession`
--

CREATE TABLE `tbl_magazineaccession` (
  `id` int(11) NOT NULL,
  `accession` int(20) NOT NULL,
  `ISBNBarcode` varchar(20) NOT NULL,
  `Title` varchar(55) NOT NULL,
  `EdNum` int(11) NOT NULL,
  `Publisher` varchar(55) NOT NULL,
  `Copies` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_magazineaccession`
--

INSERT INTO `tbl_magazineaccession` (`id`, `accession`, `ISBNBarcode`, `Title`, `EdNum`, `Publisher`, `Copies`) VALUES
(1, 442, '34234', 'rewrw', 2123, '2qwrq', 0),
(2, 443, '34234', 'rewrw', 2123, '2qwrq', 1),
(3, 3444, '09976', 'waf', 24, 'agasg', 0),
(4, 3445, '09976', 'waf', 24, 'agasg', 1),
(5, 354, '9783423434232', 'Katniel lovers', 2, 'Manila Magazine', 0),
(6, 355, '9783423434232', 'Katniel lovers', 2, 'Manila Magazine', 1),
(7, 356, '9783423434232', 'Katniel lovers', 2, 'Manila Magazine', 2),
(8, 232, '5232', 'ewfw', 232, 'wefw', 0),
(9, 233, '5232', 'ewfw', 232, 'wefw', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_material`
--

CREATE TABLE `tbl_material` (
  `id` int(11) NOT NULL,
  `material` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_matmonitoring`
--

CREATE TABLE `tbl_matmonitoring` (
  `id` int(11) NOT NULL,
  `accession` varchar(11) NOT NULL,
  `barcode` varchar(22) NOT NULL,
  `status` varchar(22) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_matmonitoring`
--

INSERT INTO `tbl_matmonitoring` (`id`, `accession`, `barcode`, `status`) VALUES
(47, '224', '00976', 'borrowed'),
(48, '224', '00976', 'borrowed'),
(49, '224', '00976', 'borrowed'),
(50, '224', '00976', 'borrowed'),
(51, '224', '00976', 'borrowed'),
(52, '235', '93285', 'borrowed'),
(53, '235', '93285', 'borrowed'),
(54, '235', '93285', 'borrowed'),
(55, '235', '93285', 'borrowed'),
(56, '2', '9789719631200', 'borrowed');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_newsaccession`
--

CREATE TABLE `tbl_newsaccession` (
  `id` int(11) NOT NULL,
  `accession` int(20) NOT NULL,
  `ISBNBarcode` varchar(20) NOT NULL,
  `title` varchar(55) NOT NULL,
  `volume` int(22) NOT NULL,
  `copies` int(22) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_newsaccession`
--

INSERT INTO `tbl_newsaccession` (`id`, `accession`, `ISBNBarcode`, `title`, `volume`, `copies`) VALUES
(1, 22, '326262', 'tdgsg', 3242, 0),
(2, 23, '326262', 'tdgsg', 3242, 1),
(3, 24, '326262', 'tdgsg', 3242, 2),
(4, 332, '09876655', 'sdfg', 2222, 0),
(5, 333, '09876655', 'sdfg', 2222, 1),
(6, 211, '35253', 'fwe', 32, 0),
(7, 212, '35253', 'fwe', 32, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_penalty`
--

CREATE TABLE `tbl_penalty` (
  `id` int(22) NOT NULL,
  `accession` varchar(22) NOT NULL,
  `barcode` varchar(22) NOT NULL,
  `rcbarcode` varchar(22) NOT NULL,
  `name` varchar(50) NOT NULL,
  `datereturn` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_penalty`
--

INSERT INTO `tbl_penalty` (`id`, `accession`, `barcode`, `rcbarcode`, `name`, `datereturn`) VALUES
(1, '002', '9780949023490', '003', 'Mary Rose Bolito', '11-29-2017');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_penaltyfee`
--

CREATE TABLE `tbl_penaltyfee` (
  `id` int(22) NOT NULL,
  `penaltyFee` varchar(22) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_penaltyfee`
--

INSERT INTO `tbl_penaltyfee` (`id`, `penaltyFee`) VALUES
(1, '2');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_returninside`
--

CREATE TABLE `tbl_returninside` (
  `id` int(11) NOT NULL,
  `borrow_id` int(11) NOT NULL,
  `date` varchar(20) NOT NULL,
  `time` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_returnoutside`
--

CREATE TABLE `tbl_returnoutside` (
  `id` int(11) NOT NULL,
  `borrow_id` int(11) NOT NULL,
  `date` varchar(30) NOT NULL,
  `time` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_returnoutside`
--

INSERT INTO `tbl_returnoutside` (`id`, `borrow_id`, `date`, `time`) VALUES
(1, 1, '11-29-2017', '06:57');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_student`
--

CREATE TABLE `tbl_student` (
  `id` int(11) NOT NULL,
  `Type` varchar(50) NOT NULL,
  `NameofSchool` varchar(50) NOT NULL,
  `Level` varchar(20) NOT NULL,
  `Comaker` varchar(50) NOT NULL,
  `Adviser` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_student`
--

INSERT INTO `tbl_student` (`id`, `Type`, `NameofSchool`, `Level`, `Comaker`, `Adviser`) VALUES
(1, 'Elementary', 'dsad', 'sda', 'asd', 'dsa'),
(2, 'Elementary', 'Cogon - Elementary School', 'Grade 1', 'Dennis Bajao', 'Delia Dalogdog'),
(3, 'College', 'BISU- Calape', '4th year', 'Nips Jonathan', 'Sir Ramo'),
(4, 'HighSchool', 'gsgsd', '3', 'gsds', 'gsgsdg'),
(5, 'Elementary', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_teacher`
--

CREATE TABLE `tbl_teacher` (
  `id` int(11) NOT NULL,
  `NameofSchool` varchar(50) NOT NULL,
  `Type` varchar(20) NOT NULL,
  `Level` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_transaction`
--

CREATE TABLE `tbl_transaction` (
  `id` int(11) NOT NULL,
  `Accession` varchar(11) NOT NULL,
  `ISBNBarcode` varchar(20) NOT NULL,
  `RCBarcode` varchar(20) NOT NULL,
  `Status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_transaction`
--

INSERT INTO `tbl_transaction` (`id`, `Accession`, `ISBNBarcode`, `RCBarcode`, `Status`) VALUES
(1, '14', '9780982390849', '004', 'BORROW INSIDE'),
(2, '2', '9780949023490', '004', 'BORROW INSIDE'),
(3, '2', '9780949023490', '003', 'BORROW OUTSIDE'),
(4, '002', '9780949023490', '003', 'BORROW INSIDE'),
(5, '346', '53235', '223423', 'BORROW INSIDE'),
(6, '346', '53235', '223423', 'BORROW INSIDE'),
(7, '224', '00976', '223423', 'BORROW INSIDE'),
(8, '2', '0094297', '223423', 'BORROW INSIDE'),
(9, '333', '09876655', '223423', 'BORROW OUTSIDE'),
(10, '33', '00796', '', 'RETURN FROM INSIDE'),
(11, '333', '00796', '', 'RETURN FROM INSIDE'),
(12, '002', '0094297', '', 'RETURN FROM INSIDE'),
(13, '224', '0094297', '223423', 'RETURN FROM INSIDE'),
(14, '346', '53235', '223423', 'RETURN FROM INSIDE'),
(15, '356', '9783423434232', '223423', 'BORRROW INSIDE'),
(16, '24', '326262', '223423', 'BORROW INSIDE'),
(17, '356', '9783423434232', '223423', 'RETURN FROM INSIDE'),
(18, '224', '00976', '34242', 'BORROW OUTSIDE'),
(19, '235', '93285', '34242', 'BORROW INSIDE'),
(20, '2', '9789719631200', '9789871234530', 'BORROW INSIDE');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_bookaccessions`
--
ALTER TABLE `tbl_bookaccessions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_booktype`
--
ALTER TABLE `tbl_booktype`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_borrowinside`
--
ALTER TABLE `tbl_borrowinside`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_borrowoutside`
--
ALTER TABLE `tbl_borrowoutside`
  ADD PRIMARY KEY (`id`),
  ADD KEY `category_id` (`category_id`);

--
-- Indexes for table `tbl_category`
--
ALTER TABLE `tbl_category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_cd`
--
ALTER TABLE `tbl_cd`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_cdaccession`
--
ALTER TABLE `tbl_cdaccession`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_cdtype`
--
ALTER TABLE `tbl_cdtype`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_clientregistration`
--
ALTER TABLE `tbl_clientregistration`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_clientrenewal`
--
ALTER TABLE `tbl_clientrenewal`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_journal`
--
ALTER TABLE `tbl_journal`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_journalaccession`
--
ALTER TABLE `tbl_journalaccession`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_librarybook`
--
ALTER TABLE `tbl_librarybook`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_librarynewspaper`
--
ALTER TABLE `tbl_librarynewspaper`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_login`
--
ALTER TABLE `tbl_login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_logintypeclient`
--
ALTER TABLE `tbl_logintypeclient`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_magazine`
--
ALTER TABLE `tbl_magazine`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_magazineaccession`
--
ALTER TABLE `tbl_magazineaccession`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_material`
--
ALTER TABLE `tbl_material`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`),
  ADD KEY `id_2` (`id`);

--
-- Indexes for table `tbl_matmonitoring`
--
ALTER TABLE `tbl_matmonitoring`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_newsaccession`
--
ALTER TABLE `tbl_newsaccession`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_penalty`
--
ALTER TABLE `tbl_penalty`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_penaltyfee`
--
ALTER TABLE `tbl_penaltyfee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_returninside`
--
ALTER TABLE `tbl_returninside`
  ADD PRIMARY KEY (`id`),
  ADD KEY `borrow_id` (`borrow_id`);

--
-- Indexes for table `tbl_returnoutside`
--
ALTER TABLE `tbl_returnoutside`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_student`
--
ALTER TABLE `tbl_student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_teacher`
--
ALTER TABLE `tbl_teacher`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_transaction`
--
ALTER TABLE `tbl_transaction`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_bookaccessions`
--
ALTER TABLE `tbl_bookaccessions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `tbl_booktype`
--
ALTER TABLE `tbl_booktype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tbl_borrowinside`
--
ALTER TABLE `tbl_borrowinside`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tbl_borrowoutside`
--
ALTER TABLE `tbl_borrowoutside`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tbl_category`
--
ALTER TABLE `tbl_category`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_cd`
--
ALTER TABLE `tbl_cd`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tbl_cdaccession`
--
ALTER TABLE `tbl_cdaccession`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `tbl_cdtype`
--
ALTER TABLE `tbl_cdtype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbl_clientregistration`
--
ALTER TABLE `tbl_clientregistration`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `tbl_clientrenewal`
--
ALTER TABLE `tbl_clientrenewal`
  MODIFY `id` int(22) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_journal`
--
ALTER TABLE `tbl_journal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_journalaccession`
--
ALTER TABLE `tbl_journalaccession`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tbl_librarybook`
--
ALTER TABLE `tbl_librarybook`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `tbl_librarynewspaper`
--
ALTER TABLE `tbl_librarynewspaper`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tbl_login`
--
ALTER TABLE `tbl_login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `tbl_logintypeclient`
--
ALTER TABLE `tbl_logintypeclient`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_magazine`
--
ALTER TABLE `tbl_magazine`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tbl_magazineaccession`
--
ALTER TABLE `tbl_magazineaccession`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tbl_material`
--
ALTER TABLE `tbl_material`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_matmonitoring`
--
ALTER TABLE `tbl_matmonitoring`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT for table `tbl_newsaccession`
--
ALTER TABLE `tbl_newsaccession`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tbl_penalty`
--
ALTER TABLE `tbl_penalty`
  MODIFY `id` int(22) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_penaltyfee`
--
ALTER TABLE `tbl_penaltyfee`
  MODIFY `id` int(22) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_returninside`
--
ALTER TABLE `tbl_returninside`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_returnoutside`
--
ALTER TABLE `tbl_returnoutside`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_student`
--
ALTER TABLE `tbl_student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_teacher`
--
ALTER TABLE `tbl_teacher`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_transaction`
--
ALTER TABLE `tbl_transaction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_borrowoutside`
--
ALTER TABLE `tbl_borrowoutside`
  ADD CONSTRAINT `tbl_borrowoutside_ibfk_4` FOREIGN KEY (`category_id`) REFERENCES `tbl_category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_material`
--
ALTER TABLE `tbl_material`
  ADD CONSTRAINT `tbl_material_ibfk_1` FOREIGN KEY (`id`) REFERENCES `tbl_borrowoutside` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
