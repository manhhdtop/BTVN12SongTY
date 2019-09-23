-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th9 23, 2019 lúc 01:15 PM
-- Phiên bản máy phục vụ: 10.1.40-MariaDB
-- Phiên bản PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `itlab4`
--

CREATE DATABASE IF NOT EXISTS `itlab4`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `person`
--

CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `birth_of_date` double DEFAULT NULL,
  `gender` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `person`
--

INSERT INTO `person` (`id`, `name`, `birth_of_date`, `gender`) VALUES
(1, 'Truong Viet Hoang', 852051600000, 1),
(2, 'Tran Thu Huong', 854816400000, 0),
(3, 'Nguyen Ba Khanh', 857581200000, 1),
(4, 'Pham Thanh Binh', 860346000000, 1),
(5, 'Nguyen Van Hoang', 863110800000, 1),
(6, 'Do Thuy Nga', 865875600000, 0),
(7, 'Le Tu Anh', 868640400000, 1),
(8, 'Nguyen Van Linh', 871405200000, 1),
(9, 'Le Xuan Truong', 874170000000, 1),
(10, 'Vu Minh Thang', 876934800000, 1),
(11, 'Bui Van Hoa', 879699600000, 1),
(12, 'Hoang Duc Manh', 832093200000, 1),
(13, 'Nguyen Minh Chi', 885229200000, 1),
(14, 'Le Tien Thinh', 887994000000, 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `person`
--
ALTER TABLE `person`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
