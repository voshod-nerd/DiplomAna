-- phpMyAdmin SQL Dump
-- version 4.0.10.6
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1:3306
-- Время создания: Май 25 2016 г., 23:57
-- Версия сервера: 5.5.41-log
-- Версия PHP: 5.5.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `spring`
--

-- --------------------------------------------------------

--
-- Структура таблицы `bron`
--

CREATE TABLE IF NOT EXISTS `bron` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateb` date DEFAULT NULL,
  `datee` date DEFAULT NULL,
  `idorg` int(11) DEFAULT NULL,
  `idnomer` int(11) DEFAULT NULL,
  `summapred` decimal(10,0) DEFAULT NULL,
  `idclient` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrehu4x0brak0e80v4qys84ji` (`idorg`),
  KEY `FKnk48sef8uh41cx5y1w5b36q59` (`idnomer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Структура таблицы `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DATAOKON` date DEFAULT NULL,
  `DATAVID` date DEFAULT NULL,
  `DR` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `FIO` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEMVIDAN` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NUMBERDOC` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `POL` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROGCLIENT` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SERDOC` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `idorg` int(11) DEFAULT NULL,
  `FIOENG` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `VIDDOCK` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `STRANA` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `ADRES` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKotg2j42hgv9vc5t33p0nrirhr` (`idorg`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Структура таблицы `DOLGNOST`
--

CREATE TABLE IF NOT EXISTS `DOLGNOST` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DOLGNOST` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Структура таблицы `grafik`
--

CREATE TABLE IF NOT EXISTS `grafik` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idsotrudnik` int(11) DEFAULT NULL,
  `dayd` date DEFAULT NULL,
  `idhotel` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_grafik_SOTRUDNIK_ID` (`idsotrudnik`),
  KEY `FK_grafik` (`idhotel`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=4 ;

--
-- Дамп данных таблицы `grafik`
--

INSERT INTO `grafik` (`id`, `idsotrudnik`, `dayd`, `idhotel`) VALUES
(1, 2, '2016-05-24', 3),
(2, 1, '2016-05-25', 5),
(3, 2, '2016-05-26', 4);

-- --------------------------------------------------------

--
-- Структура таблицы `HOTEL`
--

CREATE TABLE IF NOT EXISTS `HOTEL` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LOCATION` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=6 ;

--
-- Дамп данных таблицы `HOTEL`
--

INSERT INTO `HOTEL` (`ID`, `LOCATION`, `NAME`) VALUES
(1, 'площадка №95', 'Фили'),
(2, 'площадка №95', 'Полет'),
(3, 'площадка №95', 'Комета'),
(4, 'площадка №95', 'Космос'),
(5, 'площадка №95', 'Космоси');

-- --------------------------------------------------------

--
-- Структура таблицы `NOMERHOTEL`
--

CREATE TABLE IF NOT EXISTS `NOMERHOTEL` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NUMBER` int(11) DEFAULT NULL,
  `READY` bit(1) DEFAULT NULL,
  `IDGOSTIN` int(11) DEFAULT NULL,
  `TYPENOMER` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKdbe59weqfo2egv6y3auxtdrfi` (`IDGOSTIN`),
  KEY `FKf3rh1lwcmexou66eccq7uhxk6` (`TYPENOMER`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

--
-- Дамп данных таблицы `NOMERHOTEL`
--

INSERT INTO `NOMERHOTEL` (`ID`, `NUMBER`, `READY`, `IDGOSTIN`, `TYPENOMER`) VALUES
(1, 1, NULL, 1, 1),
(2, 2, NULL, 1, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `ORGANIZATION`
--

CREATE TABLE IF NOT EXISTS `ORGANIZATION` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ADRES` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `FIOPREDSTAVITEL` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `MAIL` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PHONE` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `iduser` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `INN` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `OGRN` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KPP` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ORGANIZATION` (`iduser`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

--
-- Дамп данных таблицы `ORGANIZATION`
--

INSERT INTO `ORGANIZATION` (`ID`, `ADRES`, `FIOPREDSTAVITEL`, `MAIL`, `NAME`, `PHONE`, `iduser`, `INN`, `OGRN`, `KPP`) VALUES
(1, NULL, NULL, NULL, 'НАСА', 'НАСА', NULL, NULL, NULL, NULL),
(2, NULL, NULL, NULL, 'РОСКОСМОС', 'РОСКОСМОС', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `otpusk`
--

CREATE TABLE IF NOT EXISTS `otpusk` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idsotr` int(11) DEFAULT NULL,
  `dateb` date DEFAULT NULL,
  `dateend` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_otpusk_SOTRUDNIK_ID` (`idsotr`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

--
-- Дамп данных таблицы `otpusk`
--

INSERT INTO `otpusk` (`id`, `idsotr`, `dateb`, `dateend`) VALUES
(1, 2, '2016-05-01', '2016-05-30'),
(2, 2, '2016-05-15', '2016-05-31');

-- --------------------------------------------------------

--
-- Структура таблицы `pitanie`
--

CREATE TABLE IF NOT EXISTS `pitanie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

--
-- Дамп данных таблицы `pitanie`
--

INSERT INTO `pitanie` (`id`, `name`) VALUES
(1, 'стандарт'),
(2, 'эконом');

-- --------------------------------------------------------

--
-- Структура таблицы `progivanie`
--

CREATE TABLE IF NOT EXISTS `progivanie` (
  `id` int(11) NOT NULL,
  `datein` date DEFAULT NULL,
  `dateout` date DEFAULT NULL,
  `dopusl` bigint(20) DEFAULT NULL,
  `totalsum` bigint(20) DEFAULT NULL,
  `idclient` int(11) DEFAULT NULL,
  `idnomer` int(11) DEFAULT NULL,
  `idstoimostnomer` int(11) DEFAULT NULL,
  `idstoimostpit` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1su9cbh9t5g7m05e4b3jjemhd` (`idclient`),
  KEY `FK3n9ue0sgf1ypr0xb1c0i22xss` (`idnomer`),
  KEY `FKhy4nb69uvx7rfw6ucos98ww8f` (`idstoimostnomer`),
  KEY `FKpprc9x4br90hqi82wayqppspq` (`idstoimostpit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Структура таблицы `program`
--

CREATE TABLE IF NOT EXISTS `program` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateb` date DEFAULT NULL,
  `dateend` date DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `idorganization` int(11) DEFAULT NULL,
  `idtarif` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkn2vksx3cam3j0efukwuvylt7` (`idorganization`),
  KEY `FKodmuvrhtl1xkqdru3ao4boupn` (`idtarif`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=5 ;

--
-- Дамп данных таблицы `program`
--

INSERT INTO `program` (`id`, `dateb`, `dateend`, `name`, `idorganization`, `idtarif`) VALUES
(3, '2016-05-23', '2016-05-19', 'Летная программа №1', 1, 2),
(4, '2016-05-25', '2016-05-27', 'Летная программа №2', 2, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `reestruslug`
--

CREATE TABLE IF NOT EXISTS `reestruslug` (
  `id` int(11) NOT NULL,
  `idclient` int(11) DEFAULT NULL,
  `idstoimostuslig` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5arqqm20mxs44vp7v77edkwx` (`idstoimostuslig`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Структура таблицы `SOTRUDNIK`
--

CREATE TABLE IF NOT EXISTS `SOTRUDNIK` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DR` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `FIO` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `GRAG` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NUM` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SER` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `IDDOLGNOST` int(11) DEFAULT NULL,
  `iduser` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KOGDAVIDAN` date DEFAULT NULL,
  `KEMVIDAN` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `DOCLICH` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `EDUCATION` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `ADRES` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `PHONE` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `KOLDET` int(11) DEFAULT NULL,
  `MR` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `TABNOMER` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKooegclw6qurgdyhdltf8mkp2s` (`IDDOLGNOST`),
  KEY `FKnvasngl2883tn199r3n99yl85` (`iduser`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

--
-- Дамп данных таблицы `SOTRUDNIK`
--

INSERT INTO `SOTRUDNIK` (`ID`, `DR`, `FIO`, `GRAG`, `NUM`, `SER`, `IDDOLGNOST`, `iduser`, `KOGDAVIDAN`, `KEMVIDAN`, `DOCLICH`, `EDUCATION`, `ADRES`, `PHONE`, `KOLDET`, `MR`, `TABNOMER`) VALUES
(1, NULL, 'Соколов Олег', NULL, NULL, NULL, NULL, NULL, '2016-05-25', '', '', '', '', '', 0, '', NULL),
(2, NULL, 'Марина', NULL, NULL, NULL, NULL, NULL, '2016-05-24', '', '', '', '', '', 0, '', NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `stimostpitan`
--

CREATE TABLE IF NOT EXISTS `stimostpitan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idpitanie` int(11) DEFAULT NULL,
  `idtarif` int(11) DEFAULT NULL,
  `sum` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK95pwusho8x9227m3r387mk848` (`idpitanie`),
  KEY `FKakridlc05bfr9prbvp07mntbc` (`idtarif`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=2 ;

--
-- Дамп данных таблицы `stimostpitan`
--

INSERT INTO `stimostpitan` (`id`, `idpitanie`, `idtarif`, `sum`) VALUES
(1, 1, 1, '2500');

-- --------------------------------------------------------

--
-- Структура таблицы `stoimostnomera`
--

CREATE TABLE IF NOT EXISTS `stoimostnomera` (
  `id` int(11) NOT NULL,
  `idtarif` int(11) DEFAULT NULL,
  `summa` bigint(20) DEFAULT NULL,
  `idtypenomer` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh0u14ef6c7et25xvt5xnypyn9` (`idtypenomer`),
  KEY `FK_stoimostnomera` (`idtarif`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Структура таблицы `stoimostuslug`
--

CREATE TABLE IF NOT EXISTS `stoimostuslug` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `summa` bigint(20) DEFAULT NULL,
  `idtarif` int(11) DEFAULT NULL,
  `iduslug` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo0qkk3tnvqqk82fjjq9i65f5i` (`idtarif`),
  KEY `FKfrdy4adv7wqpqp0mkvwgbc00n` (`iduslug`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Структура таблицы `tarifz`
--

CREATE TABLE IF NOT EXISTS `tarifz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

--
-- Дамп данных таблицы `tarifz`
--

INSERT INTO `tarifz` (`id`, `name`) VALUES
(1, 'местный'),
(2, 'зарубежный');

-- --------------------------------------------------------

--
-- Структура таблицы `TYPENOMERHOTEL`
--

CREATE TABLE IF NOT EXISTS `TYPENOMERHOTEL` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MEST` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

--
-- Дамп данных таблицы `TYPENOMERHOTEL`
--

INSERT INTO `TYPENOMERHOTEL` (`ID`, `MEST`, `TYPE`) VALUES
(1, '2', 'стандарт'),
(2, '1', 'стандарт');

-- --------------------------------------------------------

--
-- Структура таблицы `TYPEZA`
--

CREATE TABLE IF NOT EXISTS `TYPEZA` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

--
-- Дамп данных таблицы `TYPEZA`
--

INSERT INTO `TYPEZA` (`ID`, `NAME`) VALUES
(1, 'поломка крана'),
(2, 'поломка кондиционера');

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(45) COLLATE utf8_bin NOT NULL,
  `password` varchar(60) COLLATE utf8_bin NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`username`, `password`, `enabled`) VALUES
('alex', '$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', 1),
('mkyong', '$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', 1);

-- --------------------------------------------------------

--
-- Структура таблицы `user_roles`
--

CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) COLLATE utf8_bin NOT NULL,
  `role` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `uni_username_role` (`role`,`username`),
  KEY `fk_username_idx` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=4 ;

--
-- Дамп данных таблицы `user_roles`
--

INSERT INTO `user_roles` (`user_role_id`, `username`, `role`) VALUES
(2, 'mkyong', 'ROLE_ADMIN'),
(3, 'alex', 'ROLE_USER'),
(1, 'mkyong', 'ROLE_USER');

-- --------------------------------------------------------

--
-- Структура таблицы `uslug`
--

CREATE TABLE IF NOT EXISTS `uslug` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Структура таблицы `VIZA`
--

CREATE TABLE IF NOT EXISTS `VIZA` (
  `ID` int(11) NOT NULL,
  `BEG` date DEFAULT NULL,
  `END` date DEFAULT NULL,
  `Idclient` int(11) DEFAULT NULL,
  `NUMBER` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_VIZA_client_ID` (`Idclient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Структура таблицы `ZAYVKA`
--

CREATE TABLE IF NOT EXISTS `ZAYVKA` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DATEZ` date DEFAULT NULL,
  `DATEZAV` date DEFAULT NULL,
  `STATUS` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `IDNOMER` int(11) DEFAULT NULL,
  `IDSOTR` int(11) DEFAULT NULL,
  `TYPEZ` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK1qgk6tj43wi4hx48j02ihthq3` (`IDNOMER`),
  KEY `FK41li11b46iw0xadudexw9upoq` (`IDSOTR`),
  KEY `FKdir7ncbitfug9yg6pkp73q5lv` (`TYPEZ`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=4 ;

--
-- Дамп данных таблицы `ZAYVKA`
--

INSERT INTO `ZAYVKA` (`ID`, `DATEZ`, `DATEZAV`, `STATUS`, `IDNOMER`, `IDSOTR`, `TYPEZ`) VALUES
(2, '2016-05-10', '2016-05-10', 'неготов', 1, 2, 1),
(3, '2016-05-19', '2016-05-19', NULL, 2, 1, 2);

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `bron`
--
ALTER TABLE `bron`
  ADD CONSTRAINT `FKnk48sef8uh41cx5y1w5b36q59` FOREIGN KEY (`idnomer`) REFERENCES `nomerhotel` (`ID`),
  ADD CONSTRAINT `FK_bron_ORGANIZATION_ID` FOREIGN KEY (`idorg`) REFERENCES `organization` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FK_client_ORGANIZATION_ID` FOREIGN KEY (`idorg`) REFERENCES `organization` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `grafik`
--
ALTER TABLE `grafik`
  ADD CONSTRAINT `FK_grafik` FOREIGN KEY (`idhotel`) REFERENCES `hotel` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_grafik_SOTRUDNIK_ID` FOREIGN KEY (`idsotrudnik`) REFERENCES `sotrudnik` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `NOMERHOTEL`
--
ALTER TABLE `NOMERHOTEL`
  ADD CONSTRAINT `FKdbe59weqfo2egv6y3auxtdrfi` FOREIGN KEY (`IDGOSTIN`) REFERENCES `hotel` (`ID`),
  ADD CONSTRAINT `FKf3rh1lwcmexou66eccq7uhxk6` FOREIGN KEY (`TYPENOMER`) REFERENCES `typenomerhotel` (`ID`);

--
-- Ограничения внешнего ключа таблицы `ORGANIZATION`
--
ALTER TABLE `ORGANIZATION`
  ADD CONSTRAINT `FK_ORGANIZATION_user_username` FOREIGN KEY (`iduser`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `otpusk`
--
ALTER TABLE `otpusk`
  ADD CONSTRAINT `FK_otpusk_SOTRUDNIK_ID` FOREIGN KEY (`idsotr`) REFERENCES `sotrudnik` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `progivanie`
--
ALTER TABLE `progivanie`
  ADD CONSTRAINT `FK1su9cbh9t5g7m05e4b3jjemhd` FOREIGN KEY (`idclient`) REFERENCES `client` (`ID`),
  ADD CONSTRAINT `FK3n9ue0sgf1ypr0xb1c0i22xss` FOREIGN KEY (`idnomer`) REFERENCES `nomerhotel` (`ID`),
  ADD CONSTRAINT `FKhy4nb69uvx7rfw6ucos98ww8f` FOREIGN KEY (`idstoimostnomer`) REFERENCES `stoimostnomera` (`id`),
  ADD CONSTRAINT `FKpprc9x4br90hqi82wayqppspq` FOREIGN KEY (`idstoimostpit`) REFERENCES `stimostpitan` (`id`);

--
-- Ограничения внешнего ключа таблицы `program`
--
ALTER TABLE `program`
  ADD CONSTRAINT `FKkn2vksx3cam3j0efukwuvylt7` FOREIGN KEY (`idorganization`) REFERENCES `organization` (`ID`),
  ADD CONSTRAINT `FKodmuvrhtl1xkqdru3ao4boupn` FOREIGN KEY (`idtarif`) REFERENCES `tarifz` (`id`);

--
-- Ограничения внешнего ключа таблицы `reestruslug`
--
ALTER TABLE `reestruslug`
  ADD CONSTRAINT `FK5arqqm20mxs44vp7v77edkwx` FOREIGN KEY (`idstoimostuslig`) REFERENCES `stoimostuslug` (`id`);

--
-- Ограничения внешнего ключа таблицы `SOTRUDNIK`
--
ALTER TABLE `SOTRUDNIK`
  ADD CONSTRAINT `FK_SOTRUDNIK` FOREIGN KEY (`iduser`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FKooegclw6qurgdyhdltf8mkp2s` FOREIGN KEY (`IDDOLGNOST`) REFERENCES `dolgnost` (`ID`);

--
-- Ограничения внешнего ключа таблицы `stimostpitan`
--
ALTER TABLE `stimostpitan`
  ADD CONSTRAINT `FK95pwusho8x9227m3r387mk848` FOREIGN KEY (`idpitanie`) REFERENCES `pitanie` (`id`),
  ADD CONSTRAINT `FKakridlc05bfr9prbvp07mntbc` FOREIGN KEY (`idtarif`) REFERENCES `tarifz` (`id`);

--
-- Ограничения внешнего ключа таблицы `stoimostnomera`
--
ALTER TABLE `stoimostnomera`
  ADD CONSTRAINT `FKh0u14ef6c7et25xvt5xnypyn9` FOREIGN KEY (`idtypenomer`) REFERENCES `typenomerhotel` (`ID`),
  ADD CONSTRAINT `FK_stoimostnomera` FOREIGN KEY (`idtarif`) REFERENCES `tarifz` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `stoimostuslug`
--
ALTER TABLE `stoimostuslug`
  ADD CONSTRAINT `FKfrdy4adv7wqpqp0mkvwgbc00n` FOREIGN KEY (`iduslug`) REFERENCES `uslug` (`id`),
  ADD CONSTRAINT `FKo0qkk3tnvqqk82fjjq9i65f5i` FOREIGN KEY (`idtarif`) REFERENCES `tarifz` (`id`);

--
-- Ограничения внешнего ключа таблицы `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `fk_username` FOREIGN KEY (`username`) REFERENCES `user` (`username`);

--
-- Ограничения внешнего ключа таблицы `VIZA`
--
ALTER TABLE `VIZA`
  ADD CONSTRAINT `FK_VIZA_client_ID` FOREIGN KEY (`Idclient`) REFERENCES `client` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `ZAYVKA`
--
ALTER TABLE `ZAYVKA`
  ADD CONSTRAINT `FK1qgk6tj43wi4hx48j02ihthq3` FOREIGN KEY (`IDNOMER`) REFERENCES `nomerhotel` (`ID`),
  ADD CONSTRAINT `FK41li11b46iw0xadudexw9upoq` FOREIGN KEY (`IDSOTR`) REFERENCES `sotrudnik` (`ID`),
  ADD CONSTRAINT `FKdir7ncbitfug9yg6pkp73q5lv` FOREIGN KEY (`TYPEZ`) REFERENCES `typeza` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
