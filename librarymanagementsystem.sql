-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 22, 2020 at 07:28 AM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `librarymanagementsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admin`
--

CREATE TABLE IF NOT EXISTS `tbl_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminBarcode` varchar(50) NOT NULL,
  `Firstname` varchar(50) NOT NULL,
  `MiddleName` varchar(50) NOT NULL,
  `Lastname` varchar(50) NOT NULL,
  `Age` int(11) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `ConfirmPass` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `tbl_admin`
--

INSERT INTO `tbl_admin` (`id`, `adminBarcode`, `Firstname`, `MiddleName`, `Lastname`, `Age`, `Gender`, `Address`, `Username`, `Password`, `ConfirmPass`) VALUES
(4, '002', 'rose', 'panganoron', 'bolito', 25, 'FEMALE', 'balilihan', 'rosetest', '[C@f6abf36', '[C@4d6a7d66');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_androidborrow`
--

CREATE TABLE IF NOT EXISTS `tbl_androidborrow` (
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

CREATE TABLE IF NOT EXISTS `tbl_bookaccessions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accessID` int(20) NOT NULL,
  `ISBNBarcode` varchar(20) NOT NULL,
  `BookTitle` varchar(55) NOT NULL,
  `BookAuthor` varchar(55) NOT NULL,
  `BookPublisher` varchar(55) NOT NULL,
  `BookType` varchar(55) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_booktype`
--

CREATE TABLE IF NOT EXISTS `tbl_booktype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `booktype` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

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

CREATE TABLE IF NOT EXISTS `tbl_borrowinside` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `material` varchar(20) NOT NULL,
  `accession_number` int(20) NOT NULL,
  `ISBNBarcode` varchar(20) NOT NULL,
  `CopiesAvailable` int(20) NOT NULL,
  `borrower_barcode` varchar(20) NOT NULL,
  `date` varchar(20) NOT NULL,
  `time` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_borrowoutside`
--

CREATE TABLE IF NOT EXISTS `tbl_borrowoutside` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `material` varchar(20) NOT NULL,
  `accession_number` varchar(20) NOT NULL,
  `ISBNBarcode` varchar(20) NOT NULL,
  `borrower_barcode` varchar(20) NOT NULL,
  `date_to_return` varchar(20) NOT NULL,
  `category_id` int(5) NOT NULL,
  `date` varchar(20) NOT NULL,
  `time` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

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

CREATE TABLE IF NOT EXISTS `tbl_category` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `category` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

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

CREATE TABLE IF NOT EXISTS `tbl_cd` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cd_Barcode` varchar(20) NOT NULL,
  `cd_DateAcquisition` varchar(50) NOT NULL,
  `cd_Title` varchar(50) NOT NULL,
  `cd_EditionNumber` int(4) NOT NULL,
  `cd_Place` varchar(50) NOT NULL,
  `cd_Producer` varchar(50) NOT NULL,
  `cd_Year` int(4) NOT NULL,
  `cd_Genre` varchar(50) NOT NULL,
  `Copies` int(11) NOT NULL,
  `Status` varchar(20) NOT NULL,
  `days` varchar(10) NOT NULL,
  `Availability` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_cdaccession`
--

CREATE TABLE IF NOT EXISTS `tbl_cdaccession` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accession` int(20) NOT NULL,
  `ISBNBarcode` varchar(20) NOT NULL,
  `Title` varchar(55) NOT NULL,
  `Genre` varchar(55) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_cdtype`
--

CREATE TABLE IF NOT EXISTS `tbl_cdtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cdtype` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

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

CREATE TABLE IF NOT EXISTS `tbl_clientregistration` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
  `Password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_clientrenewal`
--

CREATE TABLE IF NOT EXISTS `tbl_clientrenewal` (
  `id` int(22) NOT NULL AUTO_INCREMENT,
  `rcbarcode` varchar(22) NOT NULL,
  `dateexpired` varchar(50) NOT NULL,
  `daterenew` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_journal`
--

CREATE TABLE IF NOT EXISTS `tbl_journal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
  `Copies` int(11) NOT NULL,
  `Status` varchar(20) NOT NULL,
  `days` varchar(10) NOT NULL,
  `Availability` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_journalaccession`
--

CREATE TABLE IF NOT EXISTS `tbl_journalaccession` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accession` int(20) NOT NULL,
  `ISBNBarcode` varchar(20) NOT NULL,
  `Title` varchar(55) NOT NULL,
  `Author` varchar(55) NOT NULL,
  `Publisher` varchar(55) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_librarybook`
--

CREATE TABLE IF NOT EXISTS `tbl_librarybook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
  `Copies` int(11) NOT NULL,
  `Status` varchar(20) NOT NULL,
  `days` varchar(10) NOT NULL,
  `Availability` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_librarynewspaper`
--

CREATE TABLE IF NOT EXISTS `tbl_librarynewspaper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ISBNBarcode` varchar(20) NOT NULL,
  `NType` varchar(50) NOT NULL,
  `NHeading` varchar(50) NOT NULL,
  `NVolume` varchar(10) NOT NULL,
  `NDateReceive` varchar(50) NOT NULL,
  `Copies` int(11) NOT NULL,
  `Status` varchar(20) NOT NULL,
  `days` varchar(12) NOT NULL,
  `Availability` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_login`
--

CREATE TABLE IF NOT EXISTS `tbl_login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminBarcode` varchar(20) NOT NULL,
  `administrator` varchar(50) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

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

CREATE TABLE IF NOT EXISTS `tbl_logintypeclient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

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

CREATE TABLE IF NOT EXISTS `tbl_magazine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ISBNBarcode` varchar(20) NOT NULL,
  `DateAcquisition` varchar(20) NOT NULL,
  `M_Title` varchar(50) NOT NULL,
  `M_Publisher` varchar(50) NOT NULL,
  `EditionNumber` int(5) NOT NULL,
  `PageVolume` int(5) NOT NULL,
  `Place` varchar(50) NOT NULL,
  `Year` int(4) NOT NULL,
  `Copies` int(11) NOT NULL,
  `Status` varchar(20) NOT NULL,
  `days` varchar(10) NOT NULL,
  `Availability` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_magazineaccession`
--

CREATE TABLE IF NOT EXISTS `tbl_magazineaccession` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accession` int(20) NOT NULL,
  `ISBNBarcode` varchar(20) NOT NULL,
  `Title` varchar(55) NOT NULL,
  `EdNum` int(11) NOT NULL,
  `Publisher` varchar(55) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_material`
--

CREATE TABLE IF NOT EXISTS `tbl_material` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `material` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `id_2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_matmonitoring`
--

CREATE TABLE IF NOT EXISTS `tbl_matmonitoring` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accession` varchar(11) NOT NULL,
  `barcode` varchar(22) NOT NULL,
  `status` varchar(22) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_newsaccession`
--

CREATE TABLE IF NOT EXISTS `tbl_newsaccession` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accession` int(20) NOT NULL,
  `ISBNBarcode` varchar(20) NOT NULL,
  `title` varchar(55) NOT NULL,
  `volume` int(22) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `tbl_newsaccession`
--

INSERT INTO `tbl_newsaccession` (`id`, `accession`, `ISBNBarcode`, `title`, `volume`) VALUES
(1, 22, '326262', 'tdgsg', 3242),
(2, 23, '326262', 'tdgsg', 3242),
(3, 24, '326262', 'tdgsg', 3242),
(4, 332, '09876655', 'sdfg', 2222),
(5, 333, '09876655', 'sdfg', 2222),
(6, 211, '35253', 'fwe', 32),
(7, 212, '35253', 'fwe', 32);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_penalty`
--

CREATE TABLE IF NOT EXISTS `tbl_penalty` (
  `id` int(22) NOT NULL AUTO_INCREMENT,
  `accession` varchar(22) NOT NULL,
  `barcode` varchar(22) NOT NULL,
  `rcbarcode` varchar(22) NOT NULL,
  `name` varchar(50) NOT NULL,
  `datereturn` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `tbl_penalty`
--

INSERT INTO `tbl_penalty` (`id`, `accession`, `barcode`, `rcbarcode`, `name`, `datereturn`) VALUES
(1, '002', '9780949023490', '003', 'Mary Rose Bolito', '11-29-2017');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_penaltyfee`
--

CREATE TABLE IF NOT EXISTS `tbl_penaltyfee` (
  `id` int(22) NOT NULL AUTO_INCREMENT,
  `penaltyFee` varchar(22) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `tbl_penaltyfee`
--

INSERT INTO `tbl_penaltyfee` (`id`, `penaltyFee`) VALUES
(1, '2');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_returninside`
--

CREATE TABLE IF NOT EXISTS `tbl_returninside` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `borrow_id` int(11) NOT NULL,
  `date` varchar(20) NOT NULL,
  `time` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `borrow_id` (`borrow_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_returnoutside`
--

CREATE TABLE IF NOT EXISTS `tbl_returnoutside` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `borrow_id` int(11) NOT NULL,
  `date` varchar(30) NOT NULL,
  `time` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `tbl_returnoutside`
--

INSERT INTO `tbl_returnoutside` (`id`, `borrow_id`, `date`, `time`) VALUES
(1, 1, '11-29-2017', '06:57');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_student`
--

CREATE TABLE IF NOT EXISTS `tbl_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Type` varchar(50) NOT NULL,
  `NameofSchool` varchar(50) NOT NULL,
  `Level` varchar(20) NOT NULL,
  `Comaker` varchar(50) NOT NULL,
  `Adviser` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

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

CREATE TABLE IF NOT EXISTS `tbl_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NameofSchool` varchar(50) NOT NULL,
  `Type` varchar(20) NOT NULL,
  `Level` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_transaction`
--

CREATE TABLE IF NOT EXISTS `tbl_transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Accession` varchar(11) NOT NULL,
  `ISBNBarcode` varchar(20) NOT NULL,
  `RCBarcode` varchar(20) NOT NULL,
  `Status` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
